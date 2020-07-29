package com.zhkj.message.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sunny.zy.base.BaseRecycleAdapter
import com.sunny.zy.base.BaseRecycleViewHolder
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.utils.GlideApp
import com.zhkj.message.R
import com.zhkj.message.bean.MsgRecordBean
import com.zhkj.message.http.MsgUrlConstant
import com.zhkj.user.util.UserManager
import kotlinx.android.synthetic.main.item_chat_msg_left.view.*
import kotlinx.android.synthetic.main.item_chat_msg_right.view.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/29 14:55
 */
class MsgRecordAdapter : BaseRecycleAdapter<MsgRecordBean>(arrayListOf()) {

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {

        if (getItemViewType(position) == R.layout.item_chat_msg_right) {

            processContent(
                getData(position).content,
                holder.itemView.tv_message_right,
                holder.itemView.iv_photo_right
            )

            holder.itemView.tv_username_right?.text =
                ("${getData(position).username} \t ${getData(position).time}")

        } else if (getItemViewType(position) == R.layout.item_chat_msg_left) {

            processContent(
                getData(position).content,
                holder.itemView.tv_message_left,
                holder.itemView.iv_photo_left
            )
            holder.itemView.tv_username_left?.text =
                ("${getData(position).username} \t ${getData(position).time}")

        }
    }


    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(viewType, parent, false)
    }


    override fun getItemViewType(position: Int): Int {
        if (getData(position).uid == UserManager.getUserInfoBean().userId) {
            return R.layout.item_chat_msg_right
        }
        return R.layout.item_chat_msg_left
    }


    private fun processContent(content: String?, textView: TextView, imageView: ImageView) {
        content?.let {
            if (it.contains(MsgUrlConstant.IMAGE_TAG)) {
                val url = it.substring(4, it.length - 1)
                imageView.visibility = View.VISIBLE
                textView.visibility = View.GONE
                GlideApp.with(context)
                    .load(UrlConstant.host + url)
                    .dontAnimate()
                    .into(imageView)
            } else {
                imageView.visibility = View.GONE
                textView.visibility = View.VISIBLE
                textView.text = content
//                    FaceUtil.handlerMsg(holder.itemView.tv_message_left, getData(position).content)
            }
        }
    }
}