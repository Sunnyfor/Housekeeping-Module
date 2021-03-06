package com.zhkj.im.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import com.starrtc.starrtcsdk.api.XHClient
import com.starrtc.starrtcsdk.api.XHConstants
import com.starrtc.starrtcsdk.api.XHCustomConfig
import com.starrtc.starrtcsdk.apiInterface.IXHChatManagerListener
import com.starrtc.starrtcsdk.apiInterface.IXHGroupManagerListener
import com.starrtc.starrtcsdk.apiInterface.IXHLoginManagerListener
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback
import com.starrtc.starrtcsdk.core.im.message.XHIMMessage
import com.sunny.zy.utils.LogUtil
import com.zhkj.im.bean.IMMessageBean
import com.zhkj.im.http.IMConstant
import com.zhkj.user.util.UserManager

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/24 18:44
 */
class KeepLiveService : Service(), IXHChatManagerListener, IXHGroupManagerListener,
    IXHLoginManagerListener {

    private val handler = Handler(Looper.getMainLooper())

    lateinit var customConfig: XHCustomConfig

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        customConfig = XHCustomConfig.getInstance(this)
        customConfig.setImServerUrl(IMConstant.IM_SERVER_URL)
        customConfig.chatroomServerUrl = IMConstant.CHAT_ROOM_SERVER_URL
        customConfig.liveSrcServerUrl = IMConstant.LIVE_SRC_SERVER_URL
        customConfig.liveVdnServerUrl = IMConstant.LIVE_VDN_SERVER_URL
        customConfig.voipServerUrl = IMConstant.VOIP_SERVER_URL

        XHClient.getInstance().chatManager.addListener(this)
        XHClient.getInstance().groupManager.addListener(this)
        XHClient.getInstance().loginManager.addListener(this)
    }


    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        if (!XHClient.getInstance().isOnline) {
            when (val type =
                intent.getIntExtra(IMConstant.SERVICE_TYPE, IMConstant.SERVICE_TYPE_LOGIN)) {
                //登录
                IMConstant.SERVICE_TYPE_LOGIN -> {
                    login()
                }

                //发送消息
                IMConstant.SERVICE_TYPE_SINGLE_SEND, IMConstant.SERVICE_TYPE_GROUP_SEND -> {
                    val id = intent.getStringExtra("id") ?: ""
                    val msg = intent.getStringExtra("data") ?: ""
                    if (id.isNotEmpty() && msg.isNotEmpty())
                        sendMessage(type, id, msg)
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }


    private fun login() {
        //初始化SDK配置
        LogUtil.i("IM_开始登录！")
        customConfig.initSDKForFree(
            UserManager.getLoginBean().userId,
            { errMsg, data -> LogUtil.i("IM配置错误：${errMsg} 消息：$data") },
            handler
        )
        XHClient.getInstance().loginManager.loginFree(object : IXHResultCallback {
            override fun success(data: Any?) {
                LogUtil.i("IM_连接成功")
                sendBordCastReceiver(IMConstant.TYPE_CONNECT_OK)
            }

            override fun failed(errMsg: String) {
                sendBordCastReceiver(IMConstant.TYPE_CONNECT_NO)
            }
        })
    }


    //发送消息
    private fun sendMessage(type: Int, id: String, msg: String) {
        if (type == IMConstant.SERVICE_TYPE_GROUP_SEND) {
            XHClient.getInstance().groupManager.sendMessage(
                id, arrayListOf<String>(), msg, null
            )
            LogUtil.i("IM_发送群组消息：id = $id ---- msg = $msg")
        } else {
            XHClient.getInstance().chatManager.sendMessage(id, msg, null)
            LogUtil.i("IM_发送消息：id = $id ---- msg = $msg")
        }
    }

    override fun onMembersUpdeted(groupID: String?, number: Int) {}

    override fun onSelfKicked(groupID: String?) {}

    override fun onGroupDeleted(groupID: String?) {}


    override fun onReceivedMessage(message: XHIMMessage) {
        if (message.type == 0) {
            sendBordCastReceiver(IMConstant.TYPE_SINGLE_MSG)
        } else if (message.type == 1) {
            sendBordCastReceiver(IMConstant.TYPE_GROUP_MSG)
        }
    }

    override fun onReceivedSystemMessage(message: XHIMMessage) {
        sendBordCastReceiver(IMConstant.TYPE_SYSTEM_MSG)
    }

    override fun onKickedByOtherDeviceLogin() {
        sendBordCastReceiver(IMConstant.TYPE_KICKED_OFFLINE)
    }

    override fun onLogout() {

    }

    override fun onConnectionStateChanged(state: XHConstants.XHSDKConnectionState?) {
        when (state) {
            XHConstants.XHSDKConnectionState.SDKConnectionStateDisconnect -> {
                //用户掉线，可以自动恢复
                sendBordCastReceiver(IMConstant.TYPE_USER_ONLINE)
            }
            XHConstants.XHSDKConnectionState.SDKConnectionStateReconnect -> {
                //用户在线
                sendBordCastReceiver(IMConstant.TYPE_USER_OFFLINE)
            }
            XHConstants.XHSDKConnectionState.SDKConnectionDeath -> {
                //用户掉线，无法自动恢复
                login()
                sendBordCastReceiver(IMConstant.TYPE_CONN_DEATH)
            }
        }
    }


    //发送广播
    private fun sendBordCastReceiver(type: Int, msgBean: IMMessageBean? = null) {
        val intent = Intent()
        intent.action = IMConstant.IM_ACTION
        intent.putExtra(IMConstant.BROADCAST_TYPE, type)
        msgBean?.let {
            intent.putExtra(IMConstant.MSG_BEAN_PARCELABLE, it)
        }
        sendBroadcast(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.i("IM_服务销毁！")
    }
}