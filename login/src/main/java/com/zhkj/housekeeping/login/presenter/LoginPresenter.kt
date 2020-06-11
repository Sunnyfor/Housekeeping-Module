package com.zhkj.housekeeping.login.presenter

import com.zhkj.housekeeping.login.LoginContract
import com.zhkj.housekeeping.login.model.LoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/11 16:49
 */
class LoginPresenter(view: LoginContract.IView) : LoginContract.Presenter(view) {

    private val loginModel: LoginModel by lazy {
        LoginModel()
    }

    override fun login(username: String, password: String) {
        launch(Dispatchers.Main) {
            showLoading()
            val userInfoBean = loginModel.login(username, password)
            hideLoading()
            if (userInfoBean != null) {
                view?.loginResult(userInfoBean)
            }
        }
    }
}