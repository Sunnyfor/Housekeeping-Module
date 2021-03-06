package com.zhkj.joint

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.sunny.zy.ZyFrameStore
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.utils.RouterPath
import com.zhkj.common.bean.Dictionary
import com.zhkj.common.contract.DictContract
import com.zhkj.common.presenter.DictPresenter
import com.zhkj.joint.bean.JointBean
import com.zhkj.joint.contract.JointContract
import com.zhkj.joint.presenter.JointPresenter
import com.zhkj.user.SelectUserActivity
import com.zhkj.user.bean.OtherUserBean
import kotlinx.android.synthetic.main.act_joint_create.*
import kotlinx.coroutines.cancel

@Route(path = RouterPath.JOINT_CREATE_ACTIVITY)
class JointCreateActivity : BaseActivity(), JointContract.IJointCreateView, DictContract.DictView {

    private val jointPresenter: JointPresenter by lazy {
        JointPresenter(this)
    }

    private val dictPresenter: DictContract.Presenter by lazy {
        DictPresenter(this)
    }


    private val jointBean: JointBean? by lazy {
        ZyFrameStore.getData<JointBean>("jointBean", true)
    }

    var title = "创建协同"

    private val jointStateList = ArrayList<Dictionary>()

    private val idsSb = StringBuilder()
    private val namesSb = StringBuilder()

    override fun setLayout(): Int = R.layout.act_joint_create


    override fun initView() {

        ARouter.getInstance().inject(this)

        jointBean?.let {
            edit_title.setText(it.synergyTitle ?: "")
            edit_content.setText(it.content ?: "")

            cl_state.visibility = View.VISIBLE

            tv_state.text = it.stateName

            if (tv_state.text.toString() == "完成") {
                edit_review.visibility = View.VISIBLE
                edit_review.setText(it.checkContent)
            } else {
                edit_review.visibility = View.GONE
            }
            namesSb.append(it.synergyNames)
            idsSb.append(it.synergyIds)

            title = "修改协同"

            tv_person.text = namesSb.toString()
            btn_commit.text = getString(R.string.modify)
        }

        defaultTitle(title)

        setOnClickListener(cl_person, cl_state, btn_commit)
    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            cl_person.id -> {
                val selectUserIds = ArrayList<String>()
                if (idsSb.contains(",")) {
                    selectUserIds.addAll(idsSb.split(","))
                } else {
                    selectUserIds.add(idsSb.toString())
                }
                SelectUserActivity.startActivity(
                    this,
                    selectUserIds,
                    null
                )
            }

            cl_state.id -> {
                if (jointStateList.isEmpty()) {
                    dictPresenter.loadDict("name", "是否完成")
                } else {
                    showJointStateDialog()
                }
            }

            btn_commit.id -> {
                if (jointBean == null) {
                    jointPresenter.createJoint(
                        edit_title.text.toString(),
                        edit_content.text.toString(),
                        namesSb.toString(),
                        idsSb.toString()
                    )
                } else {
                    jointBean?.synergyTitle = edit_title.text.toString()
                    jointBean?.content = edit_content.text.toString()
                    jointBean?.synergyNames = namesSb.toString()
                    jointBean?.synergyIds = idsSb.toString()
                    jointBean?.checkContent = edit_review.text.toString()
                    jointPresenter.modifyJoint(jointBean ?: return)
                }
            }
        }
    }

    override fun loadData() {

    }

    override fun close() {
        jointPresenter.cancel()
        dictPresenter.cancel()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10000 && resultCode == Activity.RESULT_OK) {
            idsSb.clear()
            namesSb.clear()
            val list = SelectUserActivity.processResult(data)
            list?.forEachIndexed { index, bean ->
                idsSb.append(bean.userId)
                namesSb.append(bean.username)
                if (index != list.size - 1) {
                    idsSb.append(",")
                    namesSb.append(",")
                }
            }

            val personStr =
                if (namesSb.isEmpty()) getString(R.string.joint_person_hint) else namesSb.toString()
            tv_person.text = personStr
        }
    }

    override fun showCreateJointResult() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun showModifyJointResult() {
        showCreateJointResult()
    }


    private fun showJointStateDialog() {
        AlertDialog.Builder(this)
            .setTitle("选择协同状态")
            .setItems(Array(jointStateList.size) { jointStateList[it].value }) { _: DialogInterface, i: Int ->
                tv_state.text = jointStateList[i].value
                jointBean?.state = jointStateList[i].code
                if (tv_state.text == "完成") {
                    edit_review.visibility = View.VISIBLE
                } else {
                    edit_review.visibility = View.GONE
                }
            }
            .setPositiveButton("取消") { _: DialogInterface, _: Int ->

            }
            .show()
    }

    override fun showDictResult(data: ArrayList<Dictionary>) {
        jointStateList.clear()
        jointStateList.addAll(data)
        showJointStateDialog()
    }
}