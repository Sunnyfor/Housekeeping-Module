package com.zhkj.im.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import com.starrtc.starrtcsdk.api.XHClient
import com.starrtc.starrtcsdk.api.XHCustomConfig
import com.starrtc.starrtcsdk.apiInterface.IXHChatManagerListener
import com.starrtc.starrtcsdk.apiInterface.IXHGroupManagerListener
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback
import com.starrtc.starrtcsdk.core.im.message.XHIMMessage
import com.sunny.zy.utils.LogUtil
import com.sunny.zy.utils.ToastUtil
import com.zhkj.im.http.IMUrlConstant
import com.zhkj.user.util.UserManager

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/24 18:44
 */
class KeepLiveService : Service(), IXHChatManagerListener, IXHGroupManagerListener {

    private val handler = Handler(Handler.Callback {
        return@Callback false
    })


    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        val customConfig =   XHCustomConfig.getInstance(this).apply {
            setImServerUrl(IMUrlConstant.IM_SERVER_URL)
            chatroomServerUrl = IMUrlConstant.CHAT_ROOM_SERVER_URL
            liveSrcServerUrl = IMUrlConstant.LIVE_SRC_SERVER_URL
            liveVdnServerUrl = IMUrlConstant.LIVE_VDN_SERVER_URL
            voipServerUrl = IMUrlConstant.VOIP_SERVER_URL
        }

        //初始化SDK配置
        customConfig.initSDKForFreeWithoutAudioCheck(
            UserManager.getUserInfoBean().userId,
            { errMsg, data -> LogUtil.i("IM配置错误：${errMsg} 消息：$data") },
            handler
        )

        XHClient.getInstance().chatManager.addListener(this)
        XHClient.getInstance().groupManager.addListener(this)

        XHClient.getInstance().loginManager.loginFree(object : IXHResultCallback {
            override fun success(data: Any) {
                LogUtil.i("IM登录成功")
            }

            override fun failed(errMsg: String) {
                LogUtil.i("IM登录失败")
                ToastUtil.show(errMsg)
            }
        })
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }


    override fun onMembersUpdeted(p0: String?, p1: Int) {}

    override fun onSelfKicked(p0: String?) {}

    override fun onGroupDeleted(p0: String?) {}

    override fun onReceivedMessage(message: XHIMMessage) {
        LogUtil.i("IM收到信息:$message")
    }

    override fun onReceivedSystemMessage(message: XHIMMessage) {
        LogUtil.i("IM系统信息:$message")
    }
}