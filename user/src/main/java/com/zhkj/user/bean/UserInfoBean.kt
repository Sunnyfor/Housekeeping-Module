package com.zhkj.user.bean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/30 16:04
 */
class UserInfoBean {

    var userId: String? = null
    var username: String? = null
    var salt: String? = null
    var email: String? = null
    var mobile: String? = null
    var status: String? = null
    var roleIdList: ArrayList<Int>? = null
    var createTime: String? = null
    var deptId: String? = null
    var imagesId: String? = null
    var deptName: String? = null
    var sign: String? = null

    override fun toString(): String {
        return "UserInfoBean(userId=$userId, username=$username, salt=$salt, email=$email, mobile=$mobile, status=$status, roleIdList=$roleIdList, createTime=$createTime, deptId=$deptId, imagesId=$imagesId, deptName=$deptName, sign=$sign)"
    }
}