package com.zhkj.housekeeping.model

import com.sunny.zy.base.BaseModel
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.housekeeping.bean.FriendsBean
import com.zhkj.housekeeping.http.MessageUrlConstant

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/24 11:52
 */
class MessageModel {

    //加载群组列表
    suspend fun loadFriendList(): FriendsBean? {
        val httpResultBean = object : HttpResultBean<BaseModel<FriendsBean>>() {}
        ZyHttp.get(MessageUrlConstant.FRIEND_LIST_URL, null, httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true) {
                return httpResultBean.bean?.data
            }
        }
        return null
    }
}