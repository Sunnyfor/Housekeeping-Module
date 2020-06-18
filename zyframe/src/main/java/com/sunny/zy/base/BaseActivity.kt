package com.sunny.zy.base

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelStoreOwner
import com.sunny.zy.R
import com.sunny.zy.ZyFrameStore
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.savedInstanceState = savedInstanceState
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT //强制屏幕
        window.statusBarColor = ContextCompat.getColor(this, R.color.color_theme)
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
    fun getToolBar(): Toolbar = findViewById(R.id.toolbar)


    fun getTitleView() = findViewById<TextView>(R.id.tv_title)

    /**
     * 获取body容器
     */
    fun getFrameBody(): FrameLayout = findViewById(R.id.frameBody)

    fun setSupportActionBar() {
        setSupportActionBar(getToolBar())
    }

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
     * 批量注册点击事件
     * @param views 注册事件的View
     */
    fun setOnClickListener(vararg views: View) {
        views.forEach {
            it.setOnClickListener(this)
        }
    }

    /**
     * 点击事件处理
     */
    override fun onClick(view: View) {
        onClickEvent(view)
    }


    /**
     * 只有文字标题的toolbar
     */
    fun simpleTitle(title: String): Toolbar {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = ""
        toolbar.visibility = View.VISIBLE
        getTitleView().text = title
        setSupportActionBar()
        return toolbar
    }

    /**
     * 带返回键的toolbar
     */
    fun defaultTitle(
        title: String
    ): Toolbar {
        val toolbar = simpleTitle(title)
        toolbar.setNavigationIcon(R.drawable.svg_title_back)
        return toolbar
    }


    override fun onDestroy() {
        super.onDestroy()
        close()
        ZyFrameStore.removeActivity(this)
    }
}