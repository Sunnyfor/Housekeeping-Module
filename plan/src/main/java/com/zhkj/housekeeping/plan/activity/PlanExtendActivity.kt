package com.zhkj.housekeeping.plan.activity

import android.app.Activity
import android.content.DialogInterface
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.bean.Dictionary
import com.sunny.zy.utils.LogUtil
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

    var type = CRATE
    private var activeStatus = 0
    private var planStatusStrArray: Array<String>? = null

    private val presenter: PlanExtendPresenter by lazy {
        PlanExtendPresenter(this)
    }


    private val dayMillisecond = 1000L * 60 * 60 * 24

    val bean: PlanBean? by lazy {
        ZyFrameStore.getData<PlanBean>(PlanBean::class.java.simpleName)
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

        type = intent.getIntExtra("type", CRATE)

        if (type == CRATE) {
            defaultTitle("创建计划")

            btn_modify.visibility = View.GONE
            btn_delete.visibility = View.GONE
            btn_commit.visibility = View.VISIBLE
            cl_plan_status.visibility = View.GONE
            cl_plan_module.visibility = View.VISIBLE

            val startDate = intent.getStringExtra("date")

            tv_start_date.text = startDate

            addTextChangedListener()

            edit_plan_day.setText("1")

            setOnClickListener(
                tv_plan_module,
                tv_start_date,
                tv_end_date,
                btn_commit
            )

        } else {
            defaultTitle("计划详情")
        }


        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        setOnClickListener(tv_add)

    }

    override fun loadData() {
    }

    override fun onClickEvent(view: View) {
        when (view.id) {

            tv_plan_module.id, iv_module_more.id -> {
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
                    edit_plan_title.text.toString(),
                    tv_start_date.text.toString(),
                    tv_end_date.text.toString(),
                    tv_plan_module.tag?.toString(),
                    contentList
                )
            }

            tv_plan_status.id, iv_status_more.id -> {
                presenter.loadPlanStatus()
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


    //显示计划状态
    override fun showPlanStatus(dictionaryList: ArrayList<Dictionary>) {
        AlertDialog.Builder(this)
            .setTitle("选择计划状态")
            .setItems(Array(dictionaryList.size) { dictionaryList[it].value }) { _: DialogInterface, index: Int ->
                tv_plan_status.text = planStatusStrArray?.get(index) ?: ""
                activeStatus = dictionaryList[index].code
            }.show()
    }


    //显示执行模块
    override fun showPlanExecutionModule(dictionaryList: ArrayList<Dictionary>) {
        AlertDialog.Builder(this)
            .setTitle("选择执行模块")
            .setItems(Array(dictionaryList.size) { dictionaryList[it].value }) { _, index ->
                tv_plan_module.text = dictionaryList[index].value
                tv_plan_module.tag = dictionaryList[index].code
            }
            .show()
    }

    //计划创建成功
    override fun createPlanSuccess() {
        setResult(Activity.RESULT_OK)
        finish()
    }
}