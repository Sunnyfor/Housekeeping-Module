package com.zhkj.housekeeping.plan.bean

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/8 19:38
 */
data class PlanBean(
    val activeStatus: Int,
    var activeStatusStr: String,
    val activeStatusName: String,
    val attention: Any,
    val backgroundColor: String,
    val bindingProjectId: Any,
    val bindingTaskId: Any,
    var content: String?,
    val contentId: Int,
    val createDate: String,
    val createName: String,
    val createUserId: Int,
    val isBindingProject: Any,
    val isBindingTask: Any,
    val isNotTask: Int,
    val isTrial: Any,
    val linkDeptId: Int,
    val linkDeptName: String,
    val linkDictCode: Any,
    val linkDictType: Any,
    val parentId: Int,
    val parentName: Any,
    val planEndDate: String,
    val planGrade: Int,
    val planGradeName: Any,
    val planId: Int,
    val planLevel: Any,
    val planLevelName: Any,
    val planList: Any,
    val planNumber: Any,
    val planPath: String,
    val planRemind: Int,
    val planStartDate: String,
    val planTitle: String,
    val planType: Int,
    val planTypeName: Any,
    val planWhen: String,
    val postponeCreate: Any,
    val remark: Any,
    val salesVolume: Any,
    val select: Any,
    val tiXingDm: Any
)
