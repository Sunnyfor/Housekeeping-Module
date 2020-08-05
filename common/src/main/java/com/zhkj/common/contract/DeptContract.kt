package com.zhkj.common.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.common.bean.DeptBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/5 18:29
 */
class DeptContract {
    interface IDeptView : IBaseView {
        fun showDeptList(data: ArrayList<DeptBean>)
    }

    abstract class Presenter(view: IDeptView) : BasePresenter<IDeptView>(view) {
        abstract fun loadDeptList()
    }
}