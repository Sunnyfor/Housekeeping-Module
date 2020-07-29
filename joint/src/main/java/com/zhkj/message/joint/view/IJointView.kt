package com.zhkj.message.joint.view

import com.zhkj.message.joint.bean.JointBean
import com.sunny.zy.base.IBaseView

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/4 11:49
 */
interface IJointView : IBaseView {

    //协同数据列表回调
    fun getJointList(jointList: ArrayList<JointBean>)
}