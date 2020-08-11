package com.zhkj.task.presenter

import com.zhkj.task.contract.GoodsContract
import com.zhkj.task.model.GoodsModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/11 18:58
 */
class GoodsPresenter(view: GoodsContract.GoodsView) : GoodsContract.Presenter(view) {

    private val goodsModel: GoodsModel by lazy {
        GoodsModel()
    }

    override fun loadGoodsData(page: Int, taskId: String) {
        launch(Main) {
            showLoading()
            view?.showGoodsData(goodsModel.loadGoods(page, taskId) ?: arrayListOf())
            hideLoading()
        }
    }

}