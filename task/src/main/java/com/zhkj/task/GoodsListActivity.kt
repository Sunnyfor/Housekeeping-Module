package com.zhkj.task

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.fragment.PullRefreshFragment
import com.zhkj.task.adapter.GoodsAdapter
import com.zhkj.task.bean.GoodsBean
import com.zhkj.task.contract.GoodsContract
import com.zhkj.task.presenter.GoodsPresenter

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/11 18:50
 */
class GoodsListActivity : BaseActivity(), GoodsContract.GoodsView {

    @Autowired
    @JvmField
    var taskId: String? = null

    private val goodsPresenter: GoodsContract.Presenter by lazy {
        GoodsPresenter(this)
    }

    private val pullRefreshFragment = PullRefreshFragment<GoodsBean>()

    override fun setLayout(): Int = 0

    override fun initView() {

        pullRefreshFragment.loadData = {
            loadData()
        }
        pullRefreshFragment.adapter = GoodsAdapter()

        supportFragmentManager.beginTransaction().replace(getFrameBody().id, pullRefreshFragment)
            .commit()
    }

    override fun loadData() {
        taskId?.let {
            goodsPresenter.loadGoodsData(pullRefreshFragment.page, it)
        }

    }

    override fun onClickEvent(view: View) {

    }

    override fun close() {

    }

    override fun showGoodsData(data: ArrayList<GoodsBean>) {
        pullRefreshFragment.addData(data)
    }
}