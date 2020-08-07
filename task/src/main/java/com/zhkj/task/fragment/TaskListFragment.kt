package com.zhkj.task.fragment

import com.sunny.zy.fragment.PullRefreshFragment
import com.zhkj.task.bean.TaskBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/7 15:31
 */
class TaskListFragment : PullRefreshFragment<TaskBean.Task>() {

    var deptId = ""

    var isResp = "1"

    override fun initView() {
        super.initView()

    }
}