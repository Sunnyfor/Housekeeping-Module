package com.zhkj.user

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.utils.GlideApp
import com.sunny.zy.utils.RouterPath
import com.zhkj.user.bean.UserInfoBean
import com.zhkj.user.contract.UserContract
import com.zhkj.user.presenter.UserPresenter
import kotlinx.android.synthetic.main.act_user_info.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/30 16:19
 */
@Route(path = RouterPath.USER_INFO_ACTIVITY)
class UserInfoActivity : BaseActivity(), UserContract.UserInfoView {

    @Autowired
    @JvmField
    var userId: String? = ""

    val presenter: UserContract.UserPresenter by lazy {
        UserPresenter(this)
    }

    override fun setLayout(): Int = R.layout.act_user_info

    override fun initView() {
        ARouter.getInstance().inject(this)
        defaultTitle("个人资料").apply {
            elevation = 0f
        }

        setOnClickListener(
            cl_name,
            cl_phone,
            cl_email
        )
    }

    override fun loadData() {
        presenter.loadUserInfo(userId ?: return)
    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            cl_name.id -> {
                intentModify(getString(R.string.user_name))
            }
            cl_phone.id -> {
                intentModify(getString(R.string.user_phone))
            }
            cl_email.id -> {
                intentModify(getString(R.string.user_email))
            }
        }
    }

    override fun close() {
        ZyFrameStore.removeData(UserInfoBean::class.java.simpleName)
    }

    private fun intentModify(type: String) {
        ARouter.getInstance().build(RouterPath.USER_MODIFY_INFO_ACTIVITY)
            .withString("type", type).navigation()
    }

    override fun showUserInfo(data: UserInfoBean) {
        ZyFrameStore.setData(UserInfoBean::class.java.simpleName, data)
        GlideApp.with(this)
            .load(UrlConstant.HOST + UrlConstant.IMAGE_URL + data.imagesId)
            .placeholder(R.drawable.icon_default_head)
            .into(iv_head)

        tv_name.text = data.username ?: ""
        tv_dept.text = data.deptName ?: ""
        tv_phone.text = data.mobile ?: ""
        tv_email.text = data.email ?: ""
    }
}