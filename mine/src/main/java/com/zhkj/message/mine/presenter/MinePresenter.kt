package com.zhkj.message.mine.presenter

import com.sunny.zy.ZyFrameStore
import com.sunny.zy.utils.DataKey
import com.sunny.zy.utils.SpUtil
import com.zhkj.message.mine.MineContract
import com.zhkj.message.mine.MyCompanyInfo
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


    override fun getCompanyInfo() {
        launch(Main) {
            view?.showLoading()

            userModel.loadDeptList()?.let { bean ->
                val myCompanyInfo = MyCompanyInfo()
                if (bean.checkedId.isNotEmpty()) {
                    bean.sysDept.find { it.deptId == bean.checkedId[0] }?.let { dept ->
                        myCompanyInfo.companyName =
                            bean.sysDept.find { it.deptId == dept.parentId }?.name ?: ""
                        myCompanyInfo.deptName = dept.name
                    }
                }
                view?.showCompanyInfo(myCompanyInfo)
            }
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
        SpUtil.remove(SpUtil.username)
        SpUtil.remove(SpUtil.password)
        SpUtil.remove(SpUtil.userInfoBean)
        view?.logout()
    }
}