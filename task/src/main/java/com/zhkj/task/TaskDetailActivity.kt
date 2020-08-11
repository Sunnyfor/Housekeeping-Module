package com.zhkj.task

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import com.zhkj.task.bean.TaskDetailBean
import com.zhkj.task.contract.TaskContract
import com.zhkj.task.fragment.TaskFinishPanelFragment
import com.zhkj.task.fragment.TaskPanelFragment
import com.zhkj.task.presenter.TaskPresenter
import kotlinx.android.synthetic.main.act_task_detail.*
import kotlinx.coroutines.cancel

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 17:38
 */
@Route(path = RouterPath.TASK_DETAIL_ACTIVITY)
class TaskDetailActivity : BaseActivity(), TaskContract.TaskInfoView {

    @Autowired
    @JvmField
    var taskId = ""

    private val presenter: TaskContract.Presenter by lazy {
        TaskPresenter(this)
    }

    private val typeArray = arrayOf("立项面板", "完成面板")

    override fun setLayout(): Int = R.layout.act_task_detail

    override fun initView() {

        ARouter.getInstance().inject(this)

        defaultTitle(getString(R.string.task_detail))

    }

    override fun loadData() {
        presenter.loadTaskInfo(taskId)
    }

    override fun onClickEvent(view: View) {

    }

    override fun close() {
        presenter.cancel()
    }

    override fun showTaskInfo(data: TaskDetailBean) {

        val fragmentList = arrayListOf(
            TaskPanelFragment().apply {
                bean = data
            },
            TaskFinishPanelFragment().apply {
                bean = data
            }
        )

        viewpager.adapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getItem(position: Int): Fragment = fragmentList[position]

            override fun getCount(): Int = fragmentList.size

            override fun getPageTitle(position: Int): CharSequence? {
                return typeArray[position]
            }
        }

        tab_type.setupWithViewPager(viewpager)
    }
}