package com.zhkj.task

import android.app.Activity
import android.content.Intent
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.base.BaseModel
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.task.adapter.GoodsAdapter
import com.zhkj.task.bean.GoodsBean
import com.zhkj.task.contract.GoodsContract
import com.zhkj.task.presenter.GoodsPresenter
import kotlinx.coroutines.cancel

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/11 18:50
 */
@Route(path = RouterPath.GOODS_ACTIVITY)
class GoodsListActivity : BaseActivity(), GoodsContract.GoodsView {

    @Autowired
    @JvmField
    var taskId: String? = null

    lateinit var toolbar: Toolbar

    private val goodsPresenter: GoodsContract.Presenter by lazy {
        GoodsPresenter(this)
    }

    private val pullRefreshFragment = PullRefreshFragment<GoodsBean>()

    override fun setLayout(): Int = 0

    override fun initView() {

        ARouter.getInstance().inject(this)

        toolbar = defaultTitle(getString(R.string.item_list))

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_add -> ARouter.getInstance().build(RouterPath.ADD_GOODS_ACTIVITY)
                    .withString("taskId", taskId)
                    .navigation(this, 10000)
            }

            return@setOnMenuItemClickListener true
        }

        pullRefreshFragment.enableLoadMore = false
        pullRefreshFragment.loadData = {
            loadData()
        }
        pullRefreshFragment.adapter = GoodsAdapter().apply {
            setOnItemClickListener { _, position ->
                ARouter.getInstance().build(RouterPath.ADD_GOODS_ACTIVITY)
                    .withString("taskId", taskId)
                    .withInt("position", position)
                    .navigation(this@GoodsListActivity, 10000)
            }
        }

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
        goodsPresenter.cancel()
    }

    override fun showGoodsData(data: ArrayList<GoodsBean>) {
        hideLoading()
        pullRefreshFragment.addData(data)
    }

    override fun updateGoodsResult(data: BaseModel<Any>) {}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        toolbar.inflateMenu(R.menu.menu_goods_title)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10000 && resultCode == Activity.RESULT_OK) {
            loadData()
        }
    }
}