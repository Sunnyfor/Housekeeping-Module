package com.zhkj.user.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.user.bean.DeptBean
import com.zhkj.user.bean.OtherUserBean
import com.zhkj.user.bean.UserInfoBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 12:03
 */
class UserContract {

    interface IOtherUserView : IBaseView {

        fun showOtherList(data: ArrayList<OtherUserBean>)

    }

    interface IDeptView : IBaseView {

        fun showDept(data: DeptBean)

    }

    interface UserInfoView : IBaseView {
        fun showUserInfo(data: UserInfoBean)
    }

    abstract class UserPresenter(view: IBaseView) : BasePresenter<IBaseView>(view) {

        abstract fun loadDeptList()

        abstract fun loadOtherUserList(page: Int, isAll: Boolean)

        abstract fun loadUserInfo(id: String)
    }
}
