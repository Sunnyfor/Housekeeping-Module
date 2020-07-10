package com.zhkj.housekeeping.mine.presenter

import com.sunny.zy.ZyFrameStore
import com.sunny.zy.utils.DataKey
import com.zhkj.housekeeping.mine.MineContract
import com.zhkj.housekeeping.mine.model.MineModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/12 17:53
 */
class MinePresenter(view: MineContract.View) : MineContract.Presenter(view) {

    private val mineModel: MineModel by lazy {
        MineModel()
    }

    override fun getCompanyInfo() {
        launch(Main) {
            view?.showLoading()
            view?.showCompanyInfo(mineModel.getMyCompanyInfo())
            view?.hideLoading()
        }

    }

    override fun checkUpdateMark() {
        view?.showLoading()
        if (ZyFrameStore.getData<Boolean>(DataKey.IS_NEW_APP_VERSION) == true) {
            view?.showUpdateMark()
        }
        view?.hideLoading()
    }

    override fun logout() {
        mineModel.logout()
        view?.logout()
    }
}