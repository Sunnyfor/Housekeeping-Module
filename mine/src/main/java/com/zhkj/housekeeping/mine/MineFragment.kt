package com.zhkj.housekeeping.mine

import android.view.View
import androidx.appcompat.app.AlertDialog
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrame
import com.sunny.zy.base.BaseFragment
import com.sunny.zy.utils.RouterPath
import com.zhkj.housekeeping.mine.presenter.MinePresenter
import kotlinx.android.synthetic.main.fram_mine.*

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/12 15:07
 */
class MineFragment : BaseFragment(), MineContract.View {

    private val presenter: MinePresenter by lazy {
        MinePresenter(this)
    }

    override fun setLayout(): Int = R.layout.fram_mine

    override fun initView() {
        rl_logout.setOnClickListener(this)
    }

    override fun loadData() {
        presenter.getCompanyInfo()
    }

    override fun close() {

    }

    override fun onClick(v: View) {
        when (v.id) {
            //退出登录
            rl_logout.id -> {
                showLogoutDialog()
            }
        }

    }

    override fun showCompanyInfo(companyInfo: MyCompanyInfo) {
    }

    override fun logout() {
        ZyFrame.finishAllActivity()
        //跳转登录页面
        ARouter.getInstance().build(RouterPath.LOGIN_LOGIN_ACTIVITY).navigation()

    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("提醒")
            .setMessage("确定要退出登录吗？")
            .setPositiveButton("确定") { _, _ ->
                presenter.logout()
            }
            .setNegativeButton("取消") { _, _ ->

            }
            .show()
    }
}