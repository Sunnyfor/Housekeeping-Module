package com.zhkj.common.model

import com.sunny.zy.base.PageModel
import com.zhkj.common.bean.Dictionary
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.common.http.CommonUrlConstant

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/11 14:52
 */
class DictModel {

    suspend fun loadDict(key: String, value: String): ArrayList<Dictionary>?{
        val params = HashMap<String, String>()
        params[key] = value
        val resultBean = object : HttpResultBean<PageModel<Dictionary>>() {}
        ZyHttp.get(CommonUrlConstant.DICT_LIST_URL, params, resultBean)
        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean?.data?.list
            }
        }
        return null
    }
}