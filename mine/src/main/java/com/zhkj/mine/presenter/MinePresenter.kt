package com.zhkj.mine.presenter

import com.sunny.zy.ZyFrameStore
import com.sunny.zy.utils.DataKey
import com.sunny.zy.utils.SpUtil
import com.zhkj.mine.MineContract
import com.zhkj.mine.MyCompanyInfo
import com.zhkj.user.model.UserModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/12 17:53
 */
class MinePresenter(view: MineContract.View) : MineContract.Presenter(view) {

    private val userModel: UserModel by lazy {
        UserModel()
    }

    override fun checkUpdateMark() {
        view?.showLoading()
        if (ZyFrameStore.getData<Boolean>(DataKey.IS_NEW_APP_VERSION) == true) {
            view?.showUpdateMark()
        }
        view?.hideLoading()
    }

    override fun logout() {
        SpUtil.remove(SpUtil.username)
        SpUtil.remove(SpUtil.password)
        SpUtil.remove(SpUtil.userInfoBean)
        view?.logout()
    }
}