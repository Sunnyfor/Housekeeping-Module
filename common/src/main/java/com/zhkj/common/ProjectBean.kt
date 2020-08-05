package com.zhkj.common

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/5 17:39
 */
class ProjectBean {

    var renYuanId: String? = null
    var renYuanName: String? = null
    var xiangMuId: String? = null
    var xiangMuName: String? = null
    var buMenMc: String? = null
    var dicXiangmuEntity: Entity? = null
    var dataType: String? = null
    var userId: String? = null
    var xiangMuFzr: String? = null
    var xiangMuFzrName: String? = null

    class Entity {
        var xiangMuId: String? = null
        var xiangMuMingcheng: String? = null
        var xiangMuBianhao: String? = null
        var state: String? = null
        var chuangJianR: String? = null
        var chuangJianRq: String? = null
        var xiuGaiR: String? = null
        var xiuGaiRq: String? = null
        var chuangJianRName: String? = null
        var xiangMuFzr: String? = null
        var youXianJi: String? = null
        var shiFouSc: String? = null
        var bindingPlanId: String? = null
        var executeBindingPlanId: String? = null
        var coverId: String? = null
        var xiangMuFzrName: String? = null
        var xiangMuFzrMc: String? = null

        override fun toString(): String {
            return "Entity(xiangMuId=$xiangMuId, xiangMuMingcheng=$xiangMuMingcheng, xiangMuBianhao=$xiangMuBianhao, state=$state, chuangJianR=$chuangJianR, chuangJianRq=$chuangJianRq, xiuGaiR=$xiuGaiR, xiuGaiRq=$xiuGaiRq, chuangJianRName=$chuangJianRName, xiangMuFzr=$xiangMuFzr, youXianJi=$youXianJi, shiFouSc=$shiFouSc, bindingPlanId=$bindingPlanId, executeBindingPlanId=$executeBindingPlanId, coverId=$coverId, xiangMuFzrName=$xiangMuFzrName, xiangMuFzrMc=$xiangMuFzrMc)"
        }

    }

    override fun toString(): String {
        return "ProjectBean(renYuanId=$renYuanId, renYuanName=$renYuanName, xiangMuId=$xiangMuId, xiangMuName=$xiangMuName, buMenMc=$buMenMc, dicXiangmuEntity=$dicXiangmuEntity, dataType=$dataType, userId=$userId, xiangMuFzr=$xiangMuFzr, xiangMuFzrName=$xiangMuFzrName)"
    }
    
}