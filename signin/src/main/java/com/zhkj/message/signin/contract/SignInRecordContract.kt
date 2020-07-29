package com.zhkj.message.signin.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.message.signin.bean.SignInBean

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/8 18:10
 */
interface SignInRecordContract {
    interface IView : IBaseView {
        fun showSignInRecord(signInBeanList: ArrayList<SignInBean>)
    }

    abstract class Presenter(view:IView):BasePresenter<IView>(view){
        abstract fun loadSignInRecord()
    }
}