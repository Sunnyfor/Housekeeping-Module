package com.zhkj.housekeeping.login.model

import com.sunny.zy.base.BaseModel
import com.sunny.zy.bean.UserInfoBean
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.sunny.zy.utils.ToastUtil
import org.json.JSONObject

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/11 16:52
 */
class LoginModel {

    suspend fun login(username: String, password: String): UserInfoBean? {

        if (username.isEmpty()) {
            ToastUtil.show("请输入账号！")
            return null
        }

        if (password.isEmpty()) {
            ToastUtil.show("请输入密码！")
            return null
        }

        val json = JSONObject()
        json.put("username", username)
        json.put("password", password)

        val httpResultBean = object : HttpResultBean<BaseModel<UserInfoBean>>("sysUserEntityVo") {}
        ZyHttp.postJson(UrlConstant.SYS_LOGIN, json.toString(), httpResultBean)

        //HTTP请求成功
        if (httpResultBean.isSuccess()) {
            httpResultBean.bean?.let {
                //登录成功
                if (it.isSuccess()) {
                    return it.data
                }
            }
        }

        return null
    }
}