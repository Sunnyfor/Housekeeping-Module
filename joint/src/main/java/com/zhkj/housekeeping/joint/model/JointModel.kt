package com.zhkj.housekeeping.joint.model

import com.zhkj.housekeeping.joint.bean.JointBean
import com.zhkj.housekeeping.joint.bean.Reply
import com.sunny.zy.base.BaseModel
import com.sunny.zy.base.PageModel
import com.sunny.zy.bean.Dictionary
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.housekeeping.joint.http.JointUrlConstant
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
    suspend fun getJointState(): ArrayList<Dictionary>? {
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
        ZyHttp.post(JointUrlConstant.JOINT_LIST_URL, params, resultBean)
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
    suspend fun createJoint(content: String, synergyIds: String): BaseModel<Any>? {
//        if (content.isEmpty()) {
//            ToastUtil.show("请输入协同内容！")
//            return null
//        }
//
//        if (synergyIds.isEmpty()) {
//            ToastUtil.show("请选择协同人员！")
//            return null
//        }
        val params = JSONObject()
        params.put("content", content)
        params.put("synergyIds", synergyIds)

        val resultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.postJson(JointUrlConstant.JOINT_CREATE_URL, params.toString(), resultBean)
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
//        if (jointBean.synergyIds.isEmpty()) {
//            ToastUtil.show("请选择协同人员！")
//            return null
//        }
        val params = JSONObject()
        params.put("synergyId", jointBean.synergyId)
        params.put("content", jointBean.content)
        params.put("synergyIds", jointBean.synergyIds)
        params.put("state", jointBean.state)
        params.put("checkContent", jointBean.checkContent)


        val resultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.postJson(JointUrlConstant.JOINT_CREATE_URL, params.toString(), resultBean)
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
    suspend fun sendReply(synergyId: String, replayContent: String): ArrayList<Reply>? {
//        if (replayContent.isEmpty()) {
//            ToastUtil.show("请输入回复内容！")
//            return
//        }

        val params = JSONObject()
        params.put("synergyId", synergyId)
        params.put("replayContent", replayContent)

        val resultBean = object : HttpResultBean<ArrayList<Reply>>("list") {}
        ZyHttp.postJson(JointUrlConstant.JOINT_REPLY_URL, params.toString(), resultBean)
        if (resultBean.isSuccess()) {

        }
        return null
    }


    /**
     * 删除协同
     */
    suspend fun deleteJoint(id: String): BaseModel<Any>? {
        val params = HashMap<String, String>()
        params["id"] = id

        val resultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.post(JointUrlConstant.JOINT_DELETE_URL, params, resultBean)
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
        ZyHttp.post(JointUrlConstant.JOINT_RECYCLE_URL, null, resultBean)
        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean?.data
            }
        }
        return null
    }
}