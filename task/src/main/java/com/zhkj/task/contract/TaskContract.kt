package com.zhkj.task.contract

import com.sunny.zy.base.BaseModel
import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.task.bean.TaskBean
import com.zhkj.task.bean.TaskDetailBean
import com.zhkj.task.bean.TaskProgressBean

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

    interface TaskInfoView : IBaseView {
        fun showTaskInfo(data: TaskDetailBean)
    }

    interface TaskProgressView : IBaseView {
        fun showTaskProgressList(data: ArrayList<TaskProgressBean>)
    }

    interface TaskOptionView : IBaseView {
        fun showUpdateMemberResult(data: BaseModel<Any>)
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

        abstract fun updateMember(taskId: String, json: String)

        abstract fun loadTaskProgress(taskId: String, page: Int)

    }
}