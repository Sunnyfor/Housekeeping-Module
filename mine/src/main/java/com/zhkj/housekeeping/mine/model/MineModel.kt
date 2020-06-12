package com.zhkj.housekeeping.mine.model

import com.sunny.zy.model.DeptModel
import com.sunny.zy.utils.SpUtil
import com.zhkj.housekeeping.mine.MyCompanyInfo

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/12 17:06
 */
class MineModel {

    private val deptModel: DeptModel by lazy {
        DeptModel()
    }


    suspend fun getMyCompanyInfo(): MyCompanyInfo {

        val myCompanyInfo = MyCompanyInfo()

        deptModel.loadDept()?.let { bean ->
            if (bean.checkedId.isNotEmpty()) {
                bean.sysDept.find { it.deptId == bean.checkedId[0] }?.let { dept ->
                    myCompanyInfo.companyName =
                        bean.sysDept.find { it.deptId == dept.parentId }?.name ?: ""
                    myCompanyInfo.deptName = dept.name
                }
            }
        }
        return myCompanyInfo
    }


    fun logout() {
        SpUtil.remove(SpUtil.username)
        SpUtil.remove(SpUtil.password)
        SpUtil.remove(SpUtil.userInfoBean)
    }
}