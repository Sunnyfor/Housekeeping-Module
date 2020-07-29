package com.zhkj.plan.presenter

import com.zhkj.plan.contract.PlanContract
import com.zhkj.plan.model.PlanModel
import com.zhkj.plan.util.DateUtil
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/9 11:03
 */
class PlanPresenter(iView: PlanContract.IView) : PlanContract.Presenter(iView) {

    private val planModel: PlanModel by lazy {
        PlanModel()
    }

    override fun loadPlanMark(year: Int, month: Int) {
        launch(Main) {
            showLoading()
            planModel.loadPlantMark(year, month)?.let {
                view?.showPlanMark(it)
            }
            hideLoading()
        }

    }

    override fun loadPlanList(beginDate: String, endDate: String?) {
        launch(Main) {
            showLoading()
            var mEndDate = endDate
            if (mEndDate == null) {
                mEndDate = DateUtil.countEndDate(beginDate)
            }
            planModel.loadPlantList(1, beginDate, mEndDate)?.let {
                view?.showPlanList(it)
            }

            hideLoading()
        }
    }
}