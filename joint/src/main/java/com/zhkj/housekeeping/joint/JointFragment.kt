package com.zhkj.housekeeping.joint

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.sunny.zy.fragment.PullRefreshFragment
import com.zhkj.housekeeping.joint.adapter.JointAdapter
import com.zhkj.housekeeping.joint.bean.JointBean
import com.zhkj.housekeeping.joint.contract.JointContract
import com.zhkj.housekeeping.joint.presenter.JointPresenter
import kotlinx.coroutines.cancel

class JointFragment : PullRefreshFragment<JointBean>(), JointContract.IJointListView {
    var type = 0

    private val jointAdapter: JointAdapter by lazy {
        JointAdapter().apply {
            setOnItemClickListener { _, i ->
                showSelectDialog(i)
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
                val type = when (index) {
                    0 -> JointCreateActivity.TYPE_PREVIEW
                    1 -> JointCreateActivity.TYPE_MODIFY
                    else -> 3
                }
                if (type == 3) {
                    showDeleteDialog(jointAdapter.getData(position).synergyId.toString())
                } else {
//                    ZyFrameStore.setData("joinStateList", joinStateList)
//                    ZyFrameStore.setData("jointBean", jointAdapter.getData(position))
                    val intent = Intent(requireContext(), JointCreateActivity::class.java)
                    intent.putExtra("type", type)
                    startActivityForResult(intent, 200)
                }
            }.show()
    }


    /**
     * 删除协同对话框
     */
    private fun showDeleteDialog(id: String) {
        AlertDialog.Builder(requireContext()).setTitle("删除协同")
            .setMessage("是否确认删除协同？")
            .setNegativeButton("删除") { _: DialogInterface, _: Int ->
//                getBaseActivity().launch(Main) {
//                    jointViewModel.deleteJoint(id)
//                }

            }.setPositiveButton("取消") { _: DialogInterface, _: Int -> }
            .show()
    }

    override fun showJointList(data: ArrayList<JointBean>) {
        addData(data)
    }
}