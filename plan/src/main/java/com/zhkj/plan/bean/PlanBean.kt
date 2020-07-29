package com.zhkj.plan.bean

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/8 19:38
 */
data class PlanBean(
    var activeStatus: Int,
    var activeStatusName: String,
    var attention: Any,
    var backgroundColor: String,
    var bindingProjectId: Any,
    var bindingTaskId: Any,
    var content: String?,
    var contentId: Int,
    var createDate: String,
    var createName: String,
    var createUserId: Int,
    var isBindingProject: Any,
    var isBindingTask: Any,
    var isNotTask: Int,
    var isTrial: Any,
    var linkDeptId: Int,
    var linkDeptName: String,
    var linkDictCode: Any,
    var linkDictType: Any,
    var parentId: Int,
    var parentName: Any,
    var planEndDate: String,
    var planGrade: Int,
    var planGradeName: Any,
    var planId: Int,
    var planLevel: Any,
    var planLevelName: Any,
    var planList: Any,
    var planNumber: Any,
    var planPath: String,
    var planRemind: Int,
    var planStartDate: String,
    var planTitle: String,
    var planType: Int,
    var planTypeName: Any,
    var planWhen: String,
    var postponeCreate: Any,
    var remark: Any,
    var salesVolume: Any,
    var select: Any,
    var tiXingDm: Any
)
