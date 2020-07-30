package com.zhkj.login

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.user.bean.LoginBean

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/11 16:41
 */
interface LoginContract {

    interface IView : IBaseView {
        fun showLoginResult(user: LoginBean)
        fun permissionOk()
        fun permissionsNo(permissions: Array<String>)
    }

    abstract class Presenter(view: IView) : BasePresenter<IView>(view) {
        abstract fun login(username: String, password: String)
    }
}