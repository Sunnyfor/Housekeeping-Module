package com.zhkj.housekeeping.joint.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.housekeeping.work.joint.bean.JointBean
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.housekeeping.joint.R
import kotlinx.android.synthetic.main.item_joint_list.view.*

class JointAdapter(list: ArrayList<JointBean>) : BaseRecycleAdapter<JointBean>(list) {
    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.item_joint_list, parent, false)
    }

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_task_name.text = getData(position).content

        holder.itemView.tv_state.text = getData(position).stateName

        if (getData(position).isDelete == 0) {
            holder.itemView.tv_task_name.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
            holder.itemView.tv_task_person.text = getData(position).userName
        } else {
            holder.itemView.tv_task_person.text = getData(position).synergyNames
        }

        try {
            holder.itemView.tv_date.text = getData(position).createDate.split(" ")[0]
        } catch (e: Exception) {
            holder.itemView.tv_date.text = getData(position).createDate
        }
    }
}