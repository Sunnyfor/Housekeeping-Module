package com.zhkj.housekeeping.login.presenter

import com.sunny.zy.ZyFrameStore
import com.sunny.zy.utils.SpUtil
import com.zhkj.housekeeping.login.LoginContract
import com.zhkj.housekeeping.login.model.LoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Desc 登录功能的Presenter
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/11 16:49
 */
class LoginPresenter(view: LoginContract.IView) : LoginContract.Presenter(view) {

    private val loginModel: LoginModel by lazy {
        LoginModel()
    }

    /**
     * 登录方法
     * @param username 账号
     * @param password 密码
     */
    override fun login(username: String, password: String) {
        launch(Dispatchers.Main) {
            showLoading()
            val userInfoBean = loginModel.login(username, password)
            hideLoading()
            if (userInfoBean != null) {
                SpUtil.setString(SpUtil.username, username) //持久化存储账号
                SpUtil.setString(SpUtil.password, password) //持久化存储密码
                SpUtil.setObject(SpUtil.userInfoBean, userInfoBean) //持久化存储用户信息
                ZyFrameStore.setUserInfoBean(userInfoBean) //进行内存存储用户信息
                view?.loginResult(userInfoBean)
            }
        }
    }
}