package com.zhkj.user.bean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 11:50
 */
data class LoginBean(
    var name: String,
    var userId: String,
    var deptId: String
) {
    var hasValue = false
}