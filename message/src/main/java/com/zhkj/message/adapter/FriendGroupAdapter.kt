package com.zhkj.message.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.utils.GlideApp
import com.sunny.zy.utils.RouterPath
import com.zhkj.message.R
import com.zhkj.message.bean.FriendsBean
import kotlinx.android.synthetic.main.item_message_group.view.*
import kotlinx.android.synthetic.main.item_message_user.view.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/24 12:03
 */
class FriendGroupAdapter : BaseRecycleAdapter<Any>(arrayListOf()) {

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {

        //分组
        if (getData(position) is FriendsBean.Groups) {
            (getData(position) as FriendsBean.Groups).let {
                holder.itemView.tv_group_name.text = it.groupname
                holder.itemView.tv_group_count.text = ("[ ${(it.list?.size ?: 0).toString()} ]")

                if (it.isExpand) {
                    holder.itemView.iv_group_state.setImageResource(R.drawable.svg_message_expansion)
                } else {
                    holder.itemView.iv_group_state.setImageResource(R.drawable.svg_message_pack_up)
                }

                holder.itemView.setOnClickListener { _ ->
                    it.isExpand = !it.isExpand
                    val childList = arrayListOf<Any>()
                    childList.addAll(it.list ?: arrayListOf())
                    if (it.isExpand) {
                        getData().addAll(position + 1, childList)
                    } else {
                        getData().removeAll(childList)
                    }
                    notifyDataSetChanged()
                }
            }
            return
        }

        //群组
        if (getData(position) is FriendsBean.Groups.Group) {
            (getData(position) as FriendsBean.Groups.Group).let {
                holder.itemView.tv_name.text = it.groupname
                if (it.avatar.isNullOrEmpty()) {
                    holder.itemView.iv_head.setImageResource(R.drawable.icon_default_head)
                } else {
                    GlideApp.with(context).load("${UrlConstant.host}${it.avatar}")
                        .placeholder(R.drawable.icon_default_head)
                        .into(holder.itemView.iv_head)
                }
                holder.itemView.setOnClickListener { _ ->
                    ARouter.getInstance().build(RouterPath.IM_CHAT_ACTIVITY)
                        .withString("title", it.groupname)
                        .withString("id", it.id)
                        .navigation()
                }
            }

            return
        }
    }

    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(viewType, parent, false)
    }

    override fun getItemViewType(position: Int): Int {

        if (getData(position) is FriendsBean.Groups) {
            return R.layout.item_message_group
        }
        return R.layout.item_message_user
    }
}