package com.zhkj.task

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.task.adapter.TaskProgressAdapter
import com.zhkj.task.bean.TaskProgressBean
import com.zhkj.task.contract.TaskContract
import com.zhkj.task.presenter.TaskPresenter
import com.zhkj.user.util.UserManager

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/14 17:23
 */
@Route(path = RouterPath.TASK_PROGRESS_ACTIVITY)
class TaskProgressActivity : BaseActivity(), TaskContract.TaskProgressView {

    private val pullRefreshFragment = PullRefreshFragment<TaskProgressBean>()

    private val progressPresenter: TaskContract.Presenter by lazy {
        TaskPresenter(this)
    }

    @Autowired
    @JvmField
    var taskId = ""

    @Autowired
    @JvmField
    var chargeUserId = ""

    override fun setLayout(): Int = 0


    override fun initView() {
        ARouter.getInstance().inject(this)

        defaultTitle(getString(R.string.task_progress))

        pullRefreshFragment.adapter =
            TaskProgressAdapter(chargeUserId == UserManager.getLoginBean().userId)

        pullRefreshFragment.loadData = {
            loadData()
        }

        supportFragmentManager.beginTransaction().replace(getFrameBody().id, pullRefreshFragment)
            .commit()
    }

    override fun loadData() {
        progressPresenter.loadTaskProgress(taskId, pullRefreshFragment.page)
    }

    override fun onClickEvent(view: View) {

    }

    override fun close() {

    }

    override fun showTaskProgressList(data: ArrayList<TaskProgressBean>) {
        pullRefreshFragment.addData(data)
    }
}