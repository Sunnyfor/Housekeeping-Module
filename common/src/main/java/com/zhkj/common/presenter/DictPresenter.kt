package com.zhkj.common.presenter

import com.zhkj.common.contract.DictContract
import com.zhkj.common.model.DictModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/11 14:50
 */
class DictPresenter(view: DictContract.DictView) : DictContract.Presenter(view) {

    private val dictModel: DictModel by lazy {
        DictModel()
    }

    override fun loadDict(key: String, value: String) {
        launch(Main) {
            showLoading()
            dictModel.loadDict(key, value)?.let {
                view?.showDictResult(it)
            }
            hideLoading()
        }
    }
}