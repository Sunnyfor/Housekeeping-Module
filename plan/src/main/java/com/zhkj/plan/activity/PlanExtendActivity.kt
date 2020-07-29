package com.zhkj.plan.activity

import android.app.Activity
import android.content.DialogInterface
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
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
import com.zhkj.plan.R
import com.zhkj.plan.adapter.PlanContentAdapter
import com.zhkj.plan.bean.PlanBean
import com.zhkj.plan.contract.PlanExtendContract
import com.zhkj.plan.presenter.PlanExtendPresenter
import com.zhkj.plan.util.DateUtil
import kotlinx.android.synthetic.main.act_plan_desc.*
import kotlinx.coroutines.cancel
import java.text.ParseException

/**
 * Desc 计划内容、创建计划，相关页面
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
        PlanContentAdapter(bean?.activeStatus ?: 0, contentList) { _: View, position: Int ->
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
            btn_commit.visibility = View.VISIBLE
            cl_status.visibility = View.GONE
            cl_module.visibility = View.VISIBLE

            val startDate = intent.getStringExtra("date")

            tv_start_date.text = startDate

            addTextChangedListener()

            edit_plan_day.setText("1")

            setOnClickListener(
                tv_start_date, tv_end_date, btn_commit, tv_plan_module
            )

        } else {
            defaultTitle("计划详情")

            btn_modify.visibility = View.VISIBLE
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

                if (it.activeStatus == 2) {
                    edit_title.keyListener = null
                    edit_title.setBackgroundResource(R.color.color_white)
                    btn_modify.visibility = View.GONE
                    iv_add.visibility = View.GONE
                    iv_module_more.visibility = View.GONE
                } else {
                    tv_plan_module.setOnClickListener(this)
                }
            }

            setOnClickListener(btn_modify)

        }


        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        iv_add.setOnClickListener(this)

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

            btn_modify.id -> {
                updatePlan()
            }

            iv_add.id -> {
                showAddDialog()
            }
        }
    }

    override fun close() {
        presenter.cancel()
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
            it.content = content.toString()
            it.planTitle = edit_title.text.toString()
            presenter.updatePlan(it)
        }
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
    override fun showCreatePlanResult() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun showTransferNextWeekResult() {}

    override fun showDeletePlantResult(id: Int) {}

    override fun showCompletePlantResult(id: Int) {}


    private fun showAddDialog() {
        val parentLayout = RelativeLayout(this)
        val editLayoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        editLayoutParams.leftMargin = resources.getDimension(R.dimen.dp_20).toInt()
        editLayoutParams.rightMargin = resources.getDimension(R.dimen.dp_20).toInt()
        editLayoutParams.topMargin = resources.getDimension(R.dimen.dp_20).toInt()

        val editText = EditText(this)
        editText.setPadding(
            resources.getDimension(R.dimen.dp_10).toInt(),
            resources.getDimension(R.dimen.dp_10).toInt(),
            resources.getDimension(R.dimen.dp_10).toInt(),
            resources.getDimension(R.dimen.dp_10).toInt()
        )
        editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.sp_14))
        editText.setBackgroundResource(R.drawable.sel_border)
        editText.imeOptions = EditorInfo.TYPE_CLASS_TEXT
        editText.isSingleLine = false
        editText.setLines(3)
        editText.gravity = Gravity.TOP

        editText.hint = "请输入内容"
        editText.setTextColor(ContextCompat.getColor(this, R.color.color_theme))
        parentLayout.addView(editText, editLayoutParams)
        AlertDialog.Builder(this)
            .setTitle("添加内容")
            .setView(parentLayout)
            .setNegativeButton("确定") { _: DialogInterface, _: Int ->
                val content = editText.text.toString()
                if (content.isNotEmpty()) {
                    val no = contentList.size + 1
                    contentList.add("$no.$content")
                    adapter.notifyDataSetChanged()
                    recycler.layoutManager?.scrollToPosition(contentList.size - 1)
                }
            }
            .setPositiveButton("关闭") { _: DialogInterface, _: Int -> }
            .show()
    }
}