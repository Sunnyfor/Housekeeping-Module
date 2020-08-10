package com.zhkj.task.fragment

import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.task.adapter.TaskAdapter
import com.zhkj.task.bean.TaskBean
import com.zhkj.task.contract.TaskContract
import com.zhkj.task.presenter.TaskPresenter

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/7 15:31
 */
class TaskListFragment : PullRefreshFragment<TaskBean.Task>(), TaskContract.TaskListView {

    private val presenter: TaskContract.Presenter by lazy {
        TaskPresenter(this)
    }

    var deptId = ""

    var isResp = "1"

    override fun initView() {
        loadData = {
            loadData()
        }

        enableLoadMore = false

        adapter = TaskAdapter().apply {
            setOnItemClickListener { _, position ->
                ARouter.getInstance().build(RouterPath.TASK_DETAIL_ACTIVITY)
                    .withString("taskId", getData(position).taskId)
                    .navigation()
            }
        }
        super.initView()

    }

    override fun loadData() {
        if (deptId.isNotEmpty()) {
            presenter.loadTaskList(page, deptId, isResp, null, null, null)
        }
    }

    override fun showTaskList(data: ArrayList<TaskBean.Task>) {
        addData(data)
    }
}