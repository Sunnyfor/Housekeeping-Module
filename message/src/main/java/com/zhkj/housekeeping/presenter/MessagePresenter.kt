package com.zhkj.housekeeping.presenter

import com.sunny.zy.base.IBaseView
import com.zhkj.housekeeping.contract.MessageContract
import com.zhkj.housekeeping.model.MessageModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/24 15:45
 */
class MessagePresenter(iView: IBaseView) : MessageContract.Presenter(iView) {

    private val messageModel: MessageModel by lazy {
        MessageModel()
    }

    override fun loadFriendData() {
        launch(Main) {
            messageModel.loadFriendList()?.let {
                if (view is MessageContract.IFriendsView) {
                    (view as MessageContract.IFriendsView).showFriendData(it)
                }
            }
            hideLoading()
        }
    }
}