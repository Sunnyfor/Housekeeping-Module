package com.zhkj.message.signin.bean

/**
 * Desc 签到记录实体类
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/2/2 22:09
 */
data class SignInBean(
    var recordeId: Int,
    var signCode: Int,
    var signTime: String?,
    var userTemperature: String?, //用户体温
    var imgUrl: String?, // 签到卡片图片地址
    var isSignIn: Boolean, //是否签到
    var isVideoClockIn: Boolean, //是否视频打卡
    var videoUrl: String? //视频打卡地址

)