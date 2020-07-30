package com.zhkj.user

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import com.zhkj.user.bean.UserInfoBean
import kotlinx.android.synthetic.main.act_modify_user_info.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/30 17:42
 */
@Route(path = RouterPath.USER_MODIFY_INFO_ACTIVITY)
class ModifyUserInfoActivity : BaseActivity() {

    @Autowired
    @JvmField
    var type: String? = ""

    private val userInfoBean: UserInfoBean? by lazy {
        ZyFrameStore.getData<UserInfoBean>(UserInfoBean::class.java.simpleName, true)
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

        setOnClickListener(btn_save)

    }

    override fun loadData() {

    }

    override fun onClickEvent(view: View) {
        if (view.id == btn_save.id) {
            when (type) {
                getString(R.string.user_name) -> {

                }
                getString(R.string.user_phone) -> {

                }
                getString(R.string.user_email) -> {

                }
            }
        }
    }

    override fun close() {

    }
}