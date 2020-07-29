package com.zhkj.message.joint.bean

data class JointBean(
    var checkContent: String? = null,
    var content: String? = null,
    var createDate: String? = null,
    var createUserId: Int,
    var endDate: String? = null,
    var getUserId: Int,
    var isDelete: Int,
    var replyList: ArrayList<Reply>,
    var startDate: String? = null,
    var state: Int,
    var stateName: String? = null,
    var synergyId: Int,
    var synergyIds: String? = null,
    var synergyNames: String? = null,
    var synergyType: Int,
    var updateDate: String? = null,
    var updateUserId: Int,
    var userName: String? = null,
    var createUserName: String? = null,
    var synergyTitle: String? = null,
    var executeBindingPlanId: String? = null,
    var coverId: String? = null
) {
    data class Reply(
        var id: String? = null,
        var userId: String? = null,
        var userName: String? = null,
        var groupId: String? = null,
        var leiXing: String? = null,
        var content: String? = null,
        var isDel: String? = null,
        var isRead: String? = null,
        var sendTime: String? = null,
        var isBack: String? = null
    )
}

