package com.zhkj.task.bean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 19:20
 */
data class TaskDetailBean(
    var task: TaskBean.Task?,
    var relateUserIds: ArrayList<Int>?,
    var progressList: ArrayList<ProgressBean>,
    var relateList: ArrayList<RelateBean>,
    var dataList: ArrayList<DataBean>,
    var applicationList: ArrayList<Any>,
    var userEntity: UserBean
) {


    data class ProgressBean(
        var id: String?,
        var taskId: String?,
        var progressContent: String?,
        var progressStatus: String?,
        var progressAppointUserId: String?,
        var progressAppointUserName: String?,
        var createUserId: String?,
        var createUserName: String?,
        var receipt: String?,
        var taskProportion: String?,
        var taskSchedule: String?,
        var createDate: String?,
        var activeState: String?
    )

    data class RelateBean(
        var id: String?,
        var taskId: String?,
        var userId: String?,
        var userName: String?,
        var activeState: String?
    )

    data class DataBean(
        var activeState: String?,
        var createDate: String?,
        var createUserId: String?,
        var createUserName: String?,
        var dataGroupId: String?,
        var dataRemark: String?,
        var id: String?,
        var taskId: String?,
        var fujianList: List<TaskBean.FujianBean>? = null
    )

    data class UserBean(
        var userId: String?,
        var username: String?,
        var salt: String?,
        var email: String?,
        var mobile: String?,
        var status: String?,
        var roleIdList: String?,
        var createTime: String?,
        var deptId: String?,
        var imagesId: String?,
        var deptName: String?,
        var sign: String?
    )
}