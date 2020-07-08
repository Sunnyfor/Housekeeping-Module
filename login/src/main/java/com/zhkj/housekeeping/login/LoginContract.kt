package com.zhkj.housekeeping.login

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.sunny.zy.bean.UserInfoBean

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/11 16:41
 */
interface LoginContract {

    interface IView : IBaseView {
        fun showLoginResult(user: UserInfoBean)
        fun permissionOk()
        fun permissionsNo(permissions: Array<String>)
    }

    abstract class Presenter(view: IView) : BasePresenter<IView>(view) {
        abstract fun login(username: String, password: String)
    }
}