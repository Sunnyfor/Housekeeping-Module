package com.zhkj.housekeeping.signin.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.view.View
import androidx.core.content.FileProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.base.BaseModel
import com.sunny.zy.bean.UploadBean
import com.sunny.zy.http.Constant
import com.sunny.zy.http.UrlConstant
import com.sunny.zy.utils.FileUtils
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.utils.ToastUtil
import com.zhkj.housekeeping.signin.R
import com.zhkj.housekeeping.signin.bean.SignInBean
import com.zhkj.housekeeping.signin.contract.SignInContract
import com.zhkj.housekeeping.signin.presenter.SignInPresenter
import kotlinx.android.synthetic.main.act_sign_in.*
import kotlinx.coroutines.cancel
import java.io.File

/**
 * Desc 签到页面
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/2/2 19:35
 */
@Route(path = RouterPath.SIGN_IN_ACTIVITY)
class SignInActivity : BaseActivity(), SignInContract.IView {

    /**
     * 视频附件id
     */
    private var videoId: String = ""

    /**
     * 服务器返回的视频签到地址
     */
    private var videoUrl: String = ""

    /**
     * 本地录制视频的地址
     */
    private var videoPath: String = ""

    private var file: File? = null

    private var isVideoClockIn = false

    private val presenter: SignInContract.IPresenter by lazy {
        SignInPresenter(this)
    }


    override fun setLayout(): Int =
        R.layout.act_sign_in


    override fun initView() {

        rightTitle(
            getString(R.string.sign_in),
            R.drawable.svg_sign_in_history,
            View.OnClickListener {
                ARouter.getInstance().build(RouterPath.SIGN_IN_RECORD_ACTIVITY).navigation()
            })

        btn_sign_in.setOnClickListener(this)
        tv_clock_in.setOnClickListener(this)
    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            R.id.btn_sign_in -> {
                hideKeyboard()
                val temperature = et_temperature.text.toString().trim()
                if (temperature.isEmpty()) {
                    et_temperature.setShakeAnimation()
                    ToastUtil.show("请填写今日体温")
                    return
                }
                if (videoUrl.isEmpty()) { // 第一次签到，需要上传视频
                    if (videoPath.isEmpty()) {
                        ToastUtil.show("请进行视频打卡")
                        return
                    }
                    presenter.uploadVideo(videoPath)
                } else { //第二次签到
                    presenter.commitSignIn(et_temperature.text.toString().trim(), videoId)
                }
            }
            R.id.tv_clock_in -> {
                if (isVideoClockIn) {
                    presenter.downLoadVideo(videoUrl, "SignInVideo.mp4")
                } else {
                    intentVideo()
                }
            }
        }
    }

    override fun loadData() {
        presenter.loadSignInInfo()
    }

    override fun close() {
        presenter.cancel()
    }


    override fun showSignInInfo(signInBean: SignInBean) {
        if (signInBean.isSignIn) {
            showSignInView()
            et_temperature.setText(signInBean.userTemperature)
        }
        videoUrl = signInBean.videoUrl ?: ""
        videoId = videoUrl //如果videoUrl有值，不需要判断是否需要上传视频
        isVideoClockIn = signInBean.isVideoClockIn
        tv_clock_in.text = if (isVideoClockIn) "查看签到视频" else "视频签到"
    }

    override fun showCommitSignIn(baseModel: BaseModel<Any>) {
        ToastUtil.show("签到成功")
        tv_clock_in.text = "查看签到视频"
        showSignInView()
        loadData()
    }

    override fun showUploadVideo(bean: UploadBean) {
        bean.id?.let {
            videoId = it
            presenter.commitSignIn(et_temperature.text.toString().trim(), it)
        }
    }

    override fun showDownLoadVideo(file: File) {
        val intent = Intent(Intent.ACTION_VIEW)
        val type = "video/*"
        val uri = FileUtils.getUriFromPath(file.path)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.setDataAndType(uri, type)
        startActivity(intent)
    }


    /**
     * 展示已签到布局
     */
    private fun showSignInView() {
        btn_sign_in.text = "已签到"
        btn_sign_in.setBackgroundResource(R.drawable.sel_btn_big_unable)
        btn_sign_in.isEnabled = false
        et_temperature.isEnabled = false
    }


    private fun intentVideo() {
        // 将路径转换为Uri对象
        file = File(UrlConstant.TEMP, "${System.currentTimeMillis()}.mp4")

        file?.let {
            val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                FileProvider.getUriForFile(this, Constant.authorities, it)
            } else {
                Uri.fromFile(it)
            }
            // 表示跳转至相机的录视频界面
            val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            // MediaStore.EXTRA_VIDEO_QUALITY 表示录制视频的质量，从 0-1，越大表示质量越好，同时视频也越大
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0)
            // 表示录制完后保存的录制，如果不写，则会保存到默认的路径，在onActivityResult()的回调，通过intent.getData中返回保存的路径
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
            // 设置视频录制的最长时间
            intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 5)
            startActivityForResult(intent, 10000)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10000 && resultCode == Activity.RESULT_OK) {
            videoPath = file?.path ?: ""
        }
    }
}