package com.sunny.zy.base

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelStoreOwner
import com.sunny.zy.R
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.title.TitleManager
import com.sunny.zy.utils.ToastUtil
import com.sunny.zy.widget.utils.OverlayViewUtils
import kotlinx.android.synthetic.main.zy_activity_base.*


/**
 *
 * Created by ZhangYe on 2018/8/2.
 */
@SuppressLint("SourceLockedOrientationActivity")
abstract class BaseActivity : AppCompatActivity(), IBaseView,
    View.OnClickListener {

    private var savedInstanceState: Bundle? = null

    private val overlayViewBean = OverlayViewUtils()

    lateinit var titleManager: TitleManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.savedInstanceState = savedInstanceState
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT //强制屏幕
        titleManager = TitleManager(this)
        setContentView(R.layout.zy_activity_base)
        val bodyView = LayoutInflater.from(this).inflate(setLayout(), null, false)
        frameBody.addView(bodyView)

        ZyFrameStore.addActivity(this)

        initView()
        loadData()
    }

    /**
     * 设置布局操作
     */
    abstract fun setLayout(): Int

    /**
     * 初始化View操作
     */
    abstract fun initView()

    /**
     * 加载数据操作
     */
    abstract fun loadData()

    /**
     * 点击事件回调
     */
    abstract fun onClickEvent(view: View)

    abstract fun close()

    /**
     * 获取title容器
     */
    fun getFrameTitle(): FrameLayout = findViewById(R.id.frameTitle)

    /**
     * 获取body容器
     */
    fun getFrameBody(): FrameLayout = findViewById(R.id.frameBody)

    /**
     * 显示loading覆盖层
     */
    override fun showLoading() {
        overlayViewBean.showView(frameBody, ErrorViewType.loading)
    }

    /**
     * 隐藏loading覆盖层
     */
    override fun hideLoading() {
        overlayViewBean.hideView(frameBody, ErrorViewType.loading)
    }

    /**
     * 显示error覆盖层
     */
    override fun showError(errorType: ErrorViewType) {
        overlayViewBean.showView(frameBody, errorType.errorCode)
    }

    /**
     * 隐藏error覆盖层
     */
    override fun hideError(errorType: ErrorViewType) {
        overlayViewBean.hideView(frameBody, ErrorViewType.networkError)
    }

    /**
     * 显示Toast
     */
    override fun showMessage(message: String) {
        ToastUtil.show(message)
    }


    override fun getViewModelStoreOwner(): ViewModelStoreOwner = this


    override fun getLifLifecycleOwner(): LifecycleOwner = this

    /**
     * 注册点击事件
     * @param views 注册事件的View
     */
    fun setOnClickListener(vararg views: View) {
        views.forEach {
            it.setOnClickListener(this)
        }
    }

    /**
     * 点击事件
     */
    override fun onClick(view: View) {
        onClickEvent(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        close()
        ZyFrameStore.removeActivity(this)
    }
}