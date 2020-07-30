package com.zhkj.login.model

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import com.sunny.zy.base.BaseModel
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.sunny.zy.utils.ToastUtil
import com.zhkj.user.bean.LoginBean
import org.json.JSONObject

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/11 16:52
 */
class LoginModel {

    //APP主要权限集合
    private val permissionsList = arrayListOf(
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA,
        Manifest.permission.RECORD_AUDIO
    )


    suspend fun login(username: String, password: String): LoginBean? {

        if (username.isEmpty()) {
            ToastUtil.show("请输入账号！")
            return null
        }

        if (password.isEmpty()) {
            ToastUtil.show("请输入密码！")
            return null
        }

        val json = JSONObject()
        json.put("username", username)
        json.put("password", password)

        val httpResultBean = object : HttpResultBean<BaseModel<LoginBean>>("sysUserEntityVo") {}
        ZyHttp.postJson(UrlConstant.SYS_LOGIN, json.toString(), httpResultBean)

        //HTTP请求成功
        if (httpResultBean.isSuccess()) {
            httpResultBean.bean?.let {
                //登录成功
                if (it.isSuccess()) {
                    return it.data
                }
            }
        }

        return null
    }

    /**
     * 检查权限
     * @param mPermissionsList 未获取权限的列表
     */
    fun checkPermission(context: Context, mPermissionsList: ArrayList<String>): Boolean {
        //6.0需要动态权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //权限判断
            permissionsList.forEach {
                if (context.checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED) {
                    mPermissionsList.add(it)
                }
            }
            if (mPermissionsList.size == 0) {
                return true
            }
        } else {
            return true
        }

        return false
    }
}