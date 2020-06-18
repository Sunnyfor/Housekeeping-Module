package com.zhkj.housekeeping.message

import android.view.View
import com.sunny.zy.base.BaseFragment

class MessageFragment : BaseFragment() {
    override fun setLayout(): Int = R.layout.fram_message

    override fun initView() {
        getBaseActivity().simpleTitle(getString(R.string.message))
    }

    override fun loadData() {

    }

    override fun close() {

    }

    override fun onClick(v: View?) {

    }
}