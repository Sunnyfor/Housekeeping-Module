package com.zhkj.housekeeping.plan.activity

import android.view.Menu
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.haibin.calendarview.Calendar
import com.haibin.calendarview.CalendarView
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.housekeeping.plan.R
import com.zhkj.housekeeping.plan.adapter.PlanListAdapter
import com.zhkj.housekeeping.plan.bean.PlanBean
import com.zhkj.housekeeping.plan.contract.PlanContract
import com.zhkj.housekeeping.plan.presenter.PlanPresenter
import kotlinx.android.synthetic.main.act_plan.*

/**
 * Desc 计划主页
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/8 18:53
 */
@Route(path = RouterPath.PLAN_ACTIVITY)
class PlanActivity : BaseActivity(), CalendarView.OnCalendarSelectListener,
    CalendarView.OnMonthChangeListener
    , CalendarView.OnYearChangeListener, PlanContract.IView {

    private lateinit var toolbar: Toolbar

    private var calendar: Calendar? = null

    private var currentYear = 2020
    private var currentMonth = 7
    private var currentDay = 1
    private val pullRefreshFragment = PullRefreshFragment<PlanBean>()

    private val presenter: PlanPresenter by lazy {
        PlanPresenter(this)
    }

    override fun setLayout(): Int = R.layout.act_plan

    override fun initView() {

        currentYear = calendarView.curYear
        currentMonth = calendarView.curMonth
        currentDay = calendarView.curDay

        toolbar = defaultTitle("${currentYear}年${currentMonth}月")
        toolbar.setOnMenuItemClickListener {

            when (it.itemId) {
                R.id.menu_add -> {
                    ARouter.getInstance().build(RouterPath.PLAN_EXTEND_ACTIVITY).navigation()
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
                getData(position)
            }
        }

        supportFragmentManager.beginTransaction().replace(fl_content.id, pullRefreshFragment)
            .commit()

        calendarView.setOnCalendarSelectListener(this)
        calendarView.setOnMonthChangeListener(this)
    }

    override fun loadData() {
        presenter.loadPlanMark(currentYear, currentMonth)
        presenter.loadPlanList("${currentYear}-${currentMonth}-${currentDay}", null)
    }

    override fun onClickEvent(view: View) {

    }

    override fun close() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        toolbar.inflateMenu(R.menu.menu_plan_title_right)
        return true
    }

    override fun onCalendarSelect(calendar: Calendar, isClick: Boolean) {
        this.calendar = calendar
        pullRefreshFragment.page = 1
        presenter.loadPlanList("${calendar.year}-${calendar.month}-${calendar.day}", null)
    }

    override fun onCalendarOutOfRange(calendar: Calendar) {

    }

    override fun onMonthChange(year: Int, month: Int) {
        currentYear = year
        currentMonth = month
        setTitleDate()
        loadData()
    }

    override fun onYearChange(year: Int) {
        currentYear = year
        setTitleDate()
    }


    private fun setTitleDate() {
        toolbar.title = "${currentYear}年${currentMonth}月"
    }

    override fun showPlanMark(scheme: HashMap<String, Calendar>) {
        calendarView.setSchemeDate(scheme)
    }


    override fun showPlanList(planList: ArrayList<PlanBean>) {
        pullRefreshFragment.addData(planList)
    }
}