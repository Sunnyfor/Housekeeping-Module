package com.zhkj.task

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.gson.Gson
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.base.BaseModel
import com.sunny.zy.utils.RouterPath
import com.zhkj.task.bean.TaskDetailBean
import com.zhkj.task.contract.TaskContract
import com.zhkj.task.fragment.TaskFinishPanelFragment
import com.zhkj.task.fragment.TaskPanelFragment
import com.zhkj.task.presenter.TaskPresenter
import com.zhkj.user.SelectUserActivity
import kotlinx.android.synthetic.main.act_task_detail.*
import kotlinx.coroutines.cancel

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 17:38
 */
@Route(path = RouterPath.TASK_DETAIL_ACTIVITY)
class TaskDetailActivity : BaseActivity(), TaskContract.TaskInfoView, TaskContract.TaskOptionView {

    @Autowired
    @JvmField
    var taskId = ""

    private val presenter: TaskContract.Presenter by lazy {
        TaskPresenter(this)
    }

    val fragmentList = arrayListOf(
        TaskPanelFragment(),
        TaskFinishPanelFragment()
    )

    private val typeArray = arrayOf("立项面板", "完成面板")

    override fun setLayout(): Int = R.layout.act_task_detail

    override fun initView() {

        ARouter.getInstance().inject(this)

        defaultTitle(getString(R.string.task_detail))

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

    override fun loadData() {
        presenter.loadTaskInfo(taskId)
    }

    override fun onClickEvent(view: View) {

    }

    override fun close() {
        presenter.cancel()
    }

    override fun showTaskInfo(data: TaskDetailBean) {

        fragmentList.forEach {
            if (it is TaskPanelFragment) {
                it.updateData(data)
                return
            }

            if (it is TaskFinishPanelFragment) {
                it.updateData(data)
                return
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10000 && resultCode == Activity.RESULT_OK) {
            val list = SelectUserActivity.processResult(data)
            fragmentList[0].let {
                if (it is TaskPanelFragment) {
                    if (it.flag) {
                        //更新负责人
                    } else {
                        presenter.updateMember(taskId, Gson().toJson(list))
                    }
                }
            }
        }
    }

    override fun showUpdateMemberResult(data: BaseModel<Any>) {
        loadData()
    }
}