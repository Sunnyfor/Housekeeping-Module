package com.zhkj.message.bean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/24 11:55
 */
class FriendsBean(
    var mine: Mine?,
    var friend: ArrayList<Any>?,
    var group: ArrayList<Groups>?
) {
    data class Mine(
        var id: String?,
        var username: String?,
        var avatar: String?,
        var sign: String?
    )

    data class Groups(

        var id: String?,
        var groupname: String?,
        var list: ArrayList<Group>?,
        var isExpand: Boolean
    ) {
        data class Group(
            var id: String?,
            var groupname: String?,
            var avatar: String?,
            var workGroupTypeId: String?,
            var workGroupTypeSign: String?
        )
    }
}