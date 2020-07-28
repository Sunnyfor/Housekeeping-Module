package com.zhkj.im.utils

import android.content.Context
import android.content.IntentFilter
import com.zhkj.im.broadcast.IMBroadCastReceiver
import com.zhkj.im.http.IMConstant
import com.zhkj.im.listener.IMSystemMsgListener

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

    fun sendMessage(content:String){

    }
}