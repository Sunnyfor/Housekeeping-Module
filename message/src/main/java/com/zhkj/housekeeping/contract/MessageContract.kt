package com.zhkj.housekeeping.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.housekeeping.bean.FriendsBean

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

    abstract class Presenter(view: IBaseView) : BasePresenter<IBaseView>(view) {
        abstract fun loadFriendData()
    }
}