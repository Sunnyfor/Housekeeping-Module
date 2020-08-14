package com.zhkj.task.fragment

import android.view.View
import com.sunny.zy.base.BaseFragment
import com.zhkj.task.R
import com.zhkj.task.bean.TaskDetailBean
import kotlinx.android.synthetic.main.frag_task_finish.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 18:50
 */
class TaskFinishPanelFragment : BaseFragment() {

    var bean: TaskDetailBean? = null

    override fun setLayout(): Int = R.layout.frag_task_finish

    override fun initView() {
        setOnClickListener(rl_task_attachment)
    }

    override fun onClickEvent(view: View) {
        when(view.id){
            rl_task_attachment.id -> {

            }
        }
    }

    override fun loadData() {

    }

    override fun close() {

    }
}