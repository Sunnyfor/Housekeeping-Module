package com.zhkj.housekeeping.plan.contract

import com.haibin.calendarview.Calendar
import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.housekeeping.plan.bean.PlanBean

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/9 11:00
 */
class PlanContract {
    interface IView : IBaseView {
        fun showPlanMark(scheme: HashMap<String, Calendar>)

        fun showPlanList(planList:ArrayList<PlanBean>)
    }

    abstract class Presenter(iView: IView) : BasePresenter<IView>(iView) {
        abstract fun loadPlanMark(year: Int, month: Int)

        abstract fun loadPlanList(beginDate: String, endDate: String?)
    }
}