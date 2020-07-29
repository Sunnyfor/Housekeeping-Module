package com.zhkj.im.utils

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.zhkj.im.broadcast.IMBroadCastReceiver
import com.zhkj.im.http.IMConstant
import com.zhkj.im.listener.IMSystemMsgListener
import com.zhkj.im.service.KeepLiveService

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/28 15:22
 */
object IMManager {

    //注册广播拦截器并返回广播对象
    fun <T : IMSystemMsgListener> register(context: Context, listener: T): IMBroadCastReceiver<T> {
        val broadcastReceiver = IMBroadCastReceiver(listener)
        val intentFilter = IntentFilter()
        intentFilter.addAction(IMConstant.IM_ACTION)
        context.registerReceiver(broadcastReceiver, intentFilter)
        return broadcastReceiver
    }

    //发送消息
    fun sendMessage(context: Context, id: String, msg: String) {
        sendMessage(IMConstant.SERVICE_TYPE_SINGLE_SEND, context, id, msg)
    }

    //发送消息
    fun sendGroupMessage(context: Context, id: String, msg: String) {
        sendMessage(IMConstant.SERVICE_TYPE_GROUP_SEND, context, id, msg)
    }


    private fun sendMessage(type: Int, context: Context, id: String, msg: String) {
        val intent = Intent(context, KeepLiveService::class.java)
        intent.putExtra(IMConstant.SERVICE_TYPE, type)
        intent.putExtra("id", id)
        intent.putExtra("data", msg)
        context.startService(intent)
    }


}