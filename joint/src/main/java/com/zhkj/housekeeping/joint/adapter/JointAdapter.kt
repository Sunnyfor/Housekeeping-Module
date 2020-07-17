package com.zhkj.housekeeping.joint.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.housekeeping.joint.R
import com.zhkj.housekeeping.joint.bean.JointBean
import kotlinx.android.synthetic.main.item_joint_list.view.*

class JointAdapter() : BaseRecycleAdapter<JointBean>(arrayListOf()) {
    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.item_joint_list, parent, false)
    }

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_joint_name.text = getData(position).synergyTitle
        holder.itemView.tv_joint_content.text = getData(position).content ?: "未填写"

        if (getData(position).isDelete == 0) {
            holder.itemView.tv_state.text = "已删除"
            holder.itemView.tv_joint_name.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
            holder.itemView.tv_task_person.text = getData(position).userName
        } else {
            holder.itemView.tv_state.text = getData(position).stateName ?: "未知"
            holder.itemView.tv_task_person.text = getData(position).synergyNames
        }

        holder.itemView.tv_date.text = getData(position).createDate?.replace(" 00:00:00", "")

    }
}