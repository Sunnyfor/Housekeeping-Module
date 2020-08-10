package com.zhkj.task

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import com.zhkj.common.bean.DeptBean
import com.zhkj.common.contract.DeptContract
import com.zhkj.common.presenter.DeptPresenter
import com.zhkj.task.fragment.TaskListFragment
import kotlinx.android.synthetic.main.act_task.*
import kotlinx.coroutines.cancel

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/6 16:16
 */
@Route(path = RouterPath.TASK_ACTIVITY)
class TaskActivity : BaseActivity(), DeptContract.IDeptView {
    private val deptPresenter: DeptContract.Presenter by lazy {
        DeptPresenter(this)
    }

    private var deptId = ""

    private val typeArray = arrayOf("负责任务", "参与任务", "关注任务")
    private val fragmentList = arrayOf(
        TaskListFragment().apply {
            isResp = "1"
        },
        TaskListFragment().apply {
            isResp = "2"
        },
        TaskListFragment().apply {
            isResp = "5"
        }
    )

    override fun setLayout(): Int = R.layout.act_task

    override fun initView() {
        defaultTitle(getString(R.string.task))
        viewpager.offscreenPageLimit = typeArray.size
    }


    override fun loadData() {
        deptPresenter.loadDeptList()
    }

    override fun onClickEvent(view: View) {

    }

    override fun close() {
        deptPresenter.cancel()
    }

    override fun showDeptList(data: ArrayList<DeptBean>) {
        tab_dept.removeAllTabs()
        data.forEach {
            tab_dept.addTab(
                tab_dept.newTab()
                    .setText(it.name)
                    .setTag(it)
            )
        }

        if (data.size == 1) {
            tab_dept.visibility = View.GONE
        } else {
            tab_dept.visibility = View.VISIBLE
        }
        deptId = data[0].deptId.toString()

        updateFragment(false)

        tab_dept.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.tag.let {
                    if (it is DeptBean) {
                        deptId = it.deptId.toString()
                        updateFragment(true)
                    }
                }
            }

        })


        viewpager.adapter = object : FragmentPagerAdapter(
            supportFragmentManager,
            BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {
            override fun getItem(position: Int): Fragment = fragmentList[position]

            override fun getCount(): Int = fragmentList.size

            override fun getPageTitle(position: Int): CharSequence = typeArray[position]
        }
        tab_type.setupWithViewPager(viewpager)
    }


    fun updateFragment(isLoader: Boolean) {
        fragmentList.forEach { fragment ->
            fragment.deptId = deptId
            if (isLoader) {
                fragment.showLoading()
                fragment.loadData()
            }
        }
    }
}