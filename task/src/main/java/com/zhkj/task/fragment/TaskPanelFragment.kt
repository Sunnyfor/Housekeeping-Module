package com.zhkj.task.fragment

import android.view.View
import com.sunny.zy.base.BaseFragment
import com.zhkj.common.bean.Dictionary
import com.zhkj.common.contract.DictContract
import com.zhkj.common.presenter.DictPresenter
import com.zhkj.task.R
import com.zhkj.task.bean.TaskDetailBean
import kotlinx.android.synthetic.main.frag_task_detail.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 17:50
 */
class TaskPanelFragment : BaseFragment(), DictContract.DictView {

    var bean: TaskDetailBean? = null

    private val dictPresenter: DictContract.Presenter by lazy {
        DictPresenter(this)
    }

    override fun setLayout(): Int = R.layout.frag_task_detail

    override fun initView() {
        bean?.let { bean ->
            tv_task_name.text = bean.task?.taskName ?: ""
            tv_task_content.text = bean.task?.taskContent ?: "未填写"
            val startDate = bean.task?.taskPlanStartDate?.split(" ")?.get(0) ?: ""
            val endDate = bean.task?.taskPlanEndDate?.split(" ")?.get(0) ?: "..."
            tv_task_time.text = ("$startDate 至 $endDate")
            tv_task_principal.text = ("负责人：${(bean.task?.chargeUserName ?: "暂无")}")
            bean.relateList.filter { it.userId != bean.userEntity.userId }.forEach {
                flowlayout.addView(flowlayout.buildLabels(it.userName ?: ""))
            }

        }
    }

    override fun onClickEvent(view: View) {

    }

    override fun loadData() {
        dictPresenter.loadDict("type", "taskType")
    }

    override fun close() {

    }

    override fun showDictResult(data: ArrayList<Dictionary>) {
        data.find { bean?.task?.taskType == it.code.toString() }?.let {
            tv_task_type.text = it.value
        }

    }
}