package com.zhkj.task.contract

import com.sunny.zy.base.BaseModel
import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.task.bean.GoodsBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/11 18:54
 */
class GoodsContract {
    interface GoodsView : IBaseView {
        fun showGoodsData(data: ArrayList<GoodsBean>)

        fun updateGoodsResult(data: BaseModel<Any>)
    }

    abstract class Presenter(view: GoodsView) : BasePresenter<GoodsView>(view) {
        abstract fun loadGoodsData(page: Int, taskId: String)

        abstract fun updateGoods(taskId: String, json: String)
    }
}