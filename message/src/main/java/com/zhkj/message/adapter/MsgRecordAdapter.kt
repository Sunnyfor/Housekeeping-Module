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
import kotlinx.android.synthetic.main.item_chat_msg_left_photo.view.*
import kotlinx.android.synthetic.main.item_chat_msg_left_text.view.*
import kotlinx.android.synthetic.main.item_chat_msg_right_photo.view.*
import kotlinx.android.synthetic.main.item_chat_msg_right_text.view.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/29 14:55
 */
class MsgRecordAdapter : BaseRecycleAdapter<MsgRecordBean>(arrayListOf()) {

    override fun onBindViewHolder(holder: BaseRecycleViewHolder, position: Int) {

        when (getItemViewType(position)) {
            R.layout.item_chat_msg_right_text -> {
                processUserName(position, holder.itemView.tv_username_right_text)
                processContent(position, holder.itemView.tv_message_right)
            }
            R.layout.item_chat_msg_right_photo -> {
                processUserName(position, holder.itemView.tv_username_right_photo)
                processContent(position, holder.itemView.iv_photo_right)
            }

            R.layout.item_chat_msg_left_text -> {
                processUserName(position, holder.itemView.tv_username_left_text)
                processContent(position, holder.itemView.tv_message_left)
            }

            R.layout.item_chat_msg_left_photo -> {
                processUserName(position, holder.itemView.tv_username_left_photo)
                processContent(position, holder.itemView.iv_photo_left)
            }
        }
    }


    override fun setLayout(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(context).inflate(viewType, parent, false)
    }


    override fun getItemViewType(position: Int): Int {
        if (getData(position).uid == UserManager.getLoginBean().userId) {
            if (getData(position).content?.contains(MsgUrlConstant.IMAGE_TAG) == true) {
                return R.layout.item_chat_msg_right_photo
            }
            return R.layout.item_chat_msg_right_text
        }
        if (getData(position).content?.contains(MsgUrlConstant.IMAGE_TAG) == true) {
            return R.layout.item_chat_msg_left_photo
        }
        return R.layout.item_chat_msg_left_text
    }


    private fun processUserName(position: Int, textView: TextView) {
        textView.text = ("${getData(position).username} \t ${getData(position).time}")
    }


    private fun processContent(position: Int, imageView: ImageView) {
        getData(position).content?.let {
            val url = it.substring(4, it.length - 1)
            GlideApp.with(context)
                .load(UrlConstant.HOST + url)
                .into(imageView)
        }
    }


    private fun processContent(position: Int, textView: TextView) {
        getData(position).content?.let {
            textView.text = it
//                    FaceUtil.handlerMsg(holder.itemView.tv_message_left, getData(position).content)
        }
    }
}