package com.zhkj.task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.task.R
import com.zhkj.task.bean.TaskBean
import kotlinx.android.synthetic.main.item_task_list.view.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 11:29
 */
class TaskAdapter : BaseRecycleAdapter<TaskBean.Task>(arrayListOf()) {
    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_name.text =
            ("[" + getData(position).taskDeptName + "]  " +getData(position).chargeUserName )
        holder.itemView.tv_joint_title.text = getData(position).taskName
        holder.itemView.tv_state.text = getData(position).taskStateStr
        holder.itemView.ratingbar.setStar(getData(position).taskLevel.toFloat())
    }

    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.item_task_list, parent, false)
    }
}