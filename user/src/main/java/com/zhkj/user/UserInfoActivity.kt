package com.zhkj.user

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.utils.CameraUtil
import com.sunny.zy.utils.GlideApp
import com.sunny.zy.utils.RouterPath
import com.zhkj.user.bean.UserInfoBean
import com.zhkj.user.contract.UserContract
import com.zhkj.user.presenter.UserPresenter
import kotlinx.android.synthetic.main.act_user_info.*
import java.io.File

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/30 16:19
 */
@Route(path = RouterPath.USER_INFO_ACTIVITY)
class UserInfoActivity : BaseActivity(), UserContract.UserInfoView, UserContract.UpdateView {

    @Autowired
    @JvmField
    var userId: String? = ""

    var headId = ""

    private val presenter: UserContract.UserPresenter by lazy {
        UserPresenter(this)
    }

    private val cameraUtil: CameraUtil by lazy {
        CameraUtil(this).apply {
            onResultListener = object : CameraUtil.OnResultListener {
                override fun onResult(file: File) {
                    presenter.updateUserHead(file.path)
                }

            }
        }
    }

    override fun setLayout(): Int = R.layout.act_user_info

    override fun initView() {
        ARouter.getInstance().inject(this)
        defaultTitle("个人资料").apply {
            elevation = 0f
        }

        setOnClickListener(
            cl_head,
            cl_name,
            cl_phone,
            cl_email
        )
    }

    override fun loadData() {
        ZyFrameStore.getData<UserInfoBean>(UserInfoBean::class.java.simpleName).let {
            if (it != null) {
                showUserInfo(it)
            } else {
                presenter.loadUserInfo(userId ?: return)
            }
        }
    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            cl_head.id -> {
                showSelectDialog()
            }

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

    override fun close() {}

    private fun intentModify(type: String) {
        ARouter.getInstance().build(RouterPath.USER_MODIFY_INFO_ACTIVITY)
            .withString("type", type).navigation(this, 10000)
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

    private fun showSelectDialog() {
        AlertDialog.Builder(this)
            .setItems(arrayOf("拍照", "从相册选择图片", "取消")) { _: DialogInterface, index: Int ->
                when (index) {
                    0 -> cameraUtil.intentCamera()
                    1 -> cameraUtil.intentPhotoAndCrop()
                }
            }
            .show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10000 && resultCode == Activity.RESULT_OK) {
            ZyFrameStore.getData<UserInfoBean>(UserInfoBean::class.java.simpleName)?.let {
                showUserInfo(it)
            }
        } else {
            cameraUtil.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun showUpdateUserInfo() {
        ZyFrameStore.getData<UserInfoBean>(UserInfoBean::class.java.simpleName)?.let {
            it.imagesId = headId
            showUserInfo(it)
        }

    }

    override fun showUpdateHead(id: String) {
        ZyFrameStore.getData<UserInfoBean>(UserInfoBean::class.java.simpleName)?.let {
            headId = id
            val jsonObj = it.getJsonObject()
            jsonObj.put("imagesId", headId)
            presenter.updateUserInfo(jsonObj.toString())

        }
    }
}