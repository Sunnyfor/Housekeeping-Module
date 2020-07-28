package com.zhkj.im.listener

import com.zhkj.im.bean.IMMessageBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/28 15:06
 */
interface IMSingleMsgListener : IMSystemMsgListener {
    override fun onSystemMessage(message: IMMessageBean) {}
    fun onSingleMessage(message: IMMessageBean)
}