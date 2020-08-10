package com.zhkj.mine

import android.view.View
import androidx.appcompat.app.AlertDialog
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseFragment
import com.sunny.zy.bean.VersionBean
import com.sunny.zy.contract.VersionUpdateContract
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.presenter.VersionUpdatePresenter
import com.sunny.zy.utils.GlideApp
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.utils.ToastUtil
import com.sunny.zy.widget.dialog.DownLoadDialog
import com.sunny.zy.widget.dialog.VersionUpdateDialog
import com.zhkj.mine.presenter.MinePresenter
import com.zhkj.user.bean.UserInfoBean
import com.zhkj.user.contract.UserContract
import com.zhkj.user.presenter.UserPresenter
import com.zhkj.user.util.UserManager
import kotlinx.android.synthetic.main.fram_mine.*
import kotlinx.coroutines.cancel
import java.io.File

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/12 15:07
 */
class MineFragment : BaseFragment(), MineContract.View, VersionUpdateContract.View,
    UserContract.UserInfoView {

    private val versionPresenter: VersionUpdateContract.Presenter by lazy {
        VersionUpdatePresenter(this)
    }

    private val userPresenter: UserPresenter by lazy {
        UserPresenter(this)
    }

    private val minePresenter: MinePresenter by lazy {
        MinePresenter(this)
    }


    private val downLoadDialog: DownLoadDialog by lazy {
        DownLoadDialog(requireContext())
    }

    private var isClickChecked = false

    override fun setLayout(): Int = R.layout.fram_mine

    override fun initView() {
        getBaseActivity().simpleTitle(getString(R.string.mine))
        rl_person_info.setOnClickListener(this)
        rl_approval_of_reimbursement.setOnClickListener(this)
        rl_logout.setOnClickListener(this)
        rl_version.setOnClickListener(this)

        tv_version.text = ("${getString(R.string.version)}${BuildConfig.VERSION_NAME}")
    }

    override fun loadData() {
        //检查是否有新版本
        minePresenter.checkUpdateMark()
    }

    override fun close() {
        minePresenter.cancel()
        versionPresenter.cancel()
        userPresenter.cancel()
    }

    override fun onResume() {
        super.onResume()
        ZyFrameStore.getData<UserInfoBean>(UserInfoBean::class.java.simpleName).let {
            if (it != null) {
                showUserInfo(it)
            } else {
                userPresenter.loadUserInfo(UserManager.getLoginBean().userId)
            }
        }
    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            rl_person_info.id -> {
                ARouter.getInstance().build(RouterPath.USER_INFO_ACTIVITY)
                    .withString("userId", UserManager.getLoginBean().userId).navigation()
            }
            rl_approval_of_reimbursement.id -> {
                ToastUtil.show()
            }

            rl_version.id -> {
                isClickChecked = true
                versionPresenter.checkVersion(BuildConfig.VERSION_CODE)
            }

            //退出登录
            rl_logout.id -> {
                showLogoutDialog()

            }
        }

    }

    override fun showCompanyInfo(companyInfo: MyCompanyInfo) {

    }

    override fun showUpdateMark() {
        iv_version_mark.visibility = View.VISIBLE
    }

    override fun logout() {
        //跳转登录页面
        ARouter.getInstance().build(RouterPath.LOGIN_LOGIN_ACTIVITY)
            .withBoolean("logout", true).navigation()

    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("提醒")
            .setMessage("确定要退出登录吗？")
            .setPositiveButton("确定") { _, _ ->
                minePresenter.logout()
            }
            .setNegativeButton("取消") { _, _ ->

            }
            .show()
    }


    override fun showVersionUpdate(versionBean: VersionBean) {
        VersionUpdateDialog(requireContext(), versionBean) {
            versionPresenter.downLoadAPk(
                UrlConstant.HOST + "/" + versionBean.downloadLocation
            )
            downLoadDialog.show()
            downLoadDialog.setProgress(0)
        }.show()
    }

    override fun noNewVersion() {
        iv_version_mark.visibility = View.GONE
        if (isClickChecked) {
            ToastUtil.show("当前版本已是最新！")
            isClickChecked = false
        }

    }

    override fun downLoadResult(path: String) {
        downLoadDialog.installApk(File(path))
        downLoadDialog.dismiss()
    }

    override fun progress(progress: Int) {
        downLoadDialog.setProgress(progress)
    }

    override fun showUserInfo(data: UserInfoBean) {
        tv_username.text = data.username
        tv_department.text = data.deptName
        tv_version.text = ("${getString(R.string.version)}${BuildConfig.VERSION_NAME}")
        GlideApp.with(this)
            .load(UrlConstant.HOST + UrlConstant.IMAGE_URL + data.imagesId)
            .placeholder(com.zhkj.user.R.drawable.icon_default_head)
            .into(iv_head)
        ZyFrameStore.setData(UserInfoBean::class.java.simpleName, data)
    }
}