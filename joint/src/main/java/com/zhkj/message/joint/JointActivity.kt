package com.zhkj.message.joint

import android.app.Activity
import android.content.Intent
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import kotlinx.android.synthetic.main.act_joint.*

@Route(path = RouterPath.JOINT_ACTIVITY)
class JointActivity : BaseActivity() {


    private var fragmentList = ArrayList<JointFragment>()
    private var titleList = arrayOf("我发起", "我协同")

    private lateinit var toolbar: Toolbar

    override fun setLayout(): Int = R.layout.act_joint

    override fun initView() {

        toolbar = defaultTitle("协同大厅")
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_recycle_bin -> {
                    ARouter.getInstance().build(RouterPath.JOINT_RECYCLE_ACTIVITY).navigation()
                }

                R.id.menu_add -> {
                    ARouter.getInstance().build(RouterPath.JOINT_CREATE_ACTIVITY)
                        .navigation(this, 11000)
                }

            }
            return@setOnMenuItemClickListener true
        }


        fragmentList.add(JointFragment().apply {
            type = 0
        })
        fragmentList.add(JointFragment().apply {
            type = 1
        })
        viewPager.offscreenPageLimit = 2
        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager, 0) {
            override fun getItem(position: Int): Fragment = fragmentList[position]

            override fun getCount(): Int = fragmentList.size

            override fun getPageTitle(position: Int): CharSequence = titleList[position]
        }

        tab_layout.setupWithViewPager(viewPager)
//        })

//        btn_menu.setOnClickListener(this)
    }

    override fun onClickEvent(v: View) {
        when (v.id) {
//            btn_menu.id -> {
//                startActivityForResult(Intent(this, JointCreateActivity::class.java), 200)
//            }
        }

    }

    override fun loadData() {

    }

    override fun close() {

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        toolbar.inflateMenu(R.menu.menu_joint_home_title)
        return true
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 11000 && resultCode == Activity.RESULT_OK) {

            fragmentList[0].let {
                it.page = 1
                it.loadData()
            }

        }
    }
}