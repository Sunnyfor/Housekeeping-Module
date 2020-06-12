package com.zhkj.housekeeping.login

import android.content.Context
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.utils.SpUtil
import com.zhkj.housekeeping.login.bean.UserInfoBean
import com.zhkj.housekeeping.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.act_login.*

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/4 18:27
 */
class LoginActivity : BaseActivity(), LoginContract.IView {

    private val loginPresenter: LoginPresenter by lazy {
        LoginPresenter(this)
    }

    override fun setLayout(): Int = R.layout.act_login

    override fun initView() {

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
        et_password.setOnEditorActionListener { v, _, event ->

            if (event.keyCode == KeyEvent.KEYCODE_ENTER) {
                btn_login.performClick()
                //获取输入服务
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                if (imm.isActive)
                    imm.hideSoftInputFromWindow(v.applicationWindowToken, 0)
            }
            return@setOnEditorActionListener false
        }


        btn_login.setOnClickListener(this)
    }

    override fun loadData() {
        val userInfoBean = SpUtil.getObject(SpUtil.userInfoBean, UserInfoBean::class.java)
        if (userInfoBean != null) {
            loginResult(userInfoBean)
        }
    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            btn_login.id -> {
                loginPresenter.login(et_username.text.toString(), et_password.text.toString())
            }
        }
    }

    override fun loginResult(user: UserInfoBean) {
        ARouter.getInstance().build(RouterPath.APP_MAIN_ACTIVITY).navigation()
        finish()
    }

}