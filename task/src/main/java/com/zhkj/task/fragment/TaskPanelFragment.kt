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
import com.zhkj.user.SelectUserActivity
import com.zhkj.user.util.UserManager
import kotlinx.android.synthetic.main.frag_task_detail.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/10 17:50
 */
class TaskPanelFragment : BaseFragment(), DictContract.DictView {

    var bean: TaskDetailBean? = null

    var flag = false

    private val dictPresenter: DictContract.Presenter by lazy {
        DictPresenter(this)
    }

    private val selectUserIds = arrayListOf<String>()

    override fun setLayout(): Int = R.layout.frag_task_detail

    override fun initView() {
        setOnClickListener(rl_task_progress, rl_task_inventory)
    }

    override fun onClickEvent(view: View) {

        if (bean == null) {
            return
        }

        when (view.id) {
            iv_principal_more.id -> {

                flag = true

                SelectUserActivity.startActivity(
                    getBaseActivity(),
                    arrayListOf(),
                    null,
                    true
                )
            }

            rl_task_member.id -> {

                flag = false

                SelectUserActivity.startActivity(
                    getBaseActivity(),
                    selectUserIds,
                    bean?.task?.chargeUserId
                )
            }

            rl_task_progress.id -> {
                ARouter.getInstance().build(RouterPath.TASK_PROGRESS_ACTIVITY)
                    .withString("taskId", bean?.task?.taskId)
                    .withString("chargeUserId", bean?.task?.chargeUserId)
                    .navigation()
            }

            rl_task_inventory.id -> {
                ARouter.getInstance().build(RouterPath.GOODS_ACTIVITY)
                    .withString("taskId", bean?.task?.taskId)
                    .navigation()
            }
        }
    }

    override fun loadData() {
        bean?.let {
            dictPresenter.loadDict("type", "taskType")
        }
    }

    override fun close() {

    }

    override fun showDictResult(data: ArrayList<Dictionary>) {
        data.find { bean?.task?.taskType == it.code.toString() }.let {
            tv_task_type.text = it?.value ?: "未填写"
        }

    }

    fun updateData(data: TaskDetailBean?) {
        selectUserIds.clear()

        this.bean = data
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

            if (UserManager.getLoginBean().userId == bean.task?.chargeUserId) {
                iv_principal_more.visibility = View.VISIBLE
                iv_member_more.visibility = View.VISIBLE
                setOnClickListener(rl_task_principal, rl_task_member)
            }


            val labelList = arrayListOf<TaskDetailBean.RelateBean>()

            bean.relateList.forEach {
                if (it.userId != bean.task?.chargeUserId) {
                    labelList.add(it)
                }
                selectUserIds.add(it.userId.toString())
            }

            labels_view.setLabels(labelList,
                LabelsView.LabelTextProvider { _, _, data ->
                    return@LabelTextProvider data.userName
                })

        }

    }
}