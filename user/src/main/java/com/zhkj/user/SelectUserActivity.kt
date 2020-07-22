package com.zhkj.user

import android.app.Activity
import android.content.Intent
import android.view.Menu
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.fragment.PullRefreshFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.user.adapter.SelectUserAdapter
import com.zhkj.user.bean.OtherUserBean
import com.zhkj.user.contract.UserContract
import com.zhkj.user.presenter.UserPresenter
import kotlinx.android.synthetic.main.act_select_user.*

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 15:20
 */
@Route(path = RouterPath.USER_SELECT_ACTIVITY)
class SelectUserActivity : BaseActivity(), UserContract.IOtherUserView {

    private var currentFragment: PullRefreshFragment<OtherUserBean>? = null


    private val selectUserIds: ArrayList<String> by lazy {
        ZyFrameStore.getData<ArrayList<String>>("selectUserIds", true) ?: arrayListOf()
    }

    lateinit var toolbar: Toolbar

    private val userPresenter: UserContract.UserPresenter by lazy {
        UserPresenter(this)
    }

    private val fragmentList = ArrayList<PullRefreshFragment<OtherUserBean>>()
    private val tabTitleList = ArrayList<String>()

    override fun setLayout(): Int = R.layout.act_select_user

    override fun initView() {


        toolbar = defaultTitle(getString(R.string.select_person))


        toolbar.setOnMenuItemClickListener {

            currentFragment?.getAllData()?.forEach { bean ->
                bean.isAlreadyJoinPeople = it.title == getString(R.string.select_all)
            }
            if (it.title == getString(R.string.select_all)) {
                it.title = getString(R.string.cancel)
            } else {
                it.title = getString(R.string.select_all)
            }
            currentFragment?.adapter?.notifyDataSetChanged()

            return@setOnMenuItemClickListener true
        }

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                currentFragment = fragmentList[position]
                updateTitle()
            }

        })

        btn_complete.setOnClickListener(this)
    }

    override fun loadData() {
        userPresenter.loadOtherUserList(1, true)
    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            btn_complete.id -> {
                val intent = Intent()
                val dataList = arrayListOf<OtherUserBean>()
                fragmentList.forEach { fragment ->
                    fragment.getAllData()?.filter { it.isAlreadyJoinPeople }?.let {
                        dataList.addAll(it)
                    }
                }
                intent.putParcelableArrayListExtra("data", dataList)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        toolbar.inflateMenu(R.menu.menu_select_user_title)
        return true
    }


    override fun close() {

    }


    override fun showOtherList(data: ArrayList<OtherUserBean>) {
        data.groupBy { it.deptName }.forEach {
            tabTitleList.add(it.key ?: "")
            initFragment(PullRefreshFragment(), it.value as ArrayList<OtherUserBean>)
        }
        viewpager.adapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getItem(position: Int): Fragment {
                return fragmentList[position]
            }

            override fun getCount(): Int = fragmentList.size
            override fun getPageTitle(position: Int): CharSequence? {
                return tabTitleList[position]
            }

        }
        tab_layout.setupWithViewPager(viewpager)
        currentFragment = fragmentList[0]
        updateTitle()
    }


    private fun initFragment(
        fragment: PullRefreshFragment<OtherUserBean>,
        list: ArrayList<OtherUserBean>
    ) {
        fragment.enableRefresh = false
        fragment.enableLoadMore = false
        fragment.loadData = {
            loadData()
        }

        list.forEach {
            if (selectUserIds.contains(it.userId)) {
                it.isAlreadyJoinPeople = true
            }
        }

        fragment.adapter = SelectUserAdapter(list).apply {
            setOnItemClickListener { view, _ ->
                view.findViewById<CheckBox>(R.id.checkbox).performClick()
                updateTitle()
            }
        }
        fragmentList.add(fragment)
    }


    private fun updateTitle() {
        if (currentFragment?.getAllData()?.find { !it.isAlreadyJoinPeople } != null) {
            toolbar.menu.getItem(0).title = getString(R.string.select_all)
        } else {
            toolbar.menu.getItem(0).title = getString(R.string.cancel)
        }
    }
}