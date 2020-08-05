package com.zhkj.common.model

import com.sunny.zy.base.BaseModel
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.common.bean.DeptBean
import com.zhkj.common.http.CommonUrlConstant

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/5 18:20
 */
class DeptModel {
    suspend fun loadDept(): ArrayList<DeptBean>? {
        val httpResultBean =
            object : HttpResultBean<BaseModel<ArrayList<DeptBean>>>("sysDeptEntities") {}
        ZyHttp.get(CommonUrlConstant.DEPT_LIST_URL, null, httpResultBean)

        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true) {
                return httpResultBean.bean?.data
            }
        }
        return null
    }
}
