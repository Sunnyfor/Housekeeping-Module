package com.sunny.zy.title

import android.view.View
import android.view.ViewGroup
import com.sunny.zy.base.BaseActivity

/**
 *
 * Created by ZhangYe on 2018/8/2.
 */
class TitleManager(private var baseActivity: BaseActivity) {

    fun defaultTitle(
        frameTitle: ViewGroup,
        title: String,
        subtitle: String = ""
    ): DefaultTitleBean {
        frameTitle.visibility = View.VISIBLE
        val defaultTitleBean = DefaultTitleBean(baseActivity)
        defaultTitleBean.setTitle(title)
        defaultTitleBean.setLeftOnClickListener(View.OnClickListener {
            baseActivity.finish()
        })
        defaultTitleBean.showView(frameTitle)
        return defaultTitleBean
    }
}