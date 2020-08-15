package com.zhkj.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.zhkj.user.R
import com.zhkj.user.SelectUserActivity
import com.zhkj.user.bean.OtherUserBean
import kotlinx.android.synthetic.main.item_select_user.view.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 15:51
 */
class SelectUserAdapter(list: ArrayList<OtherUserBean>) :
    BaseRecycleAdapter<OtherUserBean>(list) {

    var checkLock = false

    init {
        setOnItemClickListener { view, _ ->
            view.findViewById<CheckBox>(R.id.checkbox).performClick()
        }
    }


    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {
        holder.itemView.tv_name.text = getData(position).username ?: ""
        holder.itemView.tv_email.text = getData(position).email ?: ""

        checkLock = true
        holder.itemView.checkbox.isChecked = getData(position).isAlreadyJoinPeople
        checkLock = false

        if (context is SelectUserActivity) {
            if (getData(position).userId == (context as SelectUserActivity).chargeUserId) {
                holder.itemView.checkbox.isEnabled = false
                holder.itemView.checkbox.setOnCheckedChangeListener(null)
            } else {
                holder.itemView.checkbox.isEnabled = true
                setOnCheckedListener(holder.itemView.checkbox, position, true)
            }
        } else {
            setOnCheckedListener(holder.itemView.checkbox, position)
        }
    }

    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.item_select_user, parent, false)
    }

    private fun setOnCheckedListener(checkBox: CheckBox, position: Int, isSingle: Boolean = false) {
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (checkLock) {
                return@setOnCheckedChangeListener
            }
            if (isSingle) {
                (context as SelectUserActivity).allList.forEach { bean ->
                    bean.forEach {
                        it.isAlreadyJoinPeople = false
                    }
                }
            }
            getData(position).isAlreadyJoinPeople = isChecked
        }
    }
}