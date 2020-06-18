package com.zhkj.housekeeping.mine

import android.view.View
import androidx.appcompat.app.AlertDialog
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseFragment
import com.sunny.zy.bean.VersionBean
import com.sunny.zy.contract.VersionUpdateContract
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.presenter.VersionUpdatePresenter
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.utils.ToastUtil
import com.sunny.zy.widget.dialog.DownLoadDialog
import com.sunny.zy.widget.dialog.VersionUpdateDialog
import com.zhkj.housekeeping.mine.presenter.MinePresenter
import kotlinx.android.synthetic.main.fram_mine.*
import kotlinx.coroutines.cancel
import java.io.File

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/12 15:07
 */
class MineFragment : BaseFragment(), MineContract.View, VersionUpdateContract.View {

    private val versionPresenter: VersionUpdateContract.Presenter by lazy {
        VersionUpdatePresenter(this)
    }


    private val minePresenter: MinePresenter by lazy {
        MinePresenter(this)
    }


    private val downLoadDialog: DownLoadDialog by lazy {
        DownLoadDialog(requireContext())
    }

    override fun setLayout(): Int = R.layout.fram_mine

    override fun initView() {
        rl_person_info.setOnClickListener(this)
        rl_approval_of_reimbursement.setOnClickListener(this)
        rl_logout.setOnClickListener(this)
        rl_version.setOnClickListener(this)
        getBaseActivity().simpleTitle(getString(R.string.mine))
    }

    override fun loadData() {
        minePresenter.getCompanyInfo()
        minePresenter.checkUpdateMark()
    }

    override fun close() {

    }

    override fun onClick(v: View) {
        when (v.id) {
            rl_person_info.id -> {

                ToastUtil.show()

            }
            rl_approval_of_reimbursement.id -> {
                ToastUtil.show()
            }

            rl_version.id -> {
                versionPresenter.checkVersion(BuildConfig.VERSION_CODE)
            }

            //退出登录
            rl_logout.id -> {

                showLogoutDialog()

            }
        }

    }

    override fun showCompanyInfo(companyInfo: MyCompanyInfo) {
        tv_username.text = ZyFrameStore.getUserInfoBean().name
        tv_department.text = companyInfo.deptName
        tv_company.text = companyInfo.companyName
        tv_version.text = ("${getString(R.string.version)}${ZyFrameStore.versionName}")


    }

    override fun showUpdateMark() {
        iv_version_mark.visibility = View.VISIBLE
    }

    override fun logout() {
        ZyFrameStore.finishAllActivity()
        //跳转登录页面
        ARouter.getInstance().build(RouterPath.LOGIN_LOGIN_ACTIVITY).navigation()

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

    override fun onDestroy() {
        super.onDestroy()
        minePresenter.cancel()
    }

    override fun showVersionUpdate(versionBean: VersionBean) {
        hideLoading()
        VersionUpdateDialog(requireContext(), versionBean.appAndroidVersion?.updateDetails ?: "") {
            val fileName = "${versionBean.appAndroidVersion?.versionNumber}.apk"
            val file = File(UrlConstant.TEMP, fileName)
            if (file.exists()) {
                downLoadDialog.installApk(file)
            } else {
                versionPresenter.downLoadAPk(
                    UrlConstant.host + "/" + versionBean.appAndroidVersion?.downloadLocation,
                    fileName
                )
                downLoadDialog.show()
                downLoadDialog.setProgress(0)
            }

        }.show()
    }

    override fun noNewVersion() {
        hideLoading()
        iv_version_mark.visibility = View.GONE
        ToastUtil.show("当前版本已是最新！")
    }

    override fun downLoadResult(path: String) {
        downLoadDialog.installApk(File(path))
        downLoadDialog.dismiss()
    }

    override fun progress(progress: Int) {
        downLoadDialog.setProgress(progress)
    }
}