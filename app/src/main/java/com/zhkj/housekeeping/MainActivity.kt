package com.zhkj.housekeeping

import android.view.View
import androidx.navigation.fragment.findNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.bean.VersionBean
import com.sunny.zy.contract.VersionUpdateContract
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.presenter.VersionUpdatePresenter
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.utils.ToastUtil
import com.sunny.zy.widget.dialog.DownLoadDialog
import com.sunny.zy.widget.dialog.VersionUpdateDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.cancel
import java.io.File

@Route(path = RouterPath.APP_MAIN_ACTIVITY)
class MainActivity : BaseActivity(), VersionUpdateContract.View {

    private val downLoadDialog: DownLoadDialog by lazy {
        DownLoadDialog(this)
    }

    private val presenter: VersionUpdateContract.Presenter by lazy {
        VersionUpdatePresenter(this)
    }

    override fun setLayout(): Int = R.layout.activity_main

    override fun initView() {

    }

    override fun loadData() {
        //初始化版本名称
        ZyFrameStore.versionName = BuildConfig.VERSION_NAME
        //检查版本更新
        presenter.checkVersion(BuildConfig.VERSION_CODE)

        bottom_navigation.setOnNavigationItemSelectedListener {
            if (it.isChecked) {
                return@setOnNavigationItemSelectedListener false
            }
            nav_host_fragment.findNavController().navigate(it.itemId)
            return@setOnNavigationItemSelectedListener true
        }
    }


    override fun onClickEvent(view: View) {

    }

    override fun showVersionUpdate(versionBean: VersionBean) {
        VersionUpdateDialog(this, versionBean.appAndroidVersion?.updateDetails ?: "") {

            val fileName = "${versionBean.appAndroidVersion?.versionNumber}.apk"

            val file = File(UrlConstant.TEMP, fileName)
            if (file.exists()) {
                downLoadDialog.installApk(file)
            } else {
                presenter.downLoadAPk(
                    UrlConstant.host + "/" + versionBean.appAndroidVersion?.downloadLocation,
                    fileName
                )
                downLoadDialog.show()
                downLoadDialog.setProgress(0)
            }
        }.show()
    }

    override fun noNewVersion() {
        ToastUtil.show("当前版本已是最新！")
    }

    override fun downLoadResult(path: String) {
        downLoadDialog.installApk(File(path))
        downLoadDialog.dismiss()
    }

    override fun progress(progress: Int) {
        downLoadDialog.setProgress(progress)
    }

    override fun close() {
        presenter.cancel()
    }
}