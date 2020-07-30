package com.zhkj.joint.model

import com.google.gson.Gson
import com.sunny.zy.base.BaseModel
import com.sunny.zy.base.PageModel
import com.sunny.zy.bean.Dictionary
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.joint.bean.JointBean
import com.zhkj.joint.http.JointUrlConstant
import com.zhkj.user.util.UserManager
import org.json.JSONObject

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/17 16:48
 */
class JointModel {

    /**
     * 加载协同状态
     */
    suspend fun loadJointState(): ArrayList<Dictionary>? {
        val params = HashMap<String, String>()
        params["name"] = "是否完成"
        val resultBean = object : HttpResultBean<PageModel<Dictionary>>() {}
        ZyHttp.get(UrlConstant.DICT_LIST_URL, params, resultBean)
        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean?.data?.list
            }
        }
        return null
    }


    /**
     * 加载协同列表
     */
    suspend fun loadJointList(page: Int, type: Int): ArrayList<JointBean>? {
        val params = HashMap<String, String>()
        params["page"] = page.toString()
        params["limit"] = "20"
        params["type"] = type.toString()
        val resultBean = object : HttpResultBean<PageModel<JointBean>>() {}
        ZyHttp.get(JointUrlConstant.JOINT_URL, params, resultBean)
        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean?.data?.list
            }
        }
        return null
    }


    /**
     * 创建协同
     */
    suspend fun createJoint(
        synergyTitle: String, content: String, synergyNames: String, synergyIds: String
    ): BaseModel<Any>? {
        val params = JSONObject()
        params.put("synergyTitle", synergyTitle)
        params.put("content", content)
        params.put("synergyNames", synergyNames)
        params.put("synergyIds", synergyIds)
        val resultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.postJson(JointUrlConstant.JOINT_URL, params.toString(), resultBean)
        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean
            }
        }
        return null
    }


    /**
     * 修改协同
     */
    suspend fun modifyJoint(jointBean: JointBean): BaseModel<Any>? {
        val params = Gson().toJson(jointBean)
        val resultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.postJson(JointUrlConstant.JOINT_URL, params, resultBean)
        if (resultBean.isSuccess()) {
            if (resultBean.isSuccess()) {
                if (resultBean.bean?.isSuccess() == true) {
                    return resultBean.bean
                }
            }
        }
        return null
    }


    /**
     * 发送回复
     */
    suspend fun sendReply(groupId: String, content: String): BaseModel<Any>? {
        val params = JSONObject()
        params.put("groupId", groupId)
        params.put("content", content)
        params.put("userId", UserManager.getUserInfoBean().userId)
        params.put("sendTime", System.currentTimeMillis())
        val resultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.postJson(JointUrlConstant.JOINT_REPLY_URL, params.toString(), resultBean)
        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean
            }
        }
        return null
    }

    /**
     * 加载回复列表
     */
    suspend fun loadReplyList(id: String): ArrayList<JointBean.Reply>? {
        val params = HashMap<String, String>()
        params["id"] = "syn$id"

        val resultBean = object : HttpResultBean<BaseModel<ArrayList<JointBean.Reply>>>() {}
        ZyHttp.post(JointUrlConstant.JOINT_REPLY_LIST_URL, params, resultBean)
        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean?.data
            }
        }
        return null
    }


    /**
     * 删除协同
     */
    suspend fun deleteJoint(id: String): BaseModel<Any>? {
        val resultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.patch(String.format(JointUrlConstant.JOINT_DELETE_URL, id), null, resultBean)
        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean
            }
        }
        return null
    }


    /**
     *  协同回收站
     */
    suspend fun jointRecycle(): ArrayList<JointBean>? {
        val resultBean =
            object : HttpResultBean<BaseModel<ArrayList<JointBean>>>("synergyEntities") {}
        ZyHttp.get(JointUrlConstant.JOINT_RECYCLE_URL, null, resultBean)
        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean?.data
            }
        }
        return null
    }
}