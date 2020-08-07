package com.zhkj.project

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import com.zhkj.common.bean.DeptBean
import com.zhkj.common.contract.DeptContract
import com.zhkj.common.presenter.DeptPresenter
import kotlinx.android.synthetic.main.act_project.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/5 19:00
 */
@Route(path = RouterPath.PROJECT_ACTIVITY)
class ProjectActivity : BaseActivity(), DeptContract.IDeptView {

    private val deptPresenter: DeptContract.Presenter by lazy {
        DeptPresenter(this)
    }

    override fun setLayout(): Int = R.layout.act_project

    override fun initView() {

    }

    override fun loadData() {
        //加载部门数据
        deptPresenter.loadDeptList()
    }

    override fun onClickEvent(view: View) {

    }

    override fun close() {

    }

    override fun showDeptList(data: ArrayList<DeptBean>) {
        tab_department.removeAllTabs()
        data.forEach {
            tab_department.addTab(
                tab_department
                    .newTab()
                    .setText(it.name)
                    .setTag(it)
            )
        }
    }
}