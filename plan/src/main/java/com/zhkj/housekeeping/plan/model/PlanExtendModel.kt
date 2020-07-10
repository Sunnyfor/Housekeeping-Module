package com.zhkj.housekeeping.plan.model

import com.sunny.zy.base.BaseModel
import com.sunny.zy.bean.Dictionary
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.sunny.zy.model.DictionaryModel
import com.zhkj.housekeeping.plan.http.PlanUrlConstant
import com.zhkj.housekeeping.plan.util.DateUtil
import org.json.JSONArray
import org.json.JSONObject

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/9 18:30
 */
class PlanExtendModel {

    private val dictionaryModel: DictionaryModel by lazy {
        DictionaryModel()
    }

    //加载计划状态
    suspend fun loadPlanStatus(): ArrayList<Dictionary>? {
        return dictionaryModel.loadDictionaryList("计划活动状态")
    }


    //加载计划执行模块
    suspend fun loadPlanExecutionModule(): ArrayList<Dictionary>? {
        return dictionaryModel.loadDictionaryList(null, "isNotTask")
    }


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
        planId: String,
        planTitle: String,
        activeStatus: String,
        contentId: String,
        content: String
    ): BaseModel<Any>? {
        val params = JSONObject()
        params.put("planId", planId)
        params.put("planTitle", planTitle)
        params.put("activeStatus", activeStatus)
        params.put("contentId", contentId)
        params.put("content", content)

        val httpResultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.postJson(PlanUrlConstant.PLAN_UPDATE_URL, params.toString(), httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true)
                return httpResultBean.bean
        }
        return null
    }

    //删除计划
    suspend fun deletePlan(ids: Array<String>): BaseModel<Any>? {
        val params = JSONArray(ids)
        val httpResultBean = object : HttpResultBean<BaseModel<Any>>() {}
        ZyHttp.postJson(PlanUrlConstant.PLAN_DELETE_URL, params.toString(), httpResultBean)
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