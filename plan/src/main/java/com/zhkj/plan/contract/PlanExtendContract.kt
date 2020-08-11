package com.zhkj.plan.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.plan.bean.PlanBean

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/9 18:21
 */
class PlanExtendContract {
    interface PlanExtendView : IBaseView {
        fun showCreatePlanResult()
        fun showTransferNextWeekResult()
        fun showDeletePlantResult(id: Int)
        fun showCompletePlantResult(id: Int)
    }

    abstract class Presenter(iView: PlanExtendView) : BasePresenter<PlanExtendView>(iView) {

        /**
         * 创建计划
         */
        abstract fun createPlan(
            planTitle: String?,
            planStartDate: String,
            planEndDate: String,
            isNotTask: String?,
            contentList: java.util.ArrayList<String>
        )


        /**
         * 修改计划
         */
        abstract fun updatePlan(
            bean:PlanBean
        )


        /**
         * 删除计划
         */
        abstract fun deletePlan(id:Int)



        /**
         * 周计划下移
         */
        abstract fun transferNextWeek(bean:PlanBean)

        /**
         * 完成计划
         */
        abstract fun completePlan(id: Int)
    }
}