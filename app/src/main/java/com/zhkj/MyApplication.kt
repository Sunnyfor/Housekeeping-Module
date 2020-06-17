package com.zhkj

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/3 16:49
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ZyFrameStore.init(this)
        ARouter.init(this)
        ARouter.openDebug()
        ARouter.openLog()
    }
}