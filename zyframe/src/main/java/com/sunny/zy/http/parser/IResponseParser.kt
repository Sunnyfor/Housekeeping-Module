package com.sunny.zy.http.parser

import okhttp3.ResponseBody
import java.lang.reflect.Type

/**
 * Desc 数据解析
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/4/29 14:47
 */
interface IResponseParser {
    fun <T> parserResponse(data: ResponseBody, type: Type, serializedName: String? = null): T
}