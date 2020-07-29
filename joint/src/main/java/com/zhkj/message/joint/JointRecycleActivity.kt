package com.zhkj.message.joint


import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.message.joint.adapter.JointAdapter
import com.zhkj.message.joint.bean.JointBean
import com.zhkj.message.joint.contract.JointContract
import com.zhkj.message.joint.presenter.JointPresenter
import kotlinx.coroutines.cancel

@Route(path = RouterPath.JOINT_RECYCLE_ACTIVITY)
class JointRecycleActivity : BaseActivity(), JointContract.IJointRecycleBinView {

    private val jointPresenter: JointPresenter by lazy {
        JointPresenter(this)
    }

    private val pullRefreshFragment = PullRefreshFragment<JointBean>()

    private val jointAdapter: JointAdapter by lazy {
        JointAdapter()
    }


    override fun setLayout(): Int = 0


    override fun initView() {

        defaultTitle("协同回收站")

        showLoading()
        pullRefreshFragment.enableLoadMore = false
        pullRefreshFragment.adapter = jointAdapter
        pullRefreshFragment.loadData = {
            loadData()
        }

        supportFragmentManager.beginTransaction().replace(getFrameBody().id, pullRefreshFragment)
            .commit()
    }

    override fun onClickEvent(view: View) {

    }

    override fun loadData() {
        jointPresenter.loadJointRecycle()
    }

    override fun close() {
        jointPresenter.cancel()
    }

    override fun showRecycleList(data: ArrayList<JointBean>) {
        pullRefreshFragment.addData(data)
    }


}