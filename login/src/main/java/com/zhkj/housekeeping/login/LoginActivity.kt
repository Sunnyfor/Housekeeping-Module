package com.zhkj.housekeeping.login

import android.os.Build
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.KeyEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.utils.SpUtil
import com.zhkj.housekeeping.login.presenter.LoginPresenter
import com.zhkj.user.bean.UserInfoBean
import com.zhkj.user.util.UserManager
import kotlinx.android.synthetic.main.act_login.*
import kotlinx.coroutines.cancel

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/4 18:27
 */
@Route(path = RouterPath.LOGIN_LOGIN_ACTIVITY)
class LoginActivity : BaseActivity(), LoginContract.IView {

    @JvmField
    @Autowired
    var logout: Boolean = false

    private val loginPresenter: LoginPresenter by lazy {
        LoginPresenter(this)
    }

    override fun setLayout(): Int = R.layout.act_login

    override fun initView() {
        ARouter.getInstance().inject(this)

        if (logout) {
            //关闭其他所有页面
            ZyFrameStore.finishAllActivity(this)
            SpUtil.clear()
        }

        //设置密码显示与隐藏
        cb_show_password.setOnCheckedChangeListener { _, isChecked ->
            et_password.transformationMethod = if (isChecked) {
                HideReturnsTransformationMethod.getInstance()
            } else {
                PasswordTransformationMethod.getInstance()
            }
            et_password.setSelection(et_password.text.toString().length)
        }

        //拦截键盘的ENTER进行快捷登录
        et_password.setOnEditorActionListener { _, _, event ->

            if (event.keyCode == KeyEvent.KEYCODE_ENTER) {
                btn_login.performClick()
                //获取输入服务
                hideKeyboard()
            }
            return@setOnEditorActionListener false
        }


        btn_login.setOnClickListener(this)
    }

    override fun loadData() {
        loginPresenter.checkPermission(this)
    }

    override fun close() {
        loginPresenter.cancel()
    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            btn_login.id -> {
                loginPresenter.login(et_username.text.toString(), et_password.text.toString())
            }
        }
    }

    override fun showLoginResult(user: UserInfoBean) {
        UserManager.saveUserInfoBean(user)
        ARouter.getInstance().build(RouterPath.APP_MAIN_ACTIVITY).navigation()
        finish()
    }


    override fun permissionOk() {
        UserManager.getUserInfoBean().let {
            if (it.hasValue) {
                showLoginResult(it)
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun permissionsNo(permissions: Array<String>) {
        AlertDialog.Builder(this)
            .setCancelable(true)
            .setTitle("提示")
            .setMessage("获取不到授权，APP将无法正常使用，请允许APP获取权限！")
            .setPositiveButton("确定") { _, _ ->
                requestPermissions(permissions, BuildConfig.VERSION_CODE)
            }.setNegativeButton("取消") { _, _ ->
                finish()
            }.show()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //检查APP权限
        loginPresenter.checkPermission(this)
    }

}