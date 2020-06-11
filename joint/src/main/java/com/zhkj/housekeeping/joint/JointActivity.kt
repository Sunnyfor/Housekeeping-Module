package com.zhkj.housekeeping.joint

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.sunny.zy.base.BaseActivity
import kotlinx.android.synthetic.main.act_joint.*

class JointActivity : BaseActivity() {


    private var fragmentList = ArrayList<JointFragment>()
    private var titleList = arrayOf("我发起", "我协同")

    override fun setLayout(): Int = R.layout.act_joint

//    override fun initTitle(): View? {
////        return titleManager.rightTitle("协同大厅", "回收站") {
////            startActivity(Intent(this, JointRecycleActivity::class.java))
////        }
//        return null
//    }

    override fun initView() {
//        jointViewModel.jointStateLiveData.observe(this, Observer { list ->
        hideLoading()
        fragmentList.add(JointFragment().apply {
            type = 0
//                joinStateList = list ?: arrayListOf()
        })
        fragmentList.add(JointFragment().apply {
            type = 1
//                joinStateList = list ?: arrayListOf()
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
//        launch(Main) {
//            showLoading()
//            jointViewModel.getJointState()
//        }

    }


    fun refresh() {
        onActivityResult(0, Activity.RESULT_OK, null)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            fragmentList.forEach {
                it.loadData()
            }
        }
    }
}