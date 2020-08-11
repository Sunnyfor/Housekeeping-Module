package com.zhkj.common.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.common.bean.Dictionary

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/11 14:46
 */
class DictContract {
    interface DictView : IBaseView {
        fun showDictResult(data: ArrayList<Dictionary>)
    }

    abstract class Presenter(view: DictView) : BasePresenter<DictView>(view) {
        abstract fun loadDict(key: String, value: String)
    }
}