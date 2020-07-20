package com.zhkj.user.presenter

import com.sunny.zy.base.IBaseView
import com.zhkj.user.contract.UserContract
import com.zhkj.user.model.UserModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 12:01
 */
class UserPresenter(view: IBaseView) : UserContract.UserPresenter(view) {

    private val userModel: UserModel by lazy {
        UserModel()
    }


    /**
     * 加载部门数据
     */
    override fun loadDeptList() {
        launch(Main) {
            showLoading()
            userModel.loadDeptList()?.let {
                if (view is UserContract.IDeptView) {
                    (view as UserContract.IDeptView).showDept(it)
                }
            }
            hideLoading()
        }
    }


    /**
     * 加载参与人用户列表
     */
    override fun loadOtherUserList(page: Int, isAll: Boolean) {
        launch(Main) {
            showLoading()
            userModel.loadUserList(page.toString(), isAll)?.let {
                if (view is UserContract.IOtherUserView) {
                    (view as UserContract.IOtherUserView).showOtherList(it)
                }
            }
            hideLoading()
        }
    }
}