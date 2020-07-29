package com.zhkj.message.signin.activity

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.message.signin.R
import com.zhkj.message.signin.adapter.SignInRecordAdapter
import com.zhkj.message.signin.bean.SignInBean
import com.zhkj.message.signin.contract.SignInRecordContract
import com.zhkj.message.signin.presenter.SignInRecordPresenter
import kotlinx.coroutines.cancel

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/8 17:50
 */
@Route(path = RouterPath.SIGN_IN_RECORD_ACTIVITY)
class SignInRecordActivity : BaseActivity(), SignInRecordContract.IView {

    private val presenter: SignInRecordPresenter by lazy {
        SignInRecordPresenter(this)
    }

    private val pullRefreshFragment = PullRefreshFragment<SignInBean>()

    override fun setLayout(): Int = 0

    override fun initView() {

        defaultTitle(getString(R.string.sign_in_record))

        pullRefreshFragment.enableLoadMore = false
        pullRefreshFragment.layoutManager = GridLayoutManager(this, 2)
        pullRefreshFragment.adapter = SignInRecordAdapter()
        pullRefreshFragment.loadData = {
            presenter.loadSignInRecord()
        }
        supportFragmentManager.beginTransaction().replace(getFrameBody().id, pullRefreshFragment)
            .commit()


    }

    override fun loadData() {
        showLoading()
        presenter.loadSignInRecord()
    }

    override fun onClickEvent(view: View) {

    }

    override fun close() {
        presenter.cancel()
    }

    override fun showSignInRecord(signInBeanList: ArrayList<SignInBean>) {
        hideLoading()
        pullRefreshFragment.addData(signInBeanList)
    }
}