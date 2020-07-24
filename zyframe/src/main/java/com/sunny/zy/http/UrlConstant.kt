package com.sunny.zy.http

import com.sunny.zy.ZyFrameStore

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/2 16:47
 */
object UrlConstant {

//    const val host = "https://10.0.0.153:8807" // 内网测试地址

    const val host = "https://www.zhenhekj.com:8807" //正式地址


    val TEMP = ZyFrameStore.getContext().getExternalFilesDir("temp")?.path //内存卡缓存路径

    const val SYS_LOGIN = "sys/login" //登录接口

    /**
     * 检查版本更新
     * versionNumber=1.0.0.1
     */
    const val APP_VERSION_UPDATE_URL = "app/appandroidversion/findNewOne"



    /**
     * 字典接口
     */
    const val DICT_LIST_URL = "sys/dict/list"



    /**
     * 文件上传
     */
    const val STS_UPLOAD = "sys/sysfujian/upload"

}