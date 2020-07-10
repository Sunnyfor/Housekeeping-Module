package com.zhkj.housekeeping.plan.presenter


import com.sunny.zy.bean.Dictionary
import com.zhkj.housekeeping.plan.contract.PlanExtendContract
import com.zhkj.housekeeping.plan.model.PlanExtendModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/9 18:28
 */
class PlanExtendPresenter(iView: PlanExtendContract.IView) : PlanExtendContract.Presenter(iView) {

    private val planStatusList = ArrayList<Dictionary>()
    private val planExtendModel: PlanExtendModel by lazy {
        PlanExtendModel()
    }

    /**
     * 加载计划状态
     */
    override fun loadPlanStatus() {
        launch(Main) {
            if (planStatusList.isEmpty()) {
                showLoading()
                planExtendModel.loadPlanStatus()?.let {
                    planStatusList.clear()
                    planStatusList.addAll(it)
                    view?.showPlanStatus(planStatusList)
                }
                hideLoading()
            } else {
                view?.showPlanStatus(planStatusList)
            }
        }
    }

    /**
     * 加载计划执行模块
     */
    override fun loadPlanExecutionModule() {
        launch(Main) {
            if (planStatusList.isEmpty()) {
                showLoading()
                planExtendModel.loadPlanExecutionModule()?.let {
                    planStatusList.clear()
                    planStatusList.addAll(it)
                    view?.showPlanExecutionModule(planStatusList)
                }
                hideLoading()
            } else {
                view?.showPlanExecutionModule(planStatusList)
            }
        }
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
                view?.showPlanResult()
            }
            hideLoading()
        }
    }

    override fun updatePlan(
        planId: String,
        planTitle: String,
        activeStatus: String,
        contentId: String,
        content: String
    ) {

        if (planTitle.isEmpty()) {
            view?.showMessage("请输入计划标题！")
            return
        }

        launch(Main) {
            showLoading()
            planExtendModel.updatePlan(planId, planTitle, activeStatus, contentId, content)?.let {
                view?.showPlanResult()
            }
            hideLoading()
        }
    }

    override fun deletePlan(ids: Array<String>) {
        launch(Main) {
            showLoading()
            planExtendModel.deletePlan(ids)?.let {
                view?.showPlanResult()
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