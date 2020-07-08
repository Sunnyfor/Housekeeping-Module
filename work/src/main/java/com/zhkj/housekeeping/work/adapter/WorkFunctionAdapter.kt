package com.zhkj.housekeeping.work.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.housekeeping.work.R
import com.zhkj.housekeeping.work.bean.FunctionBean
import kotlinx.android.synthetic.main.item_work_function.view.*

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/7 12:03
 */
class WorkFunctionAdapter(list: ArrayList<FunctionBean>) : BaseRecycleAdapter<FunctionBean>(list) {
    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.view_icon.setBackgroundResource(getData(position).icon)
        holder.itemView.tv_name.text = getData(position).title
        holder.itemView.setOnClickListener(getData(position).onClickListener)
    }

    override fun setLayout(parent: ViewGroup, viewType: Int): View =
        LayoutInflater.from(context).inflate(R.layout.item_work_function, parent, false)
}