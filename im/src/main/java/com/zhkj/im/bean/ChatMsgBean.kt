package com.zhkj.im.bean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/28 18:28
 */
class ChatMsgBean {
    private val id: String? = null
    private val username: String? = null
    private val uid: String? = null
    private val mine = false
    private val time: String? = null
    private val content: String? = null
    private val groupId: String? = null

    override fun toString(): String {
        return "ChatMsgBean(id=$id, username=$username, uid=$uid, mine=$mine, time=$time, content=$content, groupId=$groupId)"
    }
}