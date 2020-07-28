package com.zhkj.im.listener

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/28 11:05
 */
interface IMConnectMsgListener : IMSystemMsgListener {
    //IM连接成功
    fun onConnectSuccess(data: Any?)

    //IM连接失败
    fun onConnectFailed(errMsg: String?)

    //IM被踢掉线
    fun onKickedOffline()
}