package com.zhkj.housekeeping

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.utils.RouterPath
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RouterPath.APP_MAIN_ACTIVITY)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setupWithNavController(nav_host_fragment.findNavController())
//
    }


//
//    override fun initView() {
//
//        //导航切换
//        bottom_navigation.setOnNavigationItemSelectedListener {
//
//            when(it.title){
//                getString(R.string.workbench) ->{
//                    ToastUtil.show("条件成立1")
//                }
//                getString(R.string.message) -> {
//                    ToastUtil.show("条件成立2")
//                }
//
//                getString(R.string.mine) -> {
//                    ToastUtil.show("条件成立3")
//                }
//            }
//            return@setOnNavigationItemSelectedListener true
//        }
//    }
//
//    override fun loadData() {
//
//    }
//
//    override fun onClickEvent(view: View) {
//
//    }

}