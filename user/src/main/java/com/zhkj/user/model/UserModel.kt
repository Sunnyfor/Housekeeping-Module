package com.zhkj.user.model

import com.sunny.zy.base.BaseModel
import com.sunny.zy.base.PageModel
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.user.bean.DeptBean
import com.zhkj.user.bean.OtherUserBean
import com.zhkj.user.http.UserUrlConstant

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 14:10
 */
class UserModel {

    /**
     * 加载部门数据
     */
    suspend fun loadDeptList(): DeptBean? {
        val httpResultBean = object : HttpResultBean<BaseModel<DeptBean>>() {}
        ZyHttp.get(UserUrlConstant.DEPARTMENT_OF_TREE, null, httpResultBean)

        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true) {
                return httpResultBean.bean?.data
            }

        }
        return null
    }


    /**
     * 加载参与人员数据
     */
    suspend fun loadUserList(page: String, isAll: Boolean): ArrayList<OtherUserBean>? {
        val params = hashMapOf<String, String>()
        params["page"] = page
        params["limit"] = "-1"
        params["sql_filter"] = isAll.toString()

        val resultBean = object : HttpResultBean<PageModel<OtherUserBean>>() {}
        ZyHttp.post(UserUrlConstant.GET_ALL_USER_LIST_URL, params, resultBean)

        if (resultBean.isSuccess()) {
            if (resultBean.bean?.isSuccess() == true) {
                return resultBean.bean?.data?.list
            }
        }
        return null
    }
}