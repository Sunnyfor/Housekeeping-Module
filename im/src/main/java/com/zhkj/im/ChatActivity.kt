package com.zhkj.im

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/28 18:30
 */
@Route(path = RouterPath.IM_CHAT_ACTIVITY)
class ChatActivity : BaseActivity() {

    @Autowired
    @JvmField
    var id = ""

    @Autowired
    @JvmField
    var title = ""

    private val chatFragment = ChatFragment()

    override fun setLayout(): Int = 0

    override fun initView() {

        ARouter.getInstance().inject(this)

        defaultTitle(title)
        supportFragmentManager.beginTransaction().replace(getFrameBody().id, chatFragment).commit()
    }

    override fun loadData() {

    }

    override fun onClickEvent(view: View) {

    }

    override fun close() {

    }
}