package com.zhkj.signin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.signin.bean.SignInBean
import com.zhkj.signin.R
import kotlinx.android.synthetic.main.item_sign_in_record.view.*

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/8 17:55
 */
class SignInRecordAdapter : BaseRecycleAdapter<SignInBean>(arrayListOf()) {
    override fun setLayout(parent: ViewGroup, viewType: Int): View =
        LayoutInflater.from(context).inflate(R.layout.item_sign_in_record, parent, false)

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_time.text = getData(position).signTime
        holder.itemView.tv_temperature.text = ("${getData(position).userTemperature} °C")
    }
}