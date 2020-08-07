package com.zhkj.task.bean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/7 15:32
 */
    class TaskBean {
    var user: User? = null

    var taskList: ArrayList<Task>? = null

    class User {
        var userId: String? = null
        var username: String? = null

        override fun toString(): String {
            return "User(userId=$userId, username=$username)"
        }
    }

    class Task {
        var taskId: String? = null
        var imGroupId: String? = null
        var taskName: String? = null
        var taskContent: String? = null
        var taskLevel: String? = null
        var taskDeptId: String? = null
        var taskDeptName: String? = null
        var taskType: String? = null
        var taskPlanStartDate: String? = null
        var taskPlanEndDate: String? = null
        var taskStartDate: String? = null
        var taskEndDate: String? = null
        var createUserId: String? = null
        var createUserName: String? = null
        var chargeUserId: String? = null
        var chargeUserName: String? = null
        var activeState: String? = null
        var createDate: String? = null
        var conclusionState: String? = null
        var conclusionUserId: String? = null
        var conclusionUserName: String? = null
        var conclusionContent: String? = null
        var conclusionDate: String? = null
        var conclusionGroupId: String? = null
        var coverId: String? = null
        var conclusionOpinion: String? = null
        var bindingPlanId: String? = null
        var executeBindingPlanId: String? = null
        var isPlan: String? = null
        var imagesId: String? = null
        var taskStateStr: String? = null
        var fujianList: String? = null
        var attention: String? = null

        override fun toString(): String {
            return "Task(taskId=$taskId, imGroupId=$imGroupId, taskName=$taskName, taskContent=$taskContent, taskLevel=$taskLevel, taskDeptId=$taskDeptId, taskDeptName=$taskDeptName, taskType=$taskType, taskPlanStartDate=$taskPlanStartDate, taskPlanEndDate=$taskPlanEndDate, taskStartDate=$taskStartDate, taskEndDate=$taskEndDate, createUserId=$createUserId, createUserName=$createUserName, chargeUserId=$chargeUserId, chargeUserName=$chargeUserName, activeState=$activeState, createDate=$createDate, conclusionState=$conclusionState, conclusionUserId=$conclusionUserId, conclusionUserName=$conclusionUserName, conclusionContent=$conclusionContent, conclusionDate=$conclusionDate, conclusionGroupId=$conclusionGroupId, coverId=$coverId, conclusionOpinion=$conclusionOpinion, bindingPlanId=$bindingPlanId, executeBindingPlanId=$executeBindingPlanId, isPlan=$isPlan, imagesId=$imagesId, taskStateStr=$taskStateStr, fujianList=$fujianList, attention=$attention)"
        }

    }

    override fun toString(): String {
        return "TaskBean(user=$user, taskList=$taskList)"
    }

}