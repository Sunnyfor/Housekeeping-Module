package com.zhkj.housekeeping.plan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.housekeeping.plan.R
import com.zhkj.housekeeping.plan.bean.PlanBean
import kotlinx.android.synthetic.main.item_plan_list.view.*

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/9 11:57
 */
class PlanListAdapter : BaseRecycleAdapter<PlanBean>(arrayListOf()) {
    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_task_name.text = getData(position).planTitle
        holder.itemView.tv_task_time.text =
            ("${getData(position).planStartDate.replace(
                " 00:00:00",
                ""
            )} 至 ${getData(position).planEndDate.replace(" 00:00:00", "")}")
    }

    override fun setLayout(parent: ViewGroup, viewType: Int): View =
        LayoutInflater.from(context).inflate(
            R.layout.item_plan_list, parent, false
        )
}