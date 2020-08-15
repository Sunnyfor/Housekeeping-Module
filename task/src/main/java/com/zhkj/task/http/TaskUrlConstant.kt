package com.zhkj.task.http

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/7 11:33
 */
object TaskUrlConstant {
    /**
     * 加载任务列表
     */
    const val TASK_LIST_GROUP_URL = "/app/task/listGroup?activeState=1"

    /**
     * 加载任务详情
     */
    const val TASK_DETAIL_URL = "/app/task/home"

    /**
     * 加载任务进度
     */
    const val TASK_PROGRESS_URL = "/app/taskprogress/list?taskId=%s"

    /**
     * 更新参与人
     */
    const val TASK_MEMBER_UPDATE_URL = "app/taskrelated/batchSaveOrUpdate?taskId=%s"

    /**
     * 物品清单
     */
    const val TASK_GOODS_URL = "app/taskgoods/list"

    /**
     * 更新物品
     */
    const val GOODS_UPDATE_URL = "app/taskgoods/batchSaveOrUpdate?taskId=%s"
}