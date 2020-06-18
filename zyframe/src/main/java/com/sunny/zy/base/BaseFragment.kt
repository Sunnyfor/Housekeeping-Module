package com.sunny.zy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelStoreOwner
import com.sunny.zy.widget.utils.OverlayViewUtils


/**
 *
 * Created by zhangye on 2018/8/2.
 */
abstract class BaseFragment : Fragment(), IBaseView, View.OnClickListener {
    private var savedInstanceState: Bundle? = null

    private val overlayViewBean = OverlayViewUtils()
    private var rootView: FrameLayout? = null
    var bodyView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.savedInstanceState = savedInstanceState
        if (rootView == null) {
            rootView = FrameLayout(requireContext())
            bodyView = inflater.inflate(setLayout(), container, false)
            rootView?.addView(bodyView)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        loadData()
    }


    fun getBaseActivity(): BaseActivity = requireActivity() as BaseActivity


    override fun onDestroyView() {
        super.onDestroyView()
        close()
    }

    abstract fun setLayout(): Int

    abstract fun initView()

    abstract fun loadData()


    override fun showMessage(message: String) {
        getBaseActivity().showMessage(message)
    }

    override fun showLoading() {
        overlayViewBean.showView(rootView ?: return, ErrorViewType.loading)
    }

    override fun hideLoading() {
        overlayViewBean.hideView(rootView ?: return, ErrorViewType.loading)
    }

    override fun showError(errorType: ErrorViewType) {
        overlayViewBean.showView(rootView ?: return, ErrorViewType.networkError)
    }

    override fun hideError(errorType: ErrorViewType) {
        overlayViewBean.hideView(rootView ?: return, ErrorViewType.networkError)
    }


    override fun getLifLifecycleOwner(): LifecycleOwner = this

    override fun getViewModelStoreOwner(): ViewModelStoreOwner = this

    abstract fun close()
}