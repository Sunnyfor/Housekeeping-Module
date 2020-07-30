package com.zhkj.user.util

import com.sunny.zy.utils.SpUtil
import com.zhkj.user.bean.LoginBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 15:00
 */
object UserManager {
    private val loginBean = LoginBean("", "", "")


    fun saveLoginBean(userInfoBean: LoginBean, isSaveLocal: Boolean? = true) {
        loginBean.hasValue = true
        this.loginBean.name = userInfoBean.name
        this.loginBean.userId = userInfoBean.userId
        this.loginBean.deptId = userInfoBean.deptId
        if (isSaveLocal == true) {
            SpUtil.setObject(SpUtil.userInfoBean, userInfoBean)
        }
    }


    fun getLoginBean(): LoginBean {
        if (!loginBean.hasValue) {
            SpUtil.getObject(SpUtil.userInfoBean, LoginBean::class.java)?.let {
                saveLoginBean(it, false)
            }
        }
        return loginBean
    }
}