package com.sunny.zy.presenter

import com.sunny.zy.contract.VersionUpdateContract
import com.sunny.zy.http.ProgressResponseBody
import com.sunny.zy.model.VersionUpdateModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import java.text.NumberFormat

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/15 12:11
 */
class VersionUpdatePresenter(view: VersionUpdateContract.View) :
    VersionUpdateContract.Presenter(view) {

    private val versionUpdateModel: VersionUpdateModel by lazy {
        VersionUpdateModel()
    }

    //检查版本
    override fun checkVersion(version: Int) {
        launch(Main) {
            val versionBean = versionUpdateModel.checkVersion(version)
            if (versionBean == null) {
                view?.noNewVersion()
            } else {
                view?.showVersionUpdate(versionBean)
            }
        }
    }

    //下载新版本APK
    override fun downLoadAPk(url: String, fileName: String?) {
        launch(Main) {
            versionUpdateModel.downLoadAPK(url, fileName, object :
                ProgressResponseBody.ProgressResponseListener {

                val numberFormat = NumberFormat.getInstance().apply {
                    maximumFractionDigits = 0
                }

                var progress = 0

                override fun onResponseProgress(
                    bytesRead: Long,
                    contentLength: Long,
                    done: Boolean
                ) {
                    numberFormat.format((bytesRead.toFloat() / contentLength.toFloat()) * 100)
                        .toInt().let {
                            if (it != progress) {
                                progress = it
                                launch(Main) {
                                    view?.progress(progress)
                                }
                            }
                        }
                }

                override fun onComplete(path: String) {
                    launch(Main) {
                        view?.downLoadResult(path)
                    }
                }

                override fun onFailure(message: String) {
                    launch(Main) {
                        view?.showMessage("下载错误:$message")
                    }

                }

            })
        }
    }


}