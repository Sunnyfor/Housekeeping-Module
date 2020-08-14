package com.zhkj.task.model

import com.sunny.zy.base.BaseModel
import com.sunny.zy.base.PageModel
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.http.bean.HttpResultBean
import com.zhkj.task.bean.TaskBean
import com.zhkj.task.bean.TaskDetailBean
import com.zhkj.task.bean.TaskProgressBean
import com.zhkj.task.http.TaskUrlConstant

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/7 17:53
 */
class TaskModel {

    /**
     * 加载任务进度
     */
    suspend fun loadTaskList(
        page: Int,
        taskDeptId: String,
        isResp: String,
        taskName: String?,
        taskType: String?,
        taskLevel: String?
    ): ArrayList<TaskBean.Task>? {

        val params = HashMap<String, String>()
        params["page"] = page.toString()
        params["limit"] = "20"
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


    /**
     * 加载任务详情
     */
    suspend fun loadTask(id: String): TaskDetailBean? {
        val params = HashMap<String, String>()
        params["id"] = id
        val httpResultBean = object : HttpResultBean<BaseModel<TaskDetailBean>>() {}
        ZyHttp.get(TaskUrlConstant.TASK_DETAIL_URL, params, httpResultBean)

        if (httpResultBean.isSuccess() && httpResultBean.bean?.isSuccess() == true) {
            return httpResultBean.bean?.data
        }
        return null
    }


    /**
     * 加载任务进度
     */
    suspend fun loadTaskProgress(taskId: String, page: Int): ArrayList<TaskProgressBean>? {
        val params = HashMap<String, String>()
        params["page"] = page.toString()
        params["limit"] = "20"
        val httpResultBean = object : HttpResultBean<PageModel<TaskProgressBean>>() {}
        ZyHttp.post(
            String.format(TaskUrlConstant.TASK_PROGRESS_URL, taskId),
            params,
            httpResultBean
        )
        if (httpResultBean.isSuccess() && httpResultBean.bean?.isSuccess() == true) {
            return httpResultBean.bean?.data?.list
        }
        return null
    }
}