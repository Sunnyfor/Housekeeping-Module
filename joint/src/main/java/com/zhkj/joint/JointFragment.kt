package com.zhkj.joint

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.joint.adapter.JointAdapter
import com.zhkj.joint.bean.JointBean
import com.zhkj.joint.contract.JointContract
import com.zhkj.joint.presenter.JointPresenter
import kotlinx.coroutines.cancel

class JointFragment : PullRefreshFragment<JointBean>(), JointContract.IJointListView,
    JointContract.IJointDeleteView {
    var type = 0

    private val jointAdapter: JointAdapter by lazy {
        JointAdapter().apply {
            setOnItemClickListener { _, i ->
                if (type == 0) {
                    showSelectDialog(i)
                } else {
                    ZyFrameStore.setData("jointBean", getData(i))
                    ARouter.getInstance().build(RouterPath.JOINT_DETAIL_ACTIVITY)
                        .navigation()
                }
            }
        }
    }

    private val jointPresenter: JointPresenter by lazy {
        JointPresenter(this)
    }


    override fun initView() {

        loadData = {
            loadData()
        }

        adapter = jointAdapter

        super.initView()

        showLoading()
    }

    override fun loadData() {
        jointPresenter.loadJointList(page, type)
    }

    override fun close() {
        jointPresenter.cancel()
    }


    private fun showSelectDialog(position: Int) {
        AlertDialog.Builder(requireContext()).setTitle("选择功能")
            .setItems(
                arrayOf(
                    "查看协同",
                    "修改协同",
                    "删除协同"
                )
            ) { dialogInterface: DialogInterface, index: Int ->
                dialogInterface.dismiss()

                when (index) {
                    0 -> {
                        ZyFrameStore.setData("jointBean", adapter?.getData(position))
                        ARouter.getInstance().build(RouterPath.JOINT_DETAIL_ACTIVITY)
                            .navigation()
                    }
                    1 -> {
                        ZyFrameStore.setData("jointBean", adapter?.getData(position))
                        ARouter.getInstance().build(RouterPath.JOINT_CREATE_ACTIVITY)
                            .navigation(getBaseActivity(), 11000)
                    }
                    2 -> showDeleteDialog(jointAdapter.getData(position))
                }
            }.show()
    }


    /**
     * 删除协同对话框
     */
    private fun showDeleteDialog(bean: JointBean) {
        AlertDialog.Builder(requireContext()).setTitle("删除协同")
            .setMessage("是否确认删除《${bean.synergyTitle}》？")
            .setPositiveButton("删除") { _: DialogInterface, _: Int ->
                jointPresenter.deleteJoint(bean.synergyId.toString())
            }.setNegativeButton("取消") { _: DialogInterface, _: Int -> }
            .show()
    }

    override fun showJointList(data: ArrayList<JointBean>) {
        addData(data)
    }

    override fun showDeleteJointResult(id: String) {
        getAllData()?.find { it.synergyId.toString() == id }?.let {
            deleteData(it)
        }
    }
}