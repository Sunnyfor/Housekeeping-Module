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

    override fun loadUserInfo(id: String) {
        launch(Main) {
            showLoading()
            userModel.loadUserInfo(id)?.let {
                if (view is UserContract.UserInfoView) {
                    (view as UserContract.UserInfoView).showUserInfo(it)
                }
            }
            hideLoading()
        }
    }

    override fun updateUserInfo(json: String) {
        launch(Main) {
            showLoading()
            userModel.updateUserInfo(json)?.let {
                if (view is UserContract.UpdateView) {
                    (view as UserContract.UpdateView).showUpdateUserInfo()
                }
            }
            hideLoading()
        }
    }

    override fun updateUserHead(path: String) {
        launch(Main) {
            showLoading()
            userModel.updateUserHead(path)?.let {
                if (view is UserContract.UpdateView) {
                    (view as UserContract.UpdateView).showUpdateHead(it.id.toString())
                }
            }
            hideLoading()
        }
    }
}