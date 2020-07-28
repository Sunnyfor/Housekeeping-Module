package com.zhkj.im.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.zhkj.im.bean.IMMessageBean
import com.zhkj.im.http.IMConstant
import com.zhkj.im.listener.IMGroupMsgListener
import com.zhkj.im.listener.IMSingleMsgListener
import com.zhkj.im.listener.IMSystemMsgListener

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/27 17:13
 */
class IMBroadCastReceiver<T : IMSystemMsgListener>(var listener: T) : BroadcastReceiver() {

    override fun onReceive(context: Context, data: Intent?) {
        data?.let {
            when (it.getIntExtra("type", 0)) {
                //系统消息
                IMConstant.TYPE_SYSTEM_MSG -> {
                    getMsgBean(data)?.let { msgBean ->
                        listener.onSystemMessage(msgBean)
                    }
                }
                //一对一单聊
                IMConstant.TYPE_SINGLE_MSG -> {
                    getMsgBean(data)?.let { msgBean ->
                        if (listener is IMSingleMsgListener)
                            (listener as IMSingleMsgListener).onSingleMessage(msgBean)
                    }
                }
                //群组消息
                IMConstant.TYPE_GROUP_MSG -> {
                    getMsgBean(data)?.let { msgBean ->
                        if (listener is IMGroupMsgListener)
                            (listener as IMGroupMsgListener).onGroupMsgListener(msgBean)
                    }
                }
                else -> {
                }
            }
        }
    }


    private fun getMsgBean(data: Intent?): IMMessageBean? {
        return data?.getParcelableExtra(IMConstant.MSG_BEAN_PARCELABLE)
    }
}