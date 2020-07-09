package com.sunny.zy.model

import com.sunny.zy.base.PageModel
import com.sunny.zy.bean.Dictionary
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean

/**
 * Desc 字典请求的Model
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/9 19:20
 */
class DictionaryModel {
    suspend fun loadDictionaryList(
        name: String? = null,
        type: String? = null
    ): ArrayList<Dictionary>? {
        val params = HashMap<String, String>()
        name?.let {
            params["name"] = it
        }

        type?.let {
            params["type"] = type
        }
        val httpResultBean = object : HttpResultBean<PageModel<Dictionary>>() {}
        ZyHttp.get(UrlConstant.DICT_LIST_URL, params, httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true)
                return httpResultBean.bean?.data?.list
        }
        return null
    }
}
