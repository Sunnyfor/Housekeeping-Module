package com.zhkj.task.model

import com.sunny.zy.base.PageModel
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.task.bean.GoodsBean
import com.zhkj.task.http.TaskUrlConstant

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/11 18:58
 */
class GoodsModel {

    suspend fun loadGoods(page: Int, taskId: String): ArrayList<GoodsBean>? {
        val params = HashMap<String, String>()
        params["taskId"] = taskId
        params["page"] = page.toString()
        params["limit"] = "9999"
        val httpResultBean = object : HttpResultBean<PageModel<GoodsBean>>() {}
        ZyHttp.get(TaskUrlConstant.TASK_GOODS_URL, params, httpResultBean)

        if (httpResultBean.isSuccess() && httpResultBean.bean?.isSuccess() == true) {
            return httpResultBean.bean?.data?.list
        }
        return null
    }
}