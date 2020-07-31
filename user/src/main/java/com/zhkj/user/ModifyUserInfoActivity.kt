package com.zhkj.user

import android.app.Activity
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.utils.ToastUtil
import com.zhkj.user.bean.UserInfoBean
import com.zhkj.user.contract.UserContract
import com.zhkj.user.presenter.UserPresenter
import kotlinx.android.synthetic.main.act_modify_user_info.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/30 17:42
 */
@Route(path = RouterPath.USER_MODIFY_INFO_ACTIVITY)
class ModifyUserInfoActivity : BaseActivity(), UserContract.UpdateView {

    @Autowired
    @JvmField
    var type: String? = ""

    private val userInfoBean: UserInfoBean? by lazy {
        ZyFrameStore.getData<UserInfoBean>(UserInfoBean::class.java.simpleName)
    }

    val presenter: UserContract.UserPresenter by lazy {
        UserPresenter(this)
    }

    override fun setLayout(): Int = R.layout.act_modify_user_info

    override fun initView() {
        ARouter.getInstance().inject(this)

        defaultTitle("修改$type")


        when (type) {
            getString(R.string.user_name) -> {
                edit_content.setText(userInfoBean?.username ?: "")
            }
            getString(R.string.user_phone) -> {
                edit_content.setText(userInfoBean?.mobile ?: "")
            }
            getString(R.string.user_email) -> {
                edit_content.setText(userInfoBean?.email ?: "")
            }
        }
        edit_content.setSelection(edit_content.text.length)

        setOnClickListener(btn_save)

    }

    override fun loadData() {

    }

    override fun onClickEvent(view: View) {
        if (view.id == btn_save.id) {
            when (type) {
                getString(R.string.user_name) -> {
                    if (edit_content.text.isEmpty()) {
                        return ToastUtil.show("请输入$type！")
                    }
                    presenter.updateUserInfo(userInfoBean?.getJsonObject()?.apply {
                        put("username", edit_content.text.toString())
                    }.toString())
                }
                getString(R.string.user_phone) -> {
                    presenter.updateUserInfo(userInfoBean?.getJsonObject()?.apply {
                        put("mobile", edit_content.text.toString())
                    }.toString())
                }
                getString(R.string.user_email) -> {
                    presenter.updateUserInfo(userInfoBean?.getJsonObject()?.apply {
                        put("email", edit_content.text.toString())
                    }.toString())
                }
            }
        }
    }

    override fun close() {

    }

    override fun showUpdateUserInfo() {

        when (type) {
            getString(R.string.user_name) -> {
                userInfoBean?.username = edit_content.text.toString()
            }
            getString(R.string.user_phone) -> {
                userInfoBean?.mobile = edit_content.text.toString()
            }
            getString(R.string.user_email) -> {
                userInfoBean?.email = edit_content.text.toString()
            }
        }

        ToastUtil.show("修改成功！")
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun showUpdateHead(id: String) {}
}