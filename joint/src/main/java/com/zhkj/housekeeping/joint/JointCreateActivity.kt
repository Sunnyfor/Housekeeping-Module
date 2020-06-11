package com.zhkj.housekeeping.joint

import android.app.Activity
import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.housekeeping.work.joint.bean.JointBean
import com.sunny.zy.ZyFrame
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.bean.AllUsersBean
import com.sunny.zy.bean.Dictionary
import com.sunny.zy.leader.AllUserPresenter
import com.sunny.zy.leader.IAllUsersView
import com.zhkj.housekeeping.joint.adapter.JointReplyAdapter
import com.zhkj.housekeeping.joint.model.JointViewModel
import kotlinx.android.synthetic.main.act_create_joint.*
import kotlinx.coroutines.cancel

class JointCreateActivity : BaseActivity(), IAllUsersView {
    companion object {
        const val TYPE_CREATE = 0
        const val TYPE_PREVIEW = 1
        const val TYPE_MODIFY = 2
    }


    var type = TYPE_CREATE

    private val allUserPresenter: AllUserPresenter by lazy {
        AllUserPresenter(this)
    }

    private val jointViewModel: JointViewModel by lazy {
        ViewModelProvider(this).get(JointViewModel::class.java)
    }

    private val jointBean: JointBean? by lazy {
        ZyFrame.getData<JointBean>("jointBean", true)
    }

    private val jointStateList: ArrayList<Dictionary>? by lazy {
        ZyFrame.getData<ArrayList<Dictionary>>("joinStateList", true)
    }

    private var checkedItems: BooleanArray? = null
    private var checkedId = StringBuilder()
    private var userList = ArrayList<AllUsersBean>()

    override fun setLayout(): Int = R.layout.act_create_joint


    override fun initView() {

        type = intent.getIntExtra("type", TYPE_CREATE)

        var title = ""

        when (type) {
            TYPE_CREATE -> {
                tv_select.setOnClickListener(this)
                title = "创建协同"
            }

            TYPE_PREVIEW, TYPE_MODIFY -> {
                ll_state.visibility = View.VISIBLE

                jointBean?.let {
                    tv_state.text = it.stateName
                    if (it.state == 1) {
                        edit_verify.visibility = View.VISIBLE
                        edit_verify.setText(it.checkContent)
                    } else {
                        edit_verify.visibility = View.GONE
                        edit_verify.setText("")
                    }
                    edit_content.setText(it.content)
                    edit_content.setSelection(it.content.length)
                    tv_select.text = it.synergyNames

                    checkedId.clear()
                    checkedId.append(it.synergyIds)
                }

                if (type == TYPE_PREVIEW) {
                    title = "协同详情"

                    iv_person_more.visibility = View.GONE
                    iv_state_more.visibility = View.GONE

                    btn_commit.visibility = View.GONE
                    ll_send.visibility = View.VISIBLE
                    edit_content.keyListener = null
                    edit_verify.keyListener = null
                    rl_list.visibility = View.VISIBLE

                    if (jointBean?.replyList?.isNotEmpty() == true) {
                        tv_no_data.visibility = View.GONE
                        recyclerView.layoutManager = LinearLayoutManager(this)
                        recyclerView.adapter = JointReplyAdapter(
                            jointBean?.replyList
                                ?: arrayListOf()
                        )
                    }
                    emotion_send.setOnClickListener(this)
                } else {
                    title = "修改协同"
                    tv_select.setOnClickListener(this)
                    ll_state.setOnClickListener(this)
                }
            }
        }

        titleManager.defaultTitle(getFrameTitle(),title,"")

        btn_commit.setOnClickListener(this)

        //创建协同回调
        jointViewModel.jointCreateLiveData.observe(this, Observer {
            hideLoading()
            if (it?.msg == "success") {
                setResult(Activity.RESULT_OK)
                finish()
            }
        })

        jointViewModel.jointModifyLiveData.observe(this, Observer {
            hideLoading()
            if (it?.msg == "success") {
                setResult(Activity.RESULT_OK)
                finish()
            }
        })

        jointViewModel.jointReplyLiveData.observe(this, Observer {
            et_input.setText("")
            hideLoading()
            jointBean?.replyList = it ?: arrayListOf()
            recyclerView.adapter = JointReplyAdapter(
                it
                    ?: arrayListOf()
            )
        })
    }

    override fun onClickEvent(v: View) {
        when (v.id) {
            tv_select.id -> {
                if (type != TYPE_PREVIEW) {
                    if (checkedItems == null) {
                        allUserPresenter.getAllUser()
                    } else {
                        showSelectDialog()
                    }
                }
            }
            ll_state.id -> {
                showStateDialog()
            }
            btn_commit.id -> {
                if (type == TYPE_CREATE) {
                    showLoading()
//                    jointViewModel.createJoint(edit_content.text.toString(), checkedId.toString())
                    return
                }

                if (type == TYPE_MODIFY) {
                    jointBean?.let {
                        it.content = edit_content.text.toString()
                        it.checkContent = edit_verify.text.toString()
                        showLoading()
//                        jointViewModel.modifyJoint(it)
                    }

                }
            }

            emotion_send.id -> {
                showLoading()
//                jointViewModel.sendReply(jointBean?.synergyId.toString(), et_input.text.toString())
            }
        }
    }

    override fun loadData() {

    }


    //选择协同人员
    private fun showSelectDialog() {
        AlertDialog.Builder(this)
            .setTitle("选择协同人员")
            .setMultiChoiceItems(
                Array(userList.size) { userList[it].username },
                checkedItems
            ) { _: DialogInterface, index: Int, checked: Boolean ->
                checkedItems?.set(index, checked)
            }
            .setNegativeButton("确定") { _: DialogInterface, _: Int ->
                val personSb = StringBuilder()
                checkedId.clear()
                checkedItems?.forEachIndexed { index, b ->
                    if (b) {
                        personSb.append(userList[index].username).append("、")
                        checkedId.append(userList[index].userId).append(",")
                    }
                }
                if (personSb.isNotEmpty()) {
                    personSb.deleteCharAt(personSb.lastIndexOf("、"))
                    checkedId.deleteCharAt(checkedId.lastIndexOf(","))
                    tv_select.text = personSb.toString()
                    jointBean?.synergyIds = checkedId.toString()
                } else {
                    tv_select.text = "请选择"
                }
            }
            .setPositiveButton("取消") { _: DialogInterface, _: Int -> }
            .show()
    }


    private fun showStateDialog() {
        jointStateList?.let { list ->
            AlertDialog.Builder(this)
                .setTitle("选择协同状态")
                .setItems(Array(list.size) { list[it].value }) { _: DialogInterface, i: Int ->
                    tv_state.text = list[i].value
                    jointBean?.state = list[i].code
                    if (tv_state.text == "完成") {
                        edit_verify.visibility = View.VISIBLE
                    } else {
                        edit_verify.visibility = View.GONE
                    }
                }
                .setPositiveButton("取消") { _: DialogInterface, _: Int ->

                }
                .show()
        }

    }

    override fun getAllUser(list: ArrayList<AllUsersBean>) {
        userList.clear()
        userList.addAll(list)
        checkedItems = BooleanArray(userList.size)
        if (checkedId.isNotEmpty()) {
            if (checkedId.contains(",")) {
                checkedId.split(",").forEach { userId ->
                    checkedItems?.set(userList.indexOf(userList.find { it.userId == userId }), true)
                }
            } else {
                checkedItems?.set(
                    userList.indexOf(userList.find { it.userId == checkedId.toString() }),
                    true
                )
            }
        }
        showSelectDialog()
    }

    override fun onDestroy() {
        super.onDestroy()
        allUserPresenter.cancel()
    }

}