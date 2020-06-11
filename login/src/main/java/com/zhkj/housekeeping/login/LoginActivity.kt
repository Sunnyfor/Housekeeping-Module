package com.zhkj.housekeeping.login

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.KeyEvent
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseActivity
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

    private var username = SpUtil.getString(SpUtil.username)
    private var password = SpUtil.getString(SpUtil.password)

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
        et_password.setOnEditorActionListener { _, _, event ->

            if (event.keyCode == KeyEvent.KEYCODE_ENTER) {
                btn_login.performClick()
            }
            return@setOnEditorActionListener false
        }


        btn_login.setOnClickListener(this)
    }

    override fun loadData() {

    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            btn_login.id -> {
                loginPresenter.login(et_username.text.toString(), et_password.text.toString())
            }
        }
    }

    override fun loginResult(user: UserInfoBean) {
        ARouter.getInstance().build("/app/MainActivity").navigation()
        finish()
    }

}