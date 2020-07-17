package com.zhkj.housekeeping.joint.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhkj.housekeeping.joint.bean.Reply
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.housekeeping.joint.R
import kotlinx.android.synthetic.main.item_chat_msg_left.view.*
import kotlinx.android.synthetic.main.item_chat_msg_right.view.*

class JointReplyAdapter(list: ArrayList<Reply>) : BaseRecycleAdapter<Reply>(list) {
    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return if (viewType == 0) { // 0 是自己
            LayoutInflater.from(context).inflate(R.layout.item_chat_msg_right, parent, false)
        } else {
            LayoutInflater.from(context).inflate(R.layout.item_chat_msg_left, parent, false)
        }
    }

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
//        if (getItemViewType(position) == 0) {
//            holder.itemView.tv_message_right.text = getData(position).replayContent
//            holder.itemView.tv_username_right?.text = ("${getData(position).sendUserName} \t ${getData(position).createDate}")
//        } else {
//            holder.itemView.tv_message_left.text = getData(position).replayContent
//            holder.itemView.tv_username_left?.text = ("${getData(position).sendUserName} \t ${getData(position).createDate}")
//        }
    }

//    override fun getItemViewType(position: Int): Int = if (getData(position).sendUserId.toString() == "1") 0 else 1
}