package com.zhkj.im.listener

import com.zhkj.im.bean.IMMessageBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/27 17:16
 */
interface IMSystemMsgListener {

    //接收到系统消息
    fun onSystemMessage(message: IMMessageBean)
}