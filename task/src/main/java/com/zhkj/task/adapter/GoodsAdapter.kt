package com.zhkj.task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.task.R
import com.zhkj.task.bean.GoodsBean
import kotlinx.android.synthetic.main.item_goods_list.view.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/11 19:09
 */
class GoodsAdapter : BaseRecycleAdapter<GoodsBean>(arrayListOf()) {
    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_goods_title.text = getData(position).goodsName
        holder.itemView.tv_count.text = ("数量:${getData(position).goodsNum}")
        holder.itemView.tv_name.text = getData(position).createUserName
        holder.itemView.tv_date.text = getData(position).createDate
    }

    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.item_goods_list, parent, false)
    }
}