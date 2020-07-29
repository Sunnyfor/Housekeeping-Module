package com.zhkj.message.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.message.bean.FriendsBean
import com.zhkj.message.bean.MsgRecordBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/24 15:43
 */
class MessageContract {
    interface IFriendsView : IBaseView {
        fun showFriendData(friendsBean: FriendsBean)
    }

    interface IMsgRecordView : IBaseView {
        fun showMsgRecordData(data: ArrayList<MsgRecordBean>)
    }

    abstract class Presenter(view: IBaseView) : BasePresenter<IBaseView>(view) {
        abstract fun loadFriendData()
        abstract fun loadChatRecord(groupId: String, page: String)
    }
}