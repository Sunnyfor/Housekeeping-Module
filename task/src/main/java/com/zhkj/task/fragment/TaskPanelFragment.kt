package com.zhkj.task.fragment

import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.donkingliang.labels.LabelsView
import com.sunny.zy.base.BaseFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.common.bean.Dictionary
import com.zhkj.common.contract.DictContract
import com.zhkj.common.presenter.DictPresenter
import com.zhkj.task.R
import com.zhkj.task.bean.TaskDetailBean
import kotlinx.android.synthetic.main.frag_task_detail.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 17:50
 */
class TaskPanelFragment : BaseFragment(), DictContract.DictView {

    var bean: TaskDetailBean? = null

    private val dictPresenter: DictContract.Presenter by lazy {
        DictPresenter(this)
    }

    override fun setLayout(): Int = R.layout.frag_task_detail

    override fun initView() {
        bean?.let { bean ->
            tv_task_name.text = bean.task?.taskName ?: "未填写"

            bean.task?.taskContent.let {
                if (it.isNullOrEmpty()) {
                    bean.task?.taskContent = "未填写"
                }
            }
            tv_task_content.text = bean.task?.taskContent
            val startDate = bean.task?.taskPlanStartDate?.split(" ")?.get(0) ?: "..."
            val endDate = bean.task?.taskPlanEndDate?.split(" ")?.get(0) ?: "..."
            tv_task_time.text = ("$startDate 至 $endDate")
            tv_task_principal.text = ("负责人：${(bean.task?.chargeUserName ?: "暂无")}")
            bean.relateList.filter { it.userId != bean.task?.chargeUserId }.let {
                labels_view.setLabels(it,
                    LabelsView.LabelTextProvider { _, _, data ->
                        return@LabelTextProvider data.userName
                    })
            }
        }

        setOnClickListener(rl_task_inventory)
    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            rl_task_inventory.id -> {
                ARouter.getInstance().build(RouterPath.GOODS_ACTIVITY)
                    .withString("taskId",bean?.task?.taskId)
                    .navigation()
            }
        }
    }

    override fun loadData() {
        dictPresenter.loadDict("type", "taskType")
    }

    override fun close() {

    }

    override fun showDictResult(data: ArrayList<Dictionary>) {
        data.find { bean?.task?.taskType == it.code.toString() }.let {
            tv_task_type.text = it?.value ?: "未填写"
        }

    }
}