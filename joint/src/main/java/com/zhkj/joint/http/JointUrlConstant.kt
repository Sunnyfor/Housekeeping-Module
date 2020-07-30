package com.zhkj.joint.http

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/17 16:22
 */
object JointUrlConstant {

    /**
     * 协同列表、创建协同
     */
    const val JOINT_URL = "app/synergys"


    /**
     * 协同发送回复
     */
    const val JOINT_REPLY_URL = "im/appgroupmessage/save"

    const val JOINT_REPLY_LIST_URL = "im/appgroupmessage/getCrmMessage"

    /**
     * 删除协同
     */

    const val JOINT_DELETE_URL = "app/synergys/%s"

    /**
     * 协同回收站
     */
    const val JOINT_RECYCLE_URL = "app/synergys/rubbish"

}