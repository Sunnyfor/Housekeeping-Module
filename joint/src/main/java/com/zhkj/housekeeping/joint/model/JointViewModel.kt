package com.zhkj.housekeeping.joint.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhkj.housekeeping.joint.bean.JointBean
import com.zhkj.housekeeping.joint.bean.Reply
import com.sunny.zy.base.BaseModel
import com.sunny.zy.bean.Dictionary

class JointViewModel() : ViewModel() {
    val jointIssuedListLiveData = MutableLiveData<ArrayList<JointBean>>().apply {
        value = arrayListOf()
    } //我发起列表
    val jointListLiveData = MutableLiveData<ArrayList<JointBean>>().apply {
        value = arrayListOf()
    } //我协同列表
    val jointRecycleLiveData = MutableLiveData<ArrayList<JointBean>>().apply {
        value = arrayListOf()
    } //协同回收站列表

    val jointCreateLiveData = MutableLiveData<BaseModel<String>>() //创建协同
    val jointModifyLiveData = MutableLiveData<BaseModel<String>>() //修改协同
    val jointStateLiveData = MutableLiveData<ArrayList<Dictionary>>() //协同状态
    val jointReplyLiveData = MutableLiveData<ArrayList<Reply>>() //协同发送回复
    val jointDeleteLiveData = MutableLiveData<BaseModel<String>>() //删除协同

    /**
     * 加载协同状态
     */
//    suspend fun getJointState() {
//        val params = HashMap<String, String>()
//        params["name"] = "是否完成"
//
//        val resultBean = object : HttpResultBean<PageModel<Dictionary>>() {}
//        ZyHttp.get(UrlConstant.DICT_LIST_URL, params, resultBean)
//        if (resultBean.isSuccess()) {
//            jointStateLiveData.value = resultBean.bean?.data?.list ?: arrayListOf()
//        } else {
//            jointStateLiveData.value = arrayListOf()
//            ToastUtil.show(resultBean.bean?.msg)
//        }
//    }
//
//
//    /**
//     * 加载协同列表
//     */
//    suspend fun getJointList(page: Int, type: Int): ArrayList<JointBean>? {
//        val params = HashMap<String, String>()
//        params["page"] = page.toString()
//        params["limit"] = "20"
//        params["type"] = type.toString()
//        val resultBean = object : HttpResultBean<PageModel<JointBean>>() {}
//        ZyHttp.post(JointUrlConstant.JOINT_LIST_URL, params, resultBean)
//        if (resultBean.isSuccess()) {
//            if (resultBean.bean?.isSuccess() == true) {
//                return resultBean.bean?.data?.list
//            }
//        }
//        return null
//    }
//
//
//    /**
//     * 创建协同
//     */
//    suspend fun createJoint(content: String, synergyIds: String) {
//
//        if (content.isEmpty()) {
//            ToastUtil.show("请输入协同内容！")
//            return
//        }
//
//        if (synergyIds.isEmpty()) {
//            ToastUtil.show("请选择协同人员！")
//            return
//        }
//
//        val params = JSONObject()
//        params.put("content", content)
//        params.put("synergyIds", synergyIds)
//
//        val resultBean = object : HttpResultBean<BaseModel<String>>() {}
//        ZyHttp.postJson(UrlConstant.JOINT_CREATE_URL, params.toString(), resultBean)
//        if (resultBean.isSuccess()) {
//            jointCreateLiveData.value = resultBean.bean
//        } else {
//            ToastUtil.show(resultBean.bean?.msg)
//            jointCreateLiveData.value = null
//        }
//    }
//
//
//    /**
//     * 修改协同
//     */
//    suspend fun modifyJoint(jointBean: JointBean) {
//        if (jointBean.synergyIds.isEmpty()) {
//            ToastUtil.show("请选择协同人员！")
//            return
//        }
//
//        val params = JSONObject()
//        params.put("synergyId", jointBean.synergyId)
//        params.put("content", jointBean.content)
//        params.put("synergyIds", jointBean.synergyIds)
//        params.put("state", jointBean.state)
//        params.put("checkContent", jointBean.checkContent)
//
//
//        val resultBean = object : HttpResultBean<BaseModel<String>>() {}
//        ZyHttp.postJson(UrlConstant.JOINT_CREATE_URL, params.toString(), resultBean)
//        if (resultBean.isSuccess()) {
//            jointModifyLiveData.value = resultBean.bean
//        } else {
//            ToastUtil.show(resultBean.bean?.msg)
//            jointModifyLiveData.value = null
//        }
//
//    }
//
//
//    suspend fun sendReply(synergyId: String, replayContent: String) {
//        if (replayContent.isEmpty()) {
//            ToastUtil.show("请输入回复内容！")
//            return
//        }
//
//        val params = JSONObject()
//        params.put("synergyId", synergyId)
//        params.put("replayContent", replayContent)
//
//        val resultBean = object : HttpResultBean<ArrayList<Reply>>("list") {}
//        ZyHttp.postJson(UrlConstant.JOINT_REPLY_URL, params.toString(), resultBean)
//        if (resultBean.isSuccess()) {
//            jointReplyLiveData.value = resultBean.bean
//        } else {
//            ToastUtil.show(resultBean.msg)
//            jointReplyLiveData.value = null
//        }
//
//    }
//
//    suspend fun deleteJoint(id: String) {
//        val params = HashMap<String, String>()
//        params["id"] = id
//
//        val resultBean = object : HttpResultBean<BaseModel<String>>() {}
//        ZyHttp.post(UrlConstant.JOINT_DELETE_URL, params, resultBean)
//        if (resultBean.isSuccess()) {
//            jointDeleteLiveData.value = resultBean.bean
//        } else {
//            jointDeleteLiveData.value = null
//            ToastUtil.show(resultBean.bean?.msg)
//        }
//
//    }
//
//    /**
//     *  协同回收站
//     */
//    suspend fun jointRecycle() {
//
//        val resultBean =
//            object : HttpResultBean<BaseModel<ArrayList<JointBean>>>("synergyEntities") {}
//        ZyHttp.post(UrlConstant.JOINT_RECYCLE_URL, null, resultBean)
//        if (resultBean.isSuccess()) {
//            jointRecycleLiveData.value = resultBean.bean?.data
//        } else {
//            jointRecycleLiveData.value = arrayListOf()
//            ToastUtil.show(resultBean.bean?.msg)
//        }
//    }
}