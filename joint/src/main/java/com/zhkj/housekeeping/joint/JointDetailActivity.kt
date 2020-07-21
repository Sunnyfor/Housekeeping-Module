package com.zhkj.housekeeping.joint

import android.view.Menu
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import kotlinx.android.synthetic.main.act_joint_detail.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/21 19:11
 */
@Route(path = RouterPath.JOINT_DETAIL_ACTIVITY)
class JointDetailActivity : BaseActivity() {

    lateinit var toolbar: Toolbar

    override fun setLayout(): Int = R.layout.act_joint_detail

    override fun initView() {
        ARouter.getInstance().inject(this)

        toolbar = defaultTitle("协同详情")
        toolbar.setOnMenuItemClickListener {
            if (drawer_layout.isDrawerOpen(GravityCompat.END)) {
                drawer_layout.closeDrawer(GravityCompat.END)
            } else {
                drawer_layout.openDrawer(GravityCompat.END)
            }
            return@setOnMenuItemClickListener true
        }
    }

    override fun loadData() {

    }

    override fun onClickEvent(view: View) {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        toolbar.inflateMenu(R.menu.menu_joint_detail_title)
        return true
    }


    override fun close() {

    }
}