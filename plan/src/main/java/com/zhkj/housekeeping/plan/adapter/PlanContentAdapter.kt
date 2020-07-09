package com.zhkj.housekeeping.plan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.housekeeping.plan.R
import kotlinx.android.synthetic.main.item_plan_content.view.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/9 17:59
 */
class PlanContentAdapter(
    list: ArrayList<String>,
    var deleteClickListener: (view: View, position: Int) -> Unit
) : BaseRecycleAdapter<String>(list) {

    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.item_plan_content, parent, false)
    }

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_content.text = getData(position)
        holder.itemView.setOnClickListener(null)
        holder.itemView.btn_delete.setOnClickListener {
            deleteClickListener.invoke(it, position)
        }
    }
}