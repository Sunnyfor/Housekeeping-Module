package com.zhkj.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.user.R
import com.zhkj.user.bean.OtherUserBean
import kotlinx.android.synthetic.main.item_select_user.view.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 15:51
 */
class SelectUserAdapter(list: ArrayList<OtherUserBean>) : BaseRecycleAdapter<OtherUserBean>(list) {

    var checkLock = false

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_name.text = getData(position).username ?: ""
        holder.itemView.tv_email.text = getData(position).email ?: ""

        checkLock = true
        holder.itemView.checkbox.isChecked = getData(position).isAlreadyJoinPeople
        checkLock = false
        holder.itemView.checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (checkLock) {
                return@setOnCheckedChangeListener
            }
            getData(position).isAlreadyJoinPeople = isChecked
        }
    }

    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.item_select_user, parent, false)
    }
}