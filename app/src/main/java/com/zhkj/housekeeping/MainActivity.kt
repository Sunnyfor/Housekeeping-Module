package com.zhkj.housekeeping

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.http.OnResult
import com.sunny.zy.http.ZyHttp
import com.sunny.zy.utils.RouterPath
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@Route(path = RouterPath.APP_MAIN_ACTIVITY)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainScope().launch(Main) {

            val packInfo = packageManager.getPackageInfo(packageName, 0)
            val version = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packInfo.longVersionCode
            } else {
                packInfo.versionCode
            }

            val params = hashMapOf<String, String>()
            params["versionCode"] = version.toString()
            ZyHttp.post("app/appandroidversion/findNewOne",params,object :OnResult<String>(){})
        }
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