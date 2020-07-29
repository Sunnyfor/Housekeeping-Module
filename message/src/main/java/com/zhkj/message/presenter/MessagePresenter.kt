package com.zhkj.message.presenter

import com.sunny.zy.base.IBaseView
import com.zhkj.message.contract.MessageContract
import com.zhkj.message.model.MessageModel
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

    override fun loadChatRecord(groupId: String, page: String) {
        launch(Main) {
            (messageModel.loadChatRecord(groupId, page) ?: arrayListOf()).let {
                if (view is MessageContract.IMsgRecordView) {
                    (view as MessageContract.IMsgRecordView).showMsgRecordData(it)
                }
            }
        }
    }
}