package com.zhkj.user

import android.app.Activity
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
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

    @Autowired
    @JvmField
    var selectUserIds = ArrayList<String>()

    lateinit var toolbar: Toolbar

    private val userPresenter: UserContract.UserPresenter by lazy {
        UserPresenter(this)
    }

    private val fragmentList = ArrayList<PullRefreshFragment<OtherUserBean>>()
    private val tabTitleList = ArrayList<String>()

    override fun setLayout(): Int = R.layout.act_select_user

    override fun initView() {

        ARouter.getInstance().inject(this)

        toolbar = defaultTitle(getString(R.string.select_person))

        toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.menu_complete_dest) {
//                val intent = Intent()
//                val dataList = pullRefreshFragment.adapter?.getAllData()
//                    ?.filter { bean -> bean.isAlreadyJoinPeople } as ArrayList
//                intent.putParcelableArrayListExtra("data", dataList)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
            return@setOnMenuItemClickListener true
        }

    }

    override fun loadData() {
        userPresenter.loadOtherUserList(1, true)
    }

    override fun onClickEvent(view: View) {

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
//        viewpager.offscreenPageLimit = tab_layout.tabCount

        viewpager.adapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getItem(position: Int): Fragment = fragmentList[position]
            override fun getCount(): Int = fragmentList.size
            override fun getPageTitle(position: Int): CharSequence? {
                return tabTitleList[position]
            }

        }
        tab_layout.setupWithViewPager(viewpager)
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

        fragment.adapter = SelectUserAdapter(list)
        fragmentList.add(fragment)
    }
}