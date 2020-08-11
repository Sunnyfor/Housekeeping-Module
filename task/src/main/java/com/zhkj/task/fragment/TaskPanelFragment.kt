package com.zhkj.task.fragment

import android.view.View
import com.sunny.zy.base.BaseFragment
import com.zhkj.task.R
import com.zhkj.task.bean.TaskDetailBean
import kotlinx.android.synthetic.main.frag_task_detail.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 17:50
 */
class TaskPanelFragment : BaseFragment() {

    var bean: TaskDetailBean? = null

    override fun setLayout(): Int = R.layout.frag_task_detail

    override fun initView() {
        bean?.let { bean ->
            tv_task_name.text = bean.task?.taskName ?: ""
            tv_task_content.text = bean.task?.taskContent ?: "未填写"
            tv_task_time.text =
                ((bean.task?.taskPlanStartDate ?: "") + " 至 " + (bean.task?.taskPlanEndDate ?: "..."))
            tv_task_principal.text = bean.task?.chargeUserName ?: "暂无"
            bean.relateList.filter { it.userId != bean.userEntity.userId }.forEach {
                flowlayout.addView(flowlayout.buildLabels(it.userName ?: ""))
            }

        }
    }

    override fun onClickEvent(view: View) {

    }

    override fun loadData() {

    }

    override fun close() {

    }
}