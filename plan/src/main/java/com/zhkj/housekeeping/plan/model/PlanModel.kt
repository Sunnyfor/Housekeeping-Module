package com.zhkj.housekeeping.plan.model

import androidx.core.content.ContextCompat
import com.haibin.calendarview.Calendar
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseModel
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.housekeeping.plan.R
import com.zhkj.housekeeping.plan.bean.PlanBean
import com.zhkj.housekeeping.plan.http.PlanUrlConstant
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.set

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/8 19:43
 */
class PlanModel {

    /**
     * 加载计划标记
     */
    suspend fun loadPlantMark(year: Int, month: Int): HashMap<String, Calendar>? {

        var mYear = year
        var mMonth = month
        if (month == 12) {
            mYear++
        } else {
            mMonth++
        }

        val params = HashMap<String, String>()
        params["limit"] = "9999"
        params["beginDate"] = "$year-$month-01"
        params["endDate"] = "$mYear-$mMonth-01"

        val httpResultBean =
            object : HttpResultBean<BaseModel<LinkedHashMap<String, IntArray>>>("list") {}
        ZyHttp.get(PlanUrlConstant.PLAN_MARK_URL, params, httpResultBean)
        if (httpResultBean.isSuccess() && httpResultBean.bean?.isSuccess() == true) {
            val scheme: HashMap<String, Calendar> = HashMap()
            httpResultBean.bean?.data?.forEach {
                val dateArray = it.key.split("-")
                val calendar = getSchemeCalendar(
                    dateArray[0].toInt(), dateArray[1].toInt(), dateArray[2].toInt(), it.value
                )
                scheme[calendar.toString()] = calendar
            }
            return scheme
        }

        return null
    }


    /**
     * 加载计划列表
     */
    suspend fun loadPlantList(
        page: Int,
        beginDate: String,
        endDate: String,
        limit: Int = 9999
    ): ArrayList<PlanBean>? {
        val params = HashMap<String, String>()
        params["page"] = page.toString()
        params["limit"] = limit.toString()
        params["startStr"] = "$beginDate 00:00:00"
        params["endStr"] = "$endDate 00:00:00"
        val httpResultBean = object : HttpResultBean<BaseModel<ArrayList<PlanBean>>>() {}
        ZyHttp.get(PlanUrlConstant.PLAN_LIST_URL, params, httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true) {
                return httpResultBean.bean?.data
            }
        }

        return null
    }


    // 根据日期状态生成mark
    private fun getSchemeCalendar(year: Int, month: Int, day: Int, status: IntArray): Calendar {
        val calendar = Calendar()
        calendar.year = year
        calendar.month = month
        calendar.day = day
        calendar.schemeColor = ContextCompat.getColor(
            ZyFrameStore.getContext(),
            R.color.color_theme
        ) //如果单独标记颜色、则会使用这个颜色
        status.forEach { value ->
            when (value) {
                1 -> {
                    calendar.addScheme(
                        ContextCompat.getColor(ZyFrameStore.getContext(), R.color.color_theme), ""
                    )
                }
                2 -> {
                    calendar.addScheme(
                        ContextCompat.getColor(ZyFrameStore.getContext(), R.color.bg_bubble_right),
                        ""
                    )
                }
                3 -> {
                    calendar.addScheme(
                        ContextCompat.getColor(
                            ZyFrameStore.getContext(), R.color.font_red
                        ), ""
                    )
                }
            }
        }
        return calendar
    }
}