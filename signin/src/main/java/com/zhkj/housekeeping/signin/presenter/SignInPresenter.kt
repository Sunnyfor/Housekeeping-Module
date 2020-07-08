package com.zhkj.housekeeping.signin.presenter

import com.zhkj.housekeeping.signin.contract.SignInContract
import com.zhkj.housekeeping.signin.model.SignInModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/7 19:08
 */
class SignInPresenter(iView: SignInContract.IView) : SignInContract.IPresenter(iView) {

    private val signInModel: SignInModel by lazy {
        SignInModel()
    }

    override fun loadSignInInfo() {
        launch(Main) {
            view?.showLoading()
            signInModel.loadSignIn()?.let {
                view?.showSignInInfo(it)
            }
            view?.hideLoading()
        }

    }

    override fun commitSignIn(temperature: String, videoId: String) {
        launch(Main) {
            view?.showLoading()
            signInModel.commitSignIn(temperature, videoId)?.let {
                view?.showCommitSignIn(it)
            }
            view?.hideLoading()
        }
    }

    override fun uploadVideo(path: String) {
        launch(Main) {
            view?.showLoading()
            signInModel.uploadVideo(path)?.let {
                view?.showUploadVideo(it)
            }
            view?.hideLoading()
        }
    }

    override fun downLoadVideo(url: String, fileName: String) {
        launch(Main) {
            view?.showLoading()
            signInModel.downLoadVideo(url, fileName)?.let {
                view?.showDownLoadVideo(it)
            }
            view?.hideLoading()
        }
    }
}