package com.zhkj.common.bean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/5 18:12
 */
class DeptBean {
    var deptId: String? = null
    var parentId: String? = null
    var name: String? = null
    var parentName: String? = null
    var orderNum: String? = null
    var delFlag: String? = null
    var open: String? = null
    var list: Any? = null

    override fun toString(): String {
        return "DeptBean(deptId=$deptId, parentId=$parentId, name=$name, parentName=$parentName, orderNum=$orderNum, delFlag=$delFlag, open=$open, list=$list)"
    }
}