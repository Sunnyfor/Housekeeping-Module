package com.zhkj.housekeeping.plan.activity

import android.app.Activity
import android.content.DialogInterface
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.bean.Dictionary
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.utils.TimerPackUtil
import com.sunny.zy.utils.ToastUtil
import com.zhkj.housekeeping.plan.R
import com.zhkj.housekeeping.plan.adapter.PlanContentAdapter
import com.zhkj.housekeeping.plan.bean.PlanBean
import com.zhkj.housekeeping.plan.contract.PlanExtendContract
import com.zhkj.housekeeping.plan.presenter.PlanExtendPresenter
import com.zhkj.housekeeping.plan.util.DateUtil
import kotlinx.android.synthetic.main.act_plan_desc.*
import java.text.ParseException

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/9 16:44
 */
@Route(path = RouterPath.PLAN_EXTEND_ACTIVITY)
class PlanExtendActivity : BaseActivity(), PlanExtendContract.IView {


    companion object {
        const val PREVIEW = 0
        const val CRATE = 1
    }

    @JvmField
    @Autowired
    var type = CRATE


    val bean: PlanBean? by lazy {
        ZyFrameStore.getData<PlanBean>(PlanBean::class.java.simpleName, true)
    }

    private var activeStatus = 0

    private val presenter: PlanExtendPresenter by lazy {
        PlanExtendPresenter(this)
    }

    private val contentList = arrayListOf<String>()


    private val adapter: PlanContentAdapter by lazy {
        PlanContentAdapter(contentList) { _: View, position: Int ->
            contentList.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }

    override fun setLayout(): Int = R.layout.act_plan_desc

    override fun initView() {

        ARouter.getInstance().inject(this)

        if (type == CRATE) {
            defaultTitle("创建计划")

            btn_modify.visibility = View.GONE
            btn_delete.visibility = View.GONE
            btn_commit.visibility = View.VISIBLE
            cl_status.visibility = View.GONE
            cl_module.visibility = View.VISIBLE

            val startDate = intent.getStringExtra("date")

            tv_start_date.text = startDate

            addTextChangedListener()

            edit_plan_day.setText("1")

            setOnClickListener(
                tv_start_date, tv_end_date, btn_commit
            )

        } else {
            defaultTitle("计划详情")

            edit_plan_day.keyListener = null
            btn_modify.visibility = View.VISIBLE
            btn_delete.visibility = View.VISIBLE
            btn_commit.visibility = View.GONE
            cl_status.visibility = View.VISIBLE
            cl_plan_day.visibility = View.GONE
            cl_cycle.visibility = View.GONE

            bean?.let {
                activeStatus = it.activeStatus
                edit_title.setText(it.planTitle)
                tv_status.text = it.activeStatusName
                tv_start_date.text = it.planStartDate.replace(" 00:00:00", "")
                tv_end_date.text = it.planEndDate.replace(" 00:00:00", "")
                presenter.calculateDay(tv_start_date.text.toString(), tv_end_date.text.toString())

                it.content?.let { content ->
                    if (content.isNotEmpty()) {
                        if (content.contains("·")) {
                            contentList.addAll(content.split("·"))
                        } else {
                            contentList.add(content)
                        }
                        adapter.notifyDataSetChanged()
                    }
                }
            }

            setOnClickListener(
                btn_modify, btn_delete
            )

        }


        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        setOnClickListener(tv_add, tv_plan_module)

    }

    override fun loadData() {
        if (type == PREVIEW)
            presenter.loadPlanExecutionModule()//加载执行模块
    }

    override fun onClickEvent(view: View) {
        when (view.id) {

            tv_plan_module.id -> {
                presenter.loadPlanExecutionModule()//加载执行模块
            }

            tv_start_date.id -> {
                TimerPackUtil.showDatePack(this, object : TimerPackUtil.OnTimePackResult {
                    override fun onSelect(timeStr: String) {
                        if (DateUtil.dateEquals(tv_end_date.text.toString(), timeStr)) {
                            //设置开始日期
                            tv_start_date.text = timeStr
                            //设置天数
                            edit_plan_day.setText(
                                presenter.calculateDay(
                                    tv_start_date.text.toString(), tv_end_date.text.toString()
                                )
                            )
                        } else {
                            ToastUtil.show("起始时间不能大于结束时间，请谨慎选择！")
                        }

                    }
                })
            }

            tv_end_date.id -> {
                TimerPackUtil.showDatePack(this, object : TimerPackUtil.OnTimePackResult {
                    override fun onSelect(timeStr: String) {
                        if (DateUtil.dateEquals(timeStr, tv_start_date.text.toString())) {
                            tv_end_date.text = timeStr
                            //设置天数
                            edit_plan_day.setText(
                                presenter.calculateDay(
                                    tv_start_date.text.toString(), tv_end_date.text.toString()
                                )
                            )
                        } else {
                            ToastUtil.show("结束时间不能小于起始时间，请谨慎选择！")
                        }
                    }
                })
            }

            btn_commit.id -> {
                //创建计划
                presenter.createPlan(
                    edit_title.text.toString(),
                    tv_start_date.text.toString(),
                    tv_end_date.text.toString(),
                    tv_plan_module.tag?.toString(),
                    contentList
                )
            }

            tv_status.id -> {
                presenter.loadPlanStatus()
            }

            btn_modify.id -> {
                updatePlan()
            }

            btn_delete.id -> {
                showDeleteDialog()
            }

        }
    }

    override fun close() {
    }


    /**
     * 日期输入框逻辑
     */
    private fun addTextChangedListener() {
        edit_plan_day.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (s.isNotEmpty()) {
                    try {
                        tv_end_date.text = DateUtil.countEndDate(
                            tv_start_date.text.toString(),
                            s.toString().toInt()
                        )

                    } catch (e: ParseException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.isNotEmpty() && s.toString().toInt() <= 0) {
                    edit_plan_day.setText("1")
                    edit_plan_day.setSelection(1)
                }
            }
        })
    }


    //修改计划
    private fun updatePlan() {
        val content = StringBuilder()
        contentList.forEachIndexed { index, str ->
            content.append(str)
            if (index != contentList.size - 1) {
                content.append("·")
            }
        }
        bean?.let {
            presenter.updatePlan(
                it.planId.toString(),
                edit_title.text.toString(),
                activeStatus.toString(),
                it.contentId.toString(),
                content.toString()
            )
        }
    }

    //显示删除Dialog确认框
    private fun showDeleteDialog() {
        AlertDialog.Builder(this)
            .setTitle("删除提醒")
            .setMessage("是否确定要删除计划？")
            .setNegativeButton("确定") { _: DialogInterface, _: Int ->
                bean?.let {
                    presenter.deletePlan(arrayOf(it.planId.toString()))
                }
            }
            .setPositiveButton("取消") { _: DialogInterface, _: Int -> }
            .show()
    }


    //显示计划状态
    override fun showPlanStatus(dictionaryList: ArrayList<Dictionary>) {
        AlertDialog.Builder(this)
            .setTitle("选择计划状态")
            .setItems(Array(dictionaryList.size) { dictionaryList[it].value }) { _: DialogInterface, index: Int ->
                tv_status.text = dictionaryList[index].value
                activeStatus = dictionaryList[index].code
            }.show()
    }


    //显示执行模块
    override fun showPlanExecutionModule(dictionaryList: ArrayList<Dictionary>) {

        if (type == PREVIEW && tv_plan_module.text.toString() == getString(R.string.select_or_search)) {
            tv_plan_module.text = dictionaryList.find { it.code == bean?.isNotTask }?.value
            return
        }

        AlertDialog.Builder(this)
            .setTitle("选择执行模块")
            .setItems(Array(dictionaryList.size) { dictionaryList[it].value }) { _, index ->
                tv_plan_module.text = dictionaryList[index].value
                tv_plan_module.tag = dictionaryList[index].code
                bean?.isNotTask = tv_plan_module.tag as Int
            }
            .show()
    }

    //计划创建成功
    override fun showPlanResult() {
        setResult(Activity.RESULT_OK)
        finish()
    }
}