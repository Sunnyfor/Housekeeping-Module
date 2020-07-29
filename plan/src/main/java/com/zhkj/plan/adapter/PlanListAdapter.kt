package com.zhkj.plan.adapter

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.plan.R
import com.zhkj.plan.bean.PlanBean
import kotlinx.android.synthetic.main.item_plan_list.view.*

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/9 11:57
 */
class PlanListAdapter : BaseRecycleAdapter<PlanBean>(arrayListOf()) {

    var settingOnClickListener: ISettingOnClickListener? = null

    private val settingList = arrayListOf("完成", "删除", "周数据下移")

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_task_name.text = getData(position).planTitle
        holder.itemView.tv_task_time.text =
            ("${getData(position).planStartDate.replace(
                " 00:00:00",
                ""
            )} 至 ${getData(position).planEndDate.replace(" 00:00:00", "")}")

        holder.itemView.tv_task_status.text = getData(position).activeStatusName

        holder.itemView.view_setting.setOnClickListener {
            showSettingDialog(getData(position))
        }
    }

    override fun setLayout(parent: ViewGroup, viewType: Int): View =
        LayoutInflater.from(context).inflate(R.layout.item_plan_list, parent, false)


    private fun showSettingDialog(bean: PlanBean) {
        val settingArray = if (bean.activeStatus == 2) {
            Array(1) { settingList[1] }
        } else {
            Array(settingList.size) { settingList[it] }
        }

        AlertDialog.Builder(context)
            .setTitle("选择操作")
            .setItems(settingArray) { _: DialogInterface, i: Int ->
                when (settingArray[i]) {
                    settingList[0] -> {
                        settingOnClickListener?.onCompleteClickListener(bean)
                    }
                    settingList[1] -> {
                        settingOnClickListener?.onDeleteClickListener(bean)
                    }
                    settingList[2] -> {
                        settingOnClickListener?.onNextClickListener(bean)
                    }

                }

            }
            .show()
    }

    interface ISettingOnClickListener {
        fun onCompleteClickListener(bean: PlanBean)
        fun onDeleteClickListener(bean: PlanBean)
        fun onNextClickListener(bean: PlanBean)

    }
}