package com.zhkj.task.presenter

import com.sunny.zy.base.IBaseView
import com.zhkj.task.contract.TaskContract
import com.zhkj.task.model.TaskModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 11:24
 */
class TaskPresenter(view: IBaseView) : TaskContract.Presenter(view) {

    private val taskModel: TaskModel by lazy {
        TaskModel()
    }

    override fun loadTaskList(
        page: Int,
        taskDeptId: String,
        isResp: String,
        taskName: String?,
        taskType: String?,
        taskLevel: String?
    ) {
        launch(Main) {
            if (view is TaskContract.TaskListView) {
                (view as TaskContract.TaskListView).showTaskList(
                    taskModel.loadTaskList(page, taskDeptId, isResp, taskName, taskType, taskLevel)
                        ?: arrayListOf()
                )
            }

            hideLoading()
        }
    }

    override fun loadTaskInfo(taskId: String) {
        launch(Main) {
            showLoading()
            if (view is TaskContract.TaskInfoView) {
                (view as TaskContract.TaskInfoView).showTaskInfo(
                    taskModel.loadTask(taskId) ?: return@launch
                )
            }
            hideLoading()
        }
    }

    override fun loadTaskProgress(taskId: String, page: Int) {
        launch(Main) {
            showLoading()
            if (view is TaskContract.TaskProgressView) {
                (view as TaskContract.TaskProgressView).showTaskProgressList(
                    taskModel.loadTaskProgress(taskId, page) ?: arrayListOf()
                )
            }
            hideLoading()
        }
    }
}