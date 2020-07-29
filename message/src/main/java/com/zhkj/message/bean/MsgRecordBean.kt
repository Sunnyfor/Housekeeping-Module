package com.zhkj.message.bean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/28 18:28
 */
class MsgRecordBean {
    val id: String? = null
    val username: String? = null
    val uid: String? = null
    val mine = false
    val time: String? = null
    val content: String? = null
    val groupId: String? = null

    override fun toString(): String {
        return "ChatMsgBean(id=$id, username=$username, uid=$uid, mine=$mine, time=$time, content=$content, groupId=$groupId)"
    }
}