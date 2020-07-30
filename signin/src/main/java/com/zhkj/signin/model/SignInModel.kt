package com.zhkj.signin.model

import com.sunny.zy.base.BaseModel
import com.sunny.zy.bean.UploadBean
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.signin.bean.SignInBean
import com.zhkj.signin.http.SignInUrlConstant
import org.json.JSONObject
import java.io.File

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/7 18:21
 */
class SignInModel {

    /**
     * 加载签到信息
     */
    suspend fun loadSignIn(): SignInBean? {
        val httpResultBean = object : HttpResultBean<BaseModel<SignInBean>>() {}
        ZyHttp.get(SignInUrlConstant.SIGN_IN_CHECK_URL, null, httpResultBean)
        if (httpResultBean.isSuccess() && httpResultBean.bean?.isSuccess() == true) {
            return httpResultBean.bean?.data
        }
        return null
    }


    /**
     * 提交签到
     */
    suspend fun commitSignIn(temperature: String, videoId: String): BaseModel<Any>? {
        val json = JSONObject()
        json.put("userTemperature", temperature)
        json.put("videoUrl", videoId)
        val httpResultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.postJson(SignInUrlConstant.SIGN_IN_COMMIT_URL, json.toString(), httpResultBean)
        if (httpResultBean.isSuccess() && httpResultBean.bean?.isSuccess() == true) {
            return httpResultBean.bean
        }
        return null
    }


    /**
     * 上传视频
     */
    suspend fun uploadVideo(path: String): UploadBean? {
        val httpResultBean = object : HttpResultBean<BaseModel<UploadBean>>() {}
        ZyHttp.formUpload(UrlConstant.STS_UPLOAD, path, httpResultBean)
        if (httpResultBean.isSuccess() && httpResultBean.bean?.isSuccess() == true) {
            return httpResultBean.bean?.data
        }
        return null
    }

    /**
     * 下载视频
     */
    suspend fun downLoadVideo(url: String, fileName: String): File? {
        val httpResultBean = object : HttpResultBean<File>(fileName) {}
        ZyHttp.get(url, null, httpResultBean)
        if (httpResultBean.isSuccess()) {
            return httpResultBean.bean
        }
        return null
    }


    /**
     * 加载历史记录
     */
    suspend fun loadSignInRecord(): ArrayList<SignInBean>? {
        val httpResultBean = object : HttpResultBean<BaseModel<ArrayList<SignInBean>>>() {}
        ZyHttp.post(SignInUrlConstant.SIGN_IN_RECORD_URL, null, httpResultBean)
        if (httpResultBean.isSuccess() && httpResultBean.bean?.isSuccess() == true) {
            return httpResultBean.bean?.data
        }
        return null
    }
}