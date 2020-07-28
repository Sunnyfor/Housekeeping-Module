package com.zhkj.im.listener

import com.zhkj.im.bean.IMMessageBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/28 15:09
 */
interface IMGroupMsgListener : IMSystemMsgListener {
    override fun onSystemMessage(message: IMMessageBean) {}

    fun onGroupMsgListener(message: IMMessageBean)
}