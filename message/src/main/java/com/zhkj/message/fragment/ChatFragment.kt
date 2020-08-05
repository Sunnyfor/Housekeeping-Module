package com.zhkj.message.fragment

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunny.zy.base.BaseFragment
import com.zhkj.message.R
import com.zhkj.message.adapter.MsgRecordAdapter
import com.zhkj.message.bean.MsgRecordBean
import com.zhkj.message.contract.MessageContract
import com.zhkj.message.presenter.MessagePresenter
import kotlinx.android.synthetic.main.fram_chat.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/28 15:39
 */
class ChatFragment : BaseFragment(), MessageContract.IMsgRecordView {

    private val presenter: MessageContract.Presenter by lazy {
        MessagePresenter(this)
    }

    private val chatId: String by lazy {
        arguments?.getString("id", "") ?: ""
    }

    private val adapter = MsgRecordAdapter()

    private var isFirst = true

    private var page = 1

    override fun setLayout(): Int = R.layout.fram_chat

    override fun initView() {

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

//        recycler.set


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
        presenter.loadChatRecord(chatId, page.toString())
    }

    override fun close() {

    }

    override fun showMsgRecordData(data: ArrayList<MsgRecordBean>) {
        adapter.getData().let {
            adapter.getData().addAll(0, it)
            adapter.notifyDataSetChanged()

            if (page == 1) {
                if (adapter.itemCount > 0) {
                    recycler.layoutManager?.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }
}