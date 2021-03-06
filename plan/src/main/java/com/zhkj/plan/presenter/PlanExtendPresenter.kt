package com.zhkj.plan.presenter


import com.zhkj.plan.bean.PlanBean
import com.zhkj.plan.contract.PlanExtendContract
import com.zhkj.plan.model.PlanExtendModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/9 18:28
 */
class PlanExtendPresenter(iView: PlanExtendContract.PlanExtendView) : PlanExtendContract.Presenter(iView) {
    private val planExtendModel: PlanExtendModel by lazy {
        PlanExtendModel()
    }

    /**
     * 创建计划
     */
    override fun createPlan(
        planTitle: String?,
        planStartDate: String,
        planEndDate: String,
        isNotTask: String?,
        contentList: java.util.ArrayList<String>
    ) {
        launch(Main) {
            if (planTitle.isNullOrEmpty()) {
                view?.showMessage("请输入计划名称")
                return@launch
            }

            if (isNotTask.isNullOrEmpty()) {
                view?.showMessage("请选择执行模块")
                return@launch
            }
            showLoading()
            planExtendModel.createPlan(
                planTitle,
                planStartDate,
                planEndDate,
                isNotTask,
                contentList
            )?.let {
                view?.showCreatePlanResult()
            }
            hideLoading()
        }
    }

    override fun updatePlan(
        bean:PlanBean
    ) {

        if (bean.planTitle.isEmpty()) {
            view?.showMessage("请输入计划标题！")
            return
        }

        launch(Main) {
            showLoading()
            planExtendModel.updatePlan(bean)?.let {
                view?.showCreatePlanResult()
            }
            hideLoading()
        }
    }

    override fun deletePlan(id: Int) {
        launch(Main) {
            showLoading()
            planExtendModel.deletePlan(id)?.let {
                view?.showDeletePlantResult(id)
            }
            hideLoading()
        }
    }

    override fun transferNextWeek(bean: PlanBean) {
        launch(Main) {
            showLoading()
            planExtendModel.transferNextWeek(bean)?.let {
                view?.showTransferNextWeekResult()
            }
            hideLoading()
        }
    }

    override fun completePlan(id: Int) {
        launch(Main) {
            showLoading()
            planExtendModel.completePlan(id.toString())?.let {
                view?.showCompletePlantResult(id)
            }
            hideLoading()
        }
    }


    /**
     * 计算日期间隔天数
     */
    fun calculateDay(startDate: String, endDate: String): Int {
        return planExtendModel.calculateDay(startDate, startDate)
    }
}