package com.zhkj.message.signin.http

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/7 18:23
 */
object SignInUrlConstant {
    /**
     * 【签到】是否签到接口
     */
    const val SIGN_IN_CHECK_URL = "app/appusersignrecord/getSignIn"

    /**
     * 【签到】提交接口
     */
    const val SIGN_IN_COMMIT_URL = "app/appusersignrecord/save"


    /**
     * 【签到】历史记录接口
     */
    const val SIGN_IN_RECORD_URL = "app/appusersignrecord/infoList"

}