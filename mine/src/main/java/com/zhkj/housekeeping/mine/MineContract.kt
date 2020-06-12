package com.zhkj.housekeeping.mine

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView

/**
 * Desc 我的页面
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/12 17:03
 */
interface MineContract {

    interface View : IBaseView {
        fun showCompanyInfo(companyInfo: MyCompanyInfo)
        fun logout()
    }

    abstract class Presenter(view: View) : BasePresenter<View>(view) {
        abstract fun getCompanyInfo()
        abstract fun logout()
    }

}