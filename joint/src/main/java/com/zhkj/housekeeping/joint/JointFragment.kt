package com.zhkj.housekeeping.joint

import android.content.DialogInterface
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.housekeeping.work.joint.bean.JointBean
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.bean.Dictionary
import com.sunny.zy.fragment.PullRefreshFragment
import com.zhkj.housekeeping.joint.adapter.JointAdapter
import com.zhkj.housekeeping.joint.presenter.JointPresenter
import com.zhkj.housekeeping.joint.view.IJointView

class JointFragment : PullRefreshFragment<Dictionary>(), IJointView {
    var type = 0
    var joinStateList: ArrayList<Dictionary>? = null


//    private val jointAdapter: JointAdapter by lazy {
//        JointAdapter(
//            jointPresenter.getJointList(type, Observer { pageResult(it) })
//        ).apply {
//            setOnItemClickListener { _, i ->
//                if (type == 2) {
//                    return@setOnItemClickListener
//                }
//                showSelectDialog(i)
//            }
//        }
//
//    }

    private val jointPresenter: JointPresenter by lazy {
        JointPresenter(this)
    }


    override fun loadData() {
//        if (type == 2) {
//            jointPresenter.loadJointRecycle()
//        } else {
//            jointPresenter.loadJointList(page, type)
//        }
    }

    override fun close() {
    }
//
//    override fun onClick(v: View?) {
//    }
//
//    override fun initLayoutManager(): RecyclerView.LayoutManager = LinearLayoutManager(context)
//
//    override fun initBaseRecyclerAdapter(): BaseRecycleAdapter<*> {
//        return jointAdapter
//    }
//
//    override fun onUpdateData() {
//        loadData()
//    }

//
//    private fun pageResult(list: ArrayList<JointBean>) {
//        if (page == 1) {
//            finishRefresh()
//            jointAdapter.clearData()
//            if (list.isNullOrEmpty()) {
//                showEmptyView()
//            } else {
//                hideEmptyView()
//            }
//        } else {
//            finishLoadMore()
//        }
//
//        list.forEach { bean ->
//            bean.stateName = joinStateList?.find { it.code == bean.state }?.value ?: ""
//        }
//        jointAdapter.notifyDataSetChanged()
//    }


//    private fun showSelectDialog(position: Int) {
//        AlertDialog.Builder(requireContext()).setTitle("选择功能")
//            .setItems(
//                arrayOf(
//                    "查看协同",
//                    "修改协同",
//                    "删除协同"
//                )
//            ) { dialogInterface: DialogInterface, index: Int ->
//                dialogInterface.dismiss()
//                val type = when (index) {
//                    0 -> JointCreateActivity.TYPE_PREVIEW
//                    1 -> JointCreateActivity.TYPE_MODIFY
//                    else -> 3
//                }
//                if (type == 3) {
//                    showDeleteDialog(jointAdapter.getData(position).synergyId.toString())
//                } else {
//                    ZyFrameStore.setData("joinStateList", joinStateList)
//                    ZyFrameStore.setData("jointBean", jointAdapter.getData(position))
//                    val intent = Intent(requireContext(), JointCreateActivity::class.java)
//                    intent.putExtra("type", type)
//                    startActivityForResult(intent, 200)
//                }
//            }.show()
//    }


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

    override fun getJointList(jointList: ArrayList<JointBean>) {

    }

//
//    override fun getJointList(jointList: ArrayList<JointBean>) {
//        pageResult(jointList)
//    }
}