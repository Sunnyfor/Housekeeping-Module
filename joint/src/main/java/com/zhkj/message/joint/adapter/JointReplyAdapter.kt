package com.zhkj.message.joint.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.message.joint.R
import com.zhkj.message.joint.bean.JointBean
import com.zhkj.user.util.UserManager
import kotlinx.android.synthetic.main.item_joint_msg_left.view.*
import kotlinx.android.synthetic.main.item_joint_msg_right.view.*

class JointReplyAdapter(list: ArrayList<JointBean.Reply>) :
    BaseRecycleAdapter<JointBean.Reply>(list) {

    var data = ""

    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return if (viewType == 0) { // 0 是自己
            LayoutInflater.from(context).inflate(R.layout.item_joint_msg_right, parent, false)
        } else {
            LayoutInflater.from(context).inflate(R.layout.item_joint_msg_left, parent, false)
        }
    }

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {

        val timeList = getData(position).sendTime?.split(" ")
        val content = getData(position).content

        if (getItemViewType(position) == 0) {
            holder.itemView.tv_username_right?.text =
                ("${timeList?.get(1)} ${getData(position).userName ?: ""}")
            holder.itemView.tv_message_right.text = content ?: ""
            if (timeList?.get(0) != data) {
                data = timeList?.get(0) ?: ""
                holder.itemView.tv_right_date.visibility = View.VISIBLE
                holder.itemView.tv_right_date.text = data
            } else {
                holder.itemView.tv_right_date.visibility = View.GONE
            }
        } else {
            holder.itemView.tv_username_left?.text =
                ("${getData(position).userName ?: ""} ${timeList?.get(1)}")
            holder.itemView.tv_message_left.text = content ?: ""
            if (timeList?.get(0) != data) {
                data = timeList?.get(0) ?: ""
                holder.itemView.tv_left_date.visibility = View.VISIBLE
                holder.itemView.tv_left_date.text = data
            } else {
                holder.itemView.tv_left_date.visibility = View.GONE
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        if (getData(position).userId == UserManager.getUserInfoBean().userId) 0 else 1
}