package com.zhkj.housekeeping.plan.activity

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.haibin.calendarview.Calendar
import com.haibin.calendarview.CalendarView
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.bean.Dictionary
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.utils.ToastUtil
import com.zhkj.housekeeping.plan.R
import com.zhkj.housekeeping.plan.adapter.PlanListAdapter
import com.zhkj.housekeeping.plan.bean.PlanBean
import com.zhkj.housekeeping.plan.contract.PlanContract
import com.zhkj.housekeeping.plan.contract.PlanExtendContract
import com.zhkj.housekeeping.plan.presenter.PlanExtendPresenter
import com.zhkj.housekeeping.plan.presenter.PlanPresenter
import kotlinx.android.synthetic.main.act_plan.*
import kotlinx.coroutines.cancel

/**
 * Desc 计划主页
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/8 18:53
 */
@Route(path = RouterPath.PLAN_ACTIVITY)
class PlanActivity : BaseActivity(), CalendarView.OnCalendarSelectListener,
    CalendarView.OnMonthChangeListener
    , CalendarView.OnYearChangeListener, PlanContract.IView, PlanExtendContract.IView {

    private lateinit var toolbar: Toolbar

    private var calendar: Calendar? = null

    private val pullRefreshFragment = PullRefreshFragment<PlanBean>()

    private val presenter: PlanPresenter by lazy {
        PlanPresenter(this)
    }

    private val extendPresenter: PlanExtendPresenter by lazy {
        PlanExtendPresenter(this)
    }

    override fun setLayout(): Int = R.layout.act_plan

    override fun initView() {

        calendar = calendarView.selectedCalendar

        toolbar = defaultTitle("${calendarView.curYear}年${calendarView.curMonth}月")
        toolbar.setOnMenuItemClickListener {

            when (it.itemId) {

                R.id.menu_add -> {
                    val date = "${calendar?.year}-${calendar?.month}-${calendar?.day}"
                    ARouter.getInstance().build(RouterPath.PLAN_EXTEND_ACTIVITY)
                        .withInt("type", PlanExtendActivity.CRATE)
                        .withString("date", date).navigation(this, 10000)
                }

                R.id.menu_today -> {
                    calendarView.scrollToCurrent(true)
                }
            }

            return@setOnMenuItemClickListener true
        }

        pullRefreshFragment.loadData = {

        }
        pullRefreshFragment.isShowEmptyView = false
        pullRefreshFragment.enableRefresh = false
        pullRefreshFragment.enableLoadMore = false

        pullRefreshFragment.adapter = PlanListAdapter().apply {
            setOnItemClickListener { _, position ->
                ZyFrameStore.setData(PlanBean::class.java.simpleName, getData(position))
                ARouter.getInstance().build(RouterPath.PLAN_EXTEND_ACTIVITY)
                    .withInt("type", PlanExtendActivity.PREVIEW)
                    .navigation(this@PlanActivity, 10000)

            }

            settingOnClickListener = object : PlanListAdapter.ISettingOnClickListener {

                override fun onCompleteClickListener(bean: PlanBean) {
                    extendPresenter.completePlan(bean.planId)
                }

                override fun onDeleteClickListener(bean: PlanBean) {
                    showDeleteDialog(bean.planId)
                }

                override fun onNextClickListener(bean: PlanBean) {
                    extendPresenter.transferNextWeek(bean)
                }

            }
        }

        supportFragmentManager.beginTransaction().replace(fl_content.id, pullRefreshFragment)
            .commit()

        calendarView.setOnCalendarSelectListener(this)
        calendarView.setOnMonthChangeListener(this)
    }

    override fun loadData() {
        loadPlanMark(calendar)
        loadPlanList()
    }


    private fun loadPlanMark(calendar: Calendar?) {
        calendar?.let {
            presenter.loadPlanMark(it.year, it.month)
        }

    }

    private fun loadPlanList() {
        calendar?.let {
            presenter.loadPlanList("${it.year}-${it.month}-${it.day}", null)
        }
    }


    override fun onClickEvent(view: View) {

    }

    override fun close() {
        presenter.cancel()
        extendPresenter.cancel()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        toolbar.inflateMenu(R.menu.menu_plan_title_right)
        return true
    }

    override fun onCalendarSelect(calendar: Calendar, isClick: Boolean) {

        if (calendar.month != this.calendar?.month) {
            loadPlanMark(calendar)
        }

        this.calendar = calendar
        toolbar.title = "${calendar.year}年${calendar.month}月"
        pullRefreshFragment.page = 1
        loadPlanList()
    }

    override fun onCalendarOutOfRange(calendar: Calendar) {}

    override fun onMonthChange(year: Int, month: Int) {}

    override fun onYearChange(year: Int) {}


    override fun showPlanMark(scheme: HashMap<String, Calendar>) {
        calendarView.setSchemeDate(scheme)
    }


    override fun showPlanList(planList: ArrayList<PlanBean>) {
        pullRefreshFragment.addData(planList)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10000 && resultCode == Activity.RESULT_OK) {
            calendar?.let {
                loadPlanMark(it)
                loadPlanList()
            }
        }
    }


    override fun showPlanExecutionModule(dictionaryList: ArrayList<Dictionary>) {}

    override fun showCreatePlanResult() {}

    override fun showTransferNextWeekResult() {
        loadPlanMark(calendar)
        ToastUtil.show("数据下移成功！")
    }

    override fun showDeletePlantResult(id: Int) {
        pullRefreshFragment.getAllData()?.find { it.planId == id }?.let {
            loadPlanMark(calendar)
            pullRefreshFragment.deleteData(it)

        }

    }

    override fun showCompletePlantResult(id: Int) {
        pullRefreshFragment.getAllData()?.find { it.planId == id }?.let {
            it.activeStatus = 2
            it.activeStatusName = "已完成"
            pullRefreshFragment.adapter?.notifyDataSetChanged()
        }
    }

    //显示删除Dialog确认框
    private fun showDeleteDialog(planId: Int) {
        AlertDialog.Builder(this)
            .setTitle("删除提醒")
            .setMessage("是否确定要删除计划？")
            .setNegativeButton("确定") { _: DialogInterface, _: Int ->
                extendPresenter.deletePlan(planId)
            }
            .setPositiveButton("取消") { _: DialogInterface, _: Int -> }
            .show()
    }
}