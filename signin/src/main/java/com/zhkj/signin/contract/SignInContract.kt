package com.zhkj.signin.contract

import com.sunny.zy.base.BaseModel
import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.sunny.zy.bean.UploadBean
import com.zhkj.signin.bean.SignInBean
import java.io.File

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/7 18:59
 */
interface SignInContract {
    interface IView : IBaseView {
        //显示签到信息
        fun showSignInInfo(signInBean: SignInBean)

        //显示提交结果
        fun showCommitSignIn(baseModel: BaseModel<Any>)

        //显示上传视频结果
        fun showUploadVideo(bean: UploadBean)

        //显示下载视频结果
        fun showDownLoadVideo(file: File)

    }

    abstract class IPresenter(iView: IView) : BasePresenter<IView>(iView) {
        //加载签到信息
        abstract fun loadSignInInfo()

        //提交签到结果
        abstract fun commitSignIn(temperature: String, videoId: String)

        //上传视频
        abstract fun uploadVideo(path: String)

        //下载视频
        abstract fun downLoadVideo(url: String, fileName: String)
    }

}