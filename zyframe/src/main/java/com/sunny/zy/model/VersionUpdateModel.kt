package com.sunny.zy.model

import com.sunny.zy.ZyFrameStore
import com.sunny.zy.bean.VersionBean
import com.sunny.zy.http.OnResult
import com.sunny.zy.http.ProgressResponseBody
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.http.ZyHttp

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/15 11:47
 */
class VersionUpdateModel {

    //检查是否有新版本

    suspend fun checkVersion(version: Int): VersionBean? {
        val params = hashMapOf<String, String>()
        params["versionCode"] = version.toString()

        val httpResultBean = ZyHttp.post(
            UrlConstant.APP_VERSION_UPDATE_URL,
            params,
            object : OnResult<VersionBean>() {})

        if (httpResultBean.isSuccess()) {
            httpResultBean.bean?.appAndroidVersion?.let {
                if (version < it.versionCode) {
                    //检测到新版本返回版本信息
                    ZyFrameStore.isNewVersionDetected = true
                    return httpResultBean.bean
                }
            }
        }
        //没有新版本返回null
        ZyFrameStore.isNewVersionDetected = false
        return null
    }


    suspend fun downLoadAPK(
        url: String,
        fileName: String?,
        progressResponseListener: ProgressResponseBody.ProgressResponseListener
    ) {
        ZyHttp.download(url, fileName, progressResponseListener)
    }

}