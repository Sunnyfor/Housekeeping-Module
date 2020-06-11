package com.zhkj.housekeeping.joint


import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.sunny.zy.base.BaseActivity
import com.zhkj.housekeeping.joint.model.JointViewModel

class JointRecycleActivity : BaseActivity() {

    private val jointViewModel: JointViewModel by lazy {
        ViewModelProviders.of(this).get(JointViewModel::class.java)
    }


    override fun setLayout(): Int = 0


    override fun initView() {

        titleManager.defaultTitle(getFrameTitle(), "协同回收站")

//        jointViewModel.jointStateLiveData.observe(this, Observer { list ->
//            supportFragmentManager.beginTransaction().replace(frameBody.id, JointFragment().apply {
//                type = 2
//                joinStateList = list
//            }).commit()
//        })
    }

    override fun onClickEvent(v: View) {

    }

    override fun loadData() {
//        jointViewModel.getJointState()
    }


}