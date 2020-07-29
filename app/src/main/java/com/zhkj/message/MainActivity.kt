package com.zhkj.message

import android.content.Intent
import android.view.View
import androidx.navigation.fragment.findNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.bean.VersionBean
import com.sunny.zy.contract.VersionUpdateContract
import com.sunny.zy.presenter.VersionUpdatePresenter
import com.sunny.zy.utils.DataKey
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.widget.dialog.DownLoadDialog
import com.sunny.zy.widget.dialog.VersionUpdateDialog
import com.zhkj.im.service.KeepLiveService
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
        //启动IM服务
        val intent = Intent(this@MainActivity, KeepLiveService::class.java)
        startService(intent)
    }

    override fun loadData() {
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
        //APP有新版本
        ZyFrameStore.setData(DataKey.IS_NEW_APP_VERSION, true)
        VersionUpdateDialog(this, versionBean) {
            presenter.downLoadAPk(versionBean.downloadLocation ?: "")
            downLoadDialog.show()
            downLoadDialog.setProgress(0)
        }.show()
    }

    override fun noNewVersion() {}

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