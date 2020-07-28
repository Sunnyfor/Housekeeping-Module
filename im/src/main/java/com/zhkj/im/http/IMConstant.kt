package com.zhkj.im.http

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/24 18:47
 */
object IMConstant {
    const val MSG_BEAN_PARCELABLE = "msg_bean_parcelable"
    const val IM_ACTION = "com.zhkj.im.msg"

    const val TYPE_CONNECT_NO = 199       //登录失败
    const val TYPE_CONNECT_OK = 200      //登录成功
    const val TYPE_CONN_DEATH = 201
    const val TYPE_KICKED_OFFLINE = 202 //其他设备登录离线
    const val TYPE_USER_ONLINE = 203    //用户在线
    const val TYPE_USER_OFFLINE = 204  //用户离线


    const val TYPE_SYSTEM_MSG = 10000
    const val TYPE_SINGLE_MSG = 10001
    const val TYPE_GROUP_MSG = 10002

    const val IM_SERVER_URL = "rtc.zhenhekj.com:19903"
    const val CHAT_ROOM_SERVER_URL = "rtc.zhenhekj.com:19906"
    const val LIVE_VDN_SERVER_URL = "rtc.zhenhekj.com:19928"
    const val LIVE_SRC_SERVER_URL = "rtc.zhenhekj.com:19931"
    const val LIVE_PROXY_SERVER_URL = "rtc.zhenhekj.com:19932"
    const val VOIP_SERVER_URL = "rtc.zhenhekj.com:10086"
}