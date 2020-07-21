package com.zhkj.housekeeping.joint


import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.housekeeping.joint.adapter.JointAdapter
import com.zhkj.housekeeping.joint.bean.JointBean
import com.zhkj.housekeeping.joint.contract.JointContract
import com.zhkj.housekeeping.joint.presenter.JointPresenter
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
        jointPresenter.loadJointRecycle(pullRefreshFragment.page)
    }

    override fun close() {
        jointPresenter.cancel()
    }

    override fun showRecycleList(data: ArrayList<JointBean>) {
        pullRefreshFragment.addData(data)
    }


}