package com.sunny.zy.http

import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.RequestBody

/**
 * Desc
 * Author ZhangYe
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/4/29 12:22
 */
class ZyRequest {


    private fun getUrlSb(url: String) = StringBuilder().apply {
        if (!url.contains("http://") && !url.contains("https://")) {
            append(UrlConstant.host)
            append("/")
        }
        append(url)
    }


    /**
     * GET请求生成
     */

    fun getRequest(url: String, params: HashMap<String, String>?): Request {
        val urlSb = getUrlSb(url)
        if (params?.isNotEmpty() == true) {
            urlSb.append("?")
            params.entries.forEach { entry ->
                urlSb.append(entry.key)
                    .append("=")
                    .append(entry.value)
                    .append("&")
            }
            urlSb.deleteCharAt(urlSb.lastIndex)
        }

        return Request.Builder().url(urlSb.toString()).build()
    }


    /**
     * POST-JSON请求生成
     */
    fun postJsonRequest(url: String, json: String): Request {
        val urlSb = getUrlSb(url)
        val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
        return Request.Builder().url(urlSb.toString()).post(body).build()
    }


    /**
     * POST-FORM请求生成
     */
    fun postFormRequest(url: String, params: HashMap<String, String>?): Request {
        val urlSb = getUrlSb(url)
        val body = FormBody.Builder()
        params?.entries?.forEach {
            body.add(it.key, it.value)
        }
        return Request.Builder().url(urlSb.toString()).post(body.build()).build()
    }
}