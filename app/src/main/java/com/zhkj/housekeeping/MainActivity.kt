package com.zhkj.housekeeping

import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RouterPath.APP_MAIN_ACTIVITY)
class MainActivity : BaseActivity() {


    override fun setLayout(): Int = R.layout.activity_main

    override fun initView() {

    }

    override fun loadData() {
        bottom_navigation.setupWithNavController(nav_host_fragment.findNavController())
    }

    override fun onClickEvent(view: View) {

    }

}