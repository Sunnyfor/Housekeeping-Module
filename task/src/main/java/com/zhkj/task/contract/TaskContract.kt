package com.zhkj.task.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.task.bean.TaskBean
import com.zhkj.task.bean.TaskDetailBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 11:19
 */
class TaskContract {
    interface TaskListView : IBaseView {
        fun showTaskList(data: ArrayList<TaskBean.Task>)
    }

    interface TaskInfoView:IBaseView {
        fun showTaskInfo(data:TaskDetailBean)
    }

    abstract class Presenter(view: IBaseView) : BasePresenter<IBaseView>(view) {

        abstract fun loadTaskList(
            page: Int,
            taskDeptId: String,
            isResp: String,
            taskName: String?,
            taskType: String?,
            taskLevel: String?
        )

        abstract fun loadTaskInfo(taskId: String)
    }
}