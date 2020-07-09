package com.zhkj.housekeeping.plan.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/9 18:35
 */
object DateUtil {
    /**
     * 根据天数计算结束日期
     */
    fun countEndDate(start_date: String, numberDay: Int = 1): String {
        try {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
            val dayMillisecond = 1000L * 60 * 60 * 24
            val startTime = dateFormat.parse(start_date)?.time ?: 0L
            val endTime = startTime + numberDay * dayMillisecond
            return dateFormat.format(Date(endTime))
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return ""
    }


    fun dateEquals(time: String, equalsTime: String): Boolean {
        try {
            val dateFormat = SimpleDateFormat("yyyy-mm-dd", Locale.CHINA)
            if (dateFormat.parse(time)?.time ?: 0 > dateFormat.parse(equalsTime)?.time ?: 0) {
                return true
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return false
    }

    fun getDateStrToLong(date: String): Long {
        try {
            val dateFormat = SimpleDateFormat("yyyy-mm-dd", Locale.CHINA)
            return dateFormat.parse(date)?.time ?: 0
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return 0
    }
}