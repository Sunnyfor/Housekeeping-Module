package com.zhkj.task

import com.sunny.zy.base.BaseModel
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.task.bean.TaskBean
import com.zhkj.task.http.TaskUrlConstant

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/7 17:53
 */
class TaskModel {
    suspend fun loadTask(
        taskDeptId: String,
        isResp: String,
        taskName: String? = null,
        taskType: String? = null,
        taskLevel: String? = null
    ): ArrayList<TaskBean.Task>? {

        val params = HashMap<String, String>()
        params["taskDeptId"] = taskDeptId
        params["isResp"] = isResp
        params["all"] = "1"

        taskName?.let {
            params["taskName"] = taskName
        }
        taskType?.let {
            params["taskType"] = taskType
        }
        taskLevel?.let {
            params["taskLevel"] = taskLevel
        }

        val httpResultBean = object : HttpResultBean<BaseModel<ArrayList<TaskBean>>>("list") {}
        ZyHttp.post(TaskUrlConstant.TASK_LIST_GROUP_URL, params, httpResultBean)
        if (httpResultBean.isSuccess()) {
            if (httpResultBean.bean?.isSuccess() == true) {
                try {
                    return httpResultBean.bean?.data?.get(0)?.taskList
                } catch (e: IndexOutOfBoundsException) {
                    e.printStackTrace()
                }
            }
        }

        return null
    }
}