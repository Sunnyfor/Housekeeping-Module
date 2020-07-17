package com.zhkj.housekeeping.joint.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.housekeeping.joint.bean.JointBean

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

    abstract class Presenter(iView: IBaseView) : BasePresenter<IBaseView>(iView) {
        abstract fun loadJointList(page: Int, type: Int)
    }
}