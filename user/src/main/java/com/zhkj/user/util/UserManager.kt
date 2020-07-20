package com.zhkj.user.util

import com.sunny.zy.utils.SpUtil
import com.zhkj.user.bean.UserInfoBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 15:00
 */
object UserManager {
    private val userInfoBean = UserInfoBean("", "", "")


    fun saveUserInfoBean(userInfoBean: UserInfoBean, isSaveLocal: Boolean? = true) {
        UserManager.userInfoBean.hasValue = true
        this.userInfoBean.name = userInfoBean.name
        this.userInfoBean.userId = userInfoBean.userId
        this.userInfoBean.deptId = userInfoBean.deptId
        if (isSaveLocal == true) {
            SpUtil.setObject(SpUtil.userInfoBean, userInfoBean)
        }
    }


    fun getUserInfoBean(): UserInfoBean {
        if (!userInfoBean.hasValue) {
            SpUtil.getObject(SpUtil.userInfoBean, UserInfoBean::class.java)?.let {
                saveUserInfoBean(it, false)
            }
        }
        return userInfoBean
    }
}