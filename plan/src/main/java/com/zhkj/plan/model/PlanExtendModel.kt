package com.zhkj.plan.model

import com.google.gson.Gson
import com.sunny.zy.base.BaseModel
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.plan.bean.PlanBean
import com.zhkj.plan.http.PlanUrlConstant
import com.zhkj.plan.util.DateUtil
import org.json.JSONArray
import org.json.JSONObject

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/9 18:30
 */
class PlanExtendModel {

    //创建计划
    suspend fun createPlan(
        planTitle: String?,
        planStartDate: String,
        planEndDate: String,
        isNotTask: String?,
        contentList: java.util.ArrayList<String>
    ): BaseModel<Any>? {
        val dataJsonObj = JSONObject()
        dataJsonObj.put("planStartDate", "$planStartDate 00:00:00")
        dataJsonObj.put("planEndDate", "$planEndDate 00:00:00")

        val planJsonObj = JSONObject()
        planJsonObj.put("planTitle", planTitle)
        planJsonObj.put("isNotTask", isNotTask)
        val contentSb = StringBuilder()
        contentList.forEachIndexed { index, s ->
            contentSb.append(s)
            if (index != contentList.size - 1) {
                contentSb.append("·")
            }

        }
        planJsonObj.put("content", contentSb.toString())
        val contentArray = JSONArray()
        contentArray.put(planJsonObj)
        dataJsonObj.put("planList", contentArray)

        val httpResultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.postJson(PlanUrlConstant.PLAN_CREATE_URL, dataJsonObj.toString(), httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true)
                return httpResultBean.bean
        }
        return null
    }

    //修改计划
    suspend fun updatePlan(
        bean: PlanBean
    ): BaseModel<Any>? {

        val params = JSONObject()
        params.put("planStartDate", bean.planStartDate)
        params.put("planEndDate", bean.planEndDate)
        params.put("isNotTask", bean.isNotTask)

        val planList = JSONArray()
        planList.put(JSONObject(Gson().toJson(bean)))
        params.put("planList", planList)

        val httpResultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.postJson(PlanUrlConstant.PLAN_CREATE_URL, params.toString(), httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true)
                return httpResultBean.bean
        }
        return null
    }

    //删除计划
    suspend fun deletePlan(id: Int): BaseModel<Any>? {
        val params = JSONArray()
        params.put(id)
        val httpResultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.deleteJson(PlanUrlConstant.PLAN_DELETE_URL, params.toString(), httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true)
                return httpResultBean.bean
        }
        return null
    }


    //周计划下移
    suspend fun transferNextWeek(bean: PlanBean): BaseModel<Any>? {
        val params = JSONObject(Gson().toJson(bean))
        val httpResultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.deleteJson(
            PlanUrlConstant.PLAN_TRANSFER_NEXT_WEEK_URL,
            params.toString(),
            httpResultBean
        )
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true)
                return httpResultBean.bean
        }
        return null
    }


    //完成计划
    suspend fun completePlan(id: String): BaseModel<Any>? {
        val params = HashMap<String, String>()
        params["planId"] = id
        val httpResultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.get(PlanUrlConstant.PLAN_UPDATE_FINISH_URL, params, httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true)
                return httpResultBean.bean
        }
        return null
    }


    /**
     * 计算两个日期相隔天数
     */
    fun calculateDay(startDate: String, endDate: String): Int {
        val millisecond =
            DateUtil.getDateStrToLong(endDate) -
                    DateUtil.getDateStrToLong(startDate)
        val day = millisecond / (1000L * 60 * 60 * 24)
        return day.toInt()
    }
}