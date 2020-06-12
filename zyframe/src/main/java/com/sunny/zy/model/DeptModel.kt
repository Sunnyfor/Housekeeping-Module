package com.sunny.zy.model

import com.sunny.zy.base.BaseModel
import com.sunny.zy.bean.DeptBean
import com.sunny.zy.http.OnResult
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.http.ZyHttp

/**
 * Desc 获取部门信息
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/12 17:29
 */
class DeptModel {
    suspend fun loadDept(): DeptBean? {
        val httpResultBean = ZyHttp.get(
            UrlConstant.DEPARTMENT_OF_TREE,
            null,
            object : OnResult<BaseModel<DeptBean>>() {})
        if (httpResultBean.isSuccess()) {

            httpResultBean.bean?.let {
                if (it.isSuccess()) {
                    return it.data
                }
            }
        }
        return null
    }
}