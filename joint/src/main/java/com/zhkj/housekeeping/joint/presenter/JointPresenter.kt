package com.zhkj.housekeeping.joint.presenter

import com.sunny.zy.base.IBaseView
import com.zhkj.housekeeping.joint.bean.JointBean
import com.zhkj.housekeeping.joint.contract.JointContract
import com.zhkj.housekeeping.joint.model.JointModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/4 11:43
 */
class JointPresenter(iView: IBaseView) : JointContract.Presenter(iView) {

    private val jointModel: JointModel by lazy {
        JointModel()
    }


    //加载协同数据
    override fun loadJointList(page: Int, type: Int) {
        launch(Main) {
            jointModel.loadJointList(page, type)?.let {
                if (view is JointContract.IJointListView) {
                    (view as JointContract.IJointListView).showJointList(it)
                }
            }
            hideLoading()
        }
    }

    //加载协同回收站数据
    override fun loadJointRecycle() {
        launch(Main) {
            jointModel.jointRecycle()?.let {
                if (view is JointContract.IJointRecycleBinView) {
                    (view as JointContract.IJointRecycleBinView).showRecycleList(it)
                }
            }
            hideLoading()
        }
    }

    //创建协同
    override fun createJoint(
        synergyTitle: String, content: String, synergyNames: String, synergyIds: String
    ) {
        if (synergyTitle.isEmpty()) {
            view?.showMessage("请输入协同标题！")
            return
        }

        if (content.isEmpty()) {
            view?.showMessage("请输入协同内容！")
            return
        }

        launch(Main) {
            showLoading()
            jointModel.createJoint(synergyTitle, content, synergyNames, synergyIds)?.let {
                view?.showMessage("创建成功！")
                if (view is JointContract.IJointCreateView) {
                    (view as JointContract.IJointCreateView).showCreateJointResult()
                }
            }
            hideLoading()
        }
    }

    //加载计划可用状态
    override fun loadJointState() {
        launch(Main) {
            showLoading()
            jointModel.loadJointState()?.let {
                if (view is JointContract.IJointCreateView) {
                    (view as JointContract.IJointCreateView).showJointStateList(it)
                }
            }
            hideLoading()
        }
    }

    //修改协同
    override fun modifyJoint(jointBean: JointBean) {
        launch(Main) {
            showLoading()
            jointModel.modifyJoint(jointBean)?.let {
                view?.showMessage("修改成功！")
                if (view is JointContract.IJointCreateView) {
                    (view as JointContract.IJointCreateView).showModifyJointResult()
                }
            }
            hideLoading()
        }
    }

    override fun deleteJoint(id: String) {
        launch(Main) {
            showLoading()
            jointModel.deleteJoint(id)?.let {
                view?.showMessage("删除成功！")
                if (view is JointContract.IJointDeleteView) {
                    (view as JointContract.IJointDeleteView).showDeleteJointResult(id)
                }
            }
            hideLoading()
        }
    }

    override fun sendReply(groupId: String, content: String) {

        if (content.isEmpty()) {
            return
        }
        launch(Main) {
            showLoading()
            jointModel.sendReply(groupId, content)?.let {
                view?.showMessage("发送成功！")
                if (view is JointContract.IJointReplyView) {
                    (view as JointContract.IJointReplyView).showReplyJoint()
                }
            }
            hideLoading()
        }
    }

    override fun loadReplyList(id: String) {
        launch(Main) {
            showLoading()
            jointModel.loadReplyList(id)?.let {
                if (view is JointContract.IJointReplyView) {
                    (view as JointContract.IJointReplyView).showReplyJointList(it)
                }
            }
            hideLoading()
        }
    }
}