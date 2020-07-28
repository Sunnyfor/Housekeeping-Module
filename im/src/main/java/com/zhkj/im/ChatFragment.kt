package com.zhkj.im

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sunny.zy.base.BaseFragment
import com.sunny.zy.fragment.PullRefreshFragment
import com.zhkj.im.bean.ChatMsgBean
import kotlinx.android.synthetic.main.fram_chat.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/28 15:39
 */
class ChatFragment : BaseFragment() {

    private val pullRefreshFragment = PullRefreshFragment<ChatMsgBean>()

    override fun setLayout(): Int = R.layout.fram_chat

    override fun initView() {
        childFragmentManager.beginTransaction().replace(cl_content.id, pullRefreshFragment).commit()
        edit_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.isEmpty()) {
                    view_add.visibility = View.VISIBLE
                    btn_send.visibility = View.GONE
                } else {
                    btn_send.visibility = View.VISIBLE
                    view_add.visibility = View.GONE
                }
            }

        })
    }

    override fun onClickEvent(view: View) {

    }

    override fun loadData() {

    }

    override fun close() {

    }
}