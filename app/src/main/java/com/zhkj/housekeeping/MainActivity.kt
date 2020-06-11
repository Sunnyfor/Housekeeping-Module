package com.zhkj.housekeeping

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = "/app/MainActivity")
class MainActivity : AppCompatActivity() {

    private val myDialogFragment = MyDialogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button.setOnClickListener {

            myDialogFragment.show(fragmentManager, "我是A的dialog")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        button.postDelayed({
            Toast.makeText(this, "是否显示：${myDialogFragment.dialog.isShowing}", Toast.LENGTH_SHORT)
                .show()
        }, 3000)
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