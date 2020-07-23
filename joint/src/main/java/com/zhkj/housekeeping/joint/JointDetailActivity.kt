package com.zhkj.housekeeping.joint

import android.content.DialogInterface
import android.view.KeyEvent
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import com.zhkj.housekeeping.joint.adapter.JointReplyAdapter
import com.zhkj.housekeeping.joint.bean.JointBean
import com.zhkj.housekeeping.joint.contract.JointContract
import com.zhkj.housekeeping.joint.presenter.JointPresenter
import kotlinx.android.synthetic.main.act_joint_detail.*
import kotlinx.coroutines.cancel

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/21 19:11
 */
@Route(path = RouterPath.JOINT_DETAIL_ACTIVITY)
class JointDetailActivity : BaseActivity(), JointContract.IJointReplyView {


    private val jointBean: JointBean? by lazy {
        ZyFrameStore.getData<JointBean>("jointBean", true)
    }

    var memberArray: Array<String>? = null

    private val presenter: JointPresenter by lazy {
        JointPresenter(this)
    }

    private val onKeyListener: View.OnKeyListener by lazy {
        View.OnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                hideKeyboard()
                jointBean?.let {
                    presenter.sendReply("syn${it.synergyId}", et_input.text.toString())
                }
                et_input.text.clear()
                return@OnKeyListener true
            }
            return@OnKeyListener false
        }
    }

    lateinit var toolbar: Toolbar

    override fun setLayout(): Int = R.layout.act_joint_detail

    override fun initView() {
        ARouter.getInstance().inject(this)

        jointBean?.let { bean ->

            bean.synergyNames?.split(",")?.let { list ->
                memberArray = Array(list.size) { list[it] }
            }

            toolbar = defaultTitle(bean.synergyTitle ?: "")
            toolbar.setOnMenuItemClickListener {
                showMemberDialog()
                return@setOnMenuItemClickListener true
            }
            tv_content.text = bean.content ?: "未填写"
            val date = "${bean.startDate?.replace(" 00:00:00", "")} 至 ${
            bean.endDate?.replace(" 00:00:00", "") ?: "..."}"
            tv_date.text = date
            recycler_message.layoutManager = LinearLayoutManager(this)
            presenter.loadReplyList(bean.synergyId.toString())
        }

        et_input.setOnKeyListener(onKeyListener)

        setOnClickListener(btn_send)
    }

    override fun loadData() {

    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            btn_send.id -> {
                onKeyListener.onKey(et_input, KeyEvent.KEYCODE_ENTER, null)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        toolbar.inflateMenu(R.menu.menu_joint_detail_title)
        return true
    }


    override fun close() {
        presenter.cancel()
    }


    private fun showMemberDialog() {
        AlertDialog.Builder(this)
            .setItems(memberArray, null)
            .setTitle(getString(R.string.joint_person))
            .setNegativeButton("关闭") { _: DialogInterface, _: Int -> }
            .show()
    }

    override fun showReplyJoint() {
        jointBean?.let {
            presenter.loadReplyList(it.synergyId.toString())
        }
    }

    override fun showReplyJointList(data: ArrayList<JointBean.Reply>) {
        recycler_message.adapter = JointReplyAdapter(data)
    }
}