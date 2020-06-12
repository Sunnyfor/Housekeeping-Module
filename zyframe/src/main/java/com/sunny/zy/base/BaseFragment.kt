package com.sunny.zy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelStoreOwner
import com.sunny.zy.R
import com.sunny.zy.widget.utils.OverlayViewUtils
import kotlinx.android.synthetic.main.zy_fragment_base.*
import kotlinx.android.synthetic.main.zy_fragment_base.view.*


/**
 *
 * Created by zhangye on 2018/8/2.
 */
abstract class BaseFragment : Fragment(), IBaseView, View.OnClickListener {
    private var savedInstanceState: Bundle? = null

    private val overlayViewBean = OverlayViewUtils()

    var bodyView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.savedInstanceState = savedInstanceState
        val mView = inflater.inflate(R.layout.zy_fragment_base, container, false)
        bodyView = inflater.inflate(setLayout(), container, false)
        mView?.iframeBody?.addView(bodyView)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        loadData()
    }


    /**
     * 沉浸式Title
     */
    fun immersionTitle() {
        iframeBody?.apply {
            (layoutParams as RelativeLayout.LayoutParams).addRule(RelativeLayout.BELOW, 0)
        }
        iframeTitle?.setBackgroundResource(R.color.transparent)

    }


    fun getBaseActivity(): BaseActivity = requireActivity() as BaseActivity


    fun <T : View> findViewById(id: Int): T? {
        return view?.findViewById<T>(id)
    }


    override fun onDestroy() {
        super.onDestroy()
        close()
    }


    abstract fun setLayout(): Int

    abstract fun initView()


    abstract fun loadData()


    override fun showMessage(message: String) {
        getBaseActivity().showMessage(message)
    }

    override fun showLoading() {
        overlayViewBean.showView(iframeBody, ErrorViewType.loading)
    }

    override fun hideLoading() {
        overlayViewBean.hideView(iframeBody, ErrorViewType.loading)
    }

    override fun showError(errorType: ErrorViewType) {
        overlayViewBean.showView(iframeBody, ErrorViewType.networkError)
    }

    override fun hideError(errorType: ErrorViewType) {
        overlayViewBean.hideView(iframeBody, ErrorViewType.networkError)
    }


    override fun getLifLifecycleOwner(): LifecycleOwner = this

    override fun getViewModelStoreOwner(): ViewModelStoreOwner = this

    abstract fun close()
}