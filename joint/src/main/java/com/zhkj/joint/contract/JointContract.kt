package com.zhkj.joint.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.sunny.zy.bean.Dictionary
import com.zhkj.joint.bean.JointBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/17 17:00
 */
class JointContract {

    interface IJointListView : IBaseView {
        fun showJointList(data: ArrayList<JointBean>)
    }

    interface IJointRecycleBinView {
        fun showRecycleList(data: ArrayList<JointBean>)
    }

    interface IJointCreateView {
        fun showCreateJointResult()
        fun showJointStateList(data: ArrayList<Dictionary>)
        fun showModifyJointResult()
    }

    interface IJointDeleteView {
        fun showDeleteJointResult(id: String)
    }

    interface IJointReplyView {
        fun showReplyJoint()
        fun showReplyJointList(data: ArrayList<JointBean.Reply>)
    }

    abstract class Presenter(iView: IBaseView) : BasePresenter<IBaseView>(iView) {
        abstract fun loadJointList(page: Int, type: Int)
        abstract fun loadJointRecycle()
        abstract fun createJoint(
            synergyTitle: String, content: String, synergyNames: String, synergyIds: String
        )

        abstract fun loadJointState()
        abstract fun modifyJoint(jointBean: JointBean)
        abstract fun deleteJoint(id: String)
        abstract fun sendReply(groupId: String, content: String)
        abstract fun loadReplyList(id: String)
    }
}