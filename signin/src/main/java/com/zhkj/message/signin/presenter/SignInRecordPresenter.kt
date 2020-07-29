package com.zhkj.message.signin.presenter

import com.zhkj.message.signin.contract.SignInRecordContract
import com.zhkj.message.signin.model.SignInModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/8 18:14
 */
class SignInRecordPresenter(iView: SignInRecordContract.IView) :
    SignInRecordContract.Presenter(iView) {

    private val signInModel: SignInModel by lazy {
        SignInModel()
    }

    override fun loadSignInRecord() {
        launch(Main) {
            signInModel.loadSignInRecord()?.let {
                view?.showSignInRecord(it)
            }
        }
    }
}