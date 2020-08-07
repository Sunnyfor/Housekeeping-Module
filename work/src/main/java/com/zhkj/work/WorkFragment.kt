package com.zhkj.work

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.base.BaseFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.message.work.R
import com.zhkj.work.adapter.WorkFunctionAdapter
import com.zhkj.work.bean.FunctionBean
import kotlinx.android.synthetic.main.fram_work.*

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/12 18:42
 */
class WorkFragment : BaseFragment() {
    private val functionList = arrayListOf<FunctionBean>()


    override fun setLayout(): Int = R.layout.fram_work

    override fun initView() {
        getBaseActivity().simpleTitle(getString(R.string.workbench)).apply {
            elevation = 0F
        }

        functionList.add(FunctionBean().apply {
            title = "签到"
            icon = R.drawable.svg_work_sign
            onClickListener = View.OnClickListener {
                ARouter.getInstance().build(RouterPath.SIGN_IN_ACTIVITY).navigation()
            }
        })

        functionList.add(FunctionBean().apply {
            title = "计划"
            icon = R.drawable.svg_work_plan
            onClickListener = View.OnClickListener {
                ARouter.getInstance().build(RouterPath.PLAN_ACTIVITY).navigation()
            }

        })

        functionList.add(FunctionBean().apply {
            title = "项目"
            icon = R.drawable.svg_work_project
            onClickListener = View.OnClickListener {
                ARouter.getInstance().build(RouterPath.PROJECT_ACTIVITY).navigation()
            }
        })

        functionList.add(FunctionBean().apply {
            title = "任务"
            icon = R.drawable.svg_work_task
            onClickListener = View.OnClickListener {
                ARouter.getInstance().build(RouterPath.TASK_ACTIVITY).navigation()
            }
        })

        functionList.add(FunctionBean().apply {
            title = "协同"
            icon = R.drawable.svg_work_joint
            onClickListener = View.OnClickListener {
                ARouter.getInstance().build(RouterPath.JOINT_ACTIVITY).navigation()
            }
        })

        recycler.layoutManager = GridLayoutManager(context, 4)
        recycler.adapter = WorkFunctionAdapter(functionList)
    }

    override fun onClickEvent(view: View) {

    }

    override fun loadData() {

    }

    override fun close() {

    }

}