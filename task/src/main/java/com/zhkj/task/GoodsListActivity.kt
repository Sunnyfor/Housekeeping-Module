package com.zhkj.task

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
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
@Route(path = RouterPath.TASK_GOODS_ACTIVITY)
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

        ARouter.getInstance().inject(this)

        defaultTitle(getString(R.string.item_list))
        pullRefreshFragment.enableLoadMore = false
        pullRefreshFragment.loadData = {
            loadData()
        }
        pullRefreshFragment.adapter = GoodsAdapter()

        supportFragmentManager.beginTransaction().replace(getFrameBody().id, pullRefreshFragment)
            .commit()
        showLoading()
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
        hideLoading()
        pullRefreshFragment.addData(data)
    }
}