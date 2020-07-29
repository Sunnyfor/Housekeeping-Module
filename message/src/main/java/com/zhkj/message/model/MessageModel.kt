package com.zhkj.message.model

import com.sunny.zy.base.BaseModel
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.message.bean.FriendsBean
import com.zhkj.message.bean.MsgRecordBean
import com.zhkj.message.http.MsgUrlConstant

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
        ZyHttp.get(MsgUrlConstant.FRIEND_LIST_URL, null, httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true) {
                return httpResultBean.bean?.data
            }
        }
        return null
    }

    //加载聊天记录
    suspend fun loadChatRecord(groupId: String, page: String): ArrayList<MsgRecordBean>? {
        val params = hashMapOf<String, String>()
        params["groupId"] = groupId
        params["page"] = page
        params["limit"] = "20"
        val httpResultBean = object : HttpResultBean<BaseModel<ArrayList<MsgRecordBean>>>() {}
        ZyHttp.post(MsgUrlConstant.MESSAGE_LIST_URL, params, httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true) {
                return httpResultBean.bean?.data
            }
        }
        return null
    }
}