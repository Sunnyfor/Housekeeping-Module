package com.example.housekeeping.work.joint.bean

data class JointBean(
        var checkContent: String,
        var content: String,
        var createDate: String,
        var createUserId: Int,
        var endDate: Any,
        var getUserId: Int,
        var isDelete: Int,
        var replyList: ArrayList<Reply>,
        var startDate: String,
        var state: Int,
        var stateName: String,
        var synergyId: Int,
        var synergyIds: String,
        var synergyNames: String,
        var synergyType: Int,
        var updateDate: String,
        var updateUserId: Int,
        var userName: String
)

data class Reply(
        var createDate: String,
        var replayContent: String,
        var replayId: Int,
        var replayUserId: Any,
        var sendUserId: Int,
        var sendUserName: String,
        var synergyId: Int
)