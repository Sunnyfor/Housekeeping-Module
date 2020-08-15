package com.zhkj.task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.task.R
import com.zhkj.task.bean.TaskProgressBean
import com.zhkj.user.util.UserManager
import kotlinx.android.synthetic.main.item_task_progress.view.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/14 17:36
 */
class TaskProgressAdapter(private var isManager: Boolean) :
    BaseRecycleAdapter<TaskProgressBean>(arrayListOf()) {

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_title.text = getData(position).progressContent ?: ""
        getData(position).receipt.let {
            if (it == null || it.isEmpty()) {
                holder.itemView.tv_receipt.visibility = View.GONE
            } else {
                holder.itemView.tv_receipt.visibility = View.VISIBLE
                holder.itemView.tv_receipt.text = it
            }

        }

        holder.itemView.tv_name.text = getData(position).progressAppointUserName

        if (isManager) {

            if (getData(position).progressStatus == "1") {
                holder.itemView.cl_option.visibility = View.VISIBLE
                holder.itemView.cl_manager_option.visibility = View.GONE
                holder.itemView.btn_state.text = "已完成"
            } else {
                holder.itemView.cl_manager_option.visibility = View.VISIBLE
                holder.itemView.cl_option.visibility = View.GONE
                if (getData(position).progressStatus == "4") {
                    holder.itemView.btn_improve.visibility = View.VISIBLE
                } else {
                    holder.itemView.btn_improve.visibility = View.GONE
                }
            }

        } else {
            if (getData(position).progressAppointUserId == UserManager.getLoginBean().userId) {
                holder.itemView.btn_state.text = when (getData(position).progressStatus) {
                    "2" -> "改进执行"
                    "3" -> "待执行"
                    "4" -> "待审核"
                    else -> "已完成"
                }
            } else {

                when {
                    getData(position).progressStatus == "1" -> {
                        holder.itemView.btn_state.text = "已完成"
                    }
                    getData(position).progressAppointUserId == null -> {
                        holder.itemView.btn_state.text = "待指派"
                    }
                    else -> {
                        holder.itemView.btn_state.text = "进行中"
                    }
                }
            }
            holder.itemView.cl_option.visibility = View.VISIBLE
            holder.itemView.cl_manager_option.visibility = View.GONE
        }
    }

    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.item_task_progress, parent, false)
    }
}