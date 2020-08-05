package com.zhkj.user.model

import com.sunny.zy.base.BaseModel
import com.sunny.zy.base.PageModel
import com.sunny.zy.bean.UploadBean
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.user.bean.DeptBean
import com.zhkj.user.bean.OtherUserBean
import com.zhkj.user.bean.UserInfoBean
import com.zhkj.user.http.UserUrlConstant

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 14:10
 */
class UserModel {

    /**
     * 加载用户信息
     */
    suspend fun loadUserInfo(id: String): UserInfoBean? {
        val httpResultBean = object : HttpResultBean<BaseModel<UserInfoBean>>("user") {}
        ZyHttp.get(String.format(UserUrlConstant.USER_INFO_URL, id), null, httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true) {
                return httpResultBean.bean?.data
            }
        }
        return null
    }


    /**
     * 修改用户信息
     */
    suspend fun updateUserInfo(json: String): BaseModel<Any>? {
        val httpResultBean = object : HttpResultBean<BaseModel<Any>>("user") {}
        ZyHttp.postJson(UserUrlConstant.UPDATE_USER_INFO_URL, json, httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true) {
                return httpResultBean.bean
            }
        }
        return null
    }


    /**
     * 上传头像
     */
    suspend fun updateUserHead(path: String): UploadBean? {
        val httpResultBean = object : HttpResultBean<BaseModel<UploadBean>>() {}
        ZyHttp.formUpload(UrlConstant.STS_UPLOAD, path, httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true) {
                return httpResultBean.bean?.data
            }
        }
        return null
    }

    /**
     * 加载参与人员数据
     */
    suspend fun loadUserList(page: String, isAll: Boolean): ArrayList<OtherUserBean>? {
        val params = hashMapOf<String, String>()
        params["page"] = page
        params["limit"] = "-1"
        params["sql_filter"] = isAll.toString()

        val resultBean = object : HttpResultBean<PageModel<OtherUserBean>>() {}
        ZyHttp.post(UserUrlConstant.GET_ALL_USER_LIST_URL, params, resultBean)

        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean?.data?.list
            }
        }
        return null
    }
}