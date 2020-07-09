package com.zhkj.housekeeping.plan.contract

import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.sunny.zy.bean.Dictionary

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/9 18:21
 */
class PlanExtendContract {
    interface IView : IBaseView {
        fun showPlanStatus(dictionaryList: ArrayList<Dictionary>)

        fun showPlanExecutionModule(dictionaryList: ArrayList<Dictionary>)

        fun createPlanSuccess()
    }

    abstract class Presenter(iView: IView) : BasePresenter<IView>(iView) {
        /**
         * 加载计划状态
         */
        abstract fun loadPlanStatus()

        /**
         * 加载执行模块
         */
        abstract fun loadPlanExecutionModule()


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

    }
}