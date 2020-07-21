package com.zhkj.housekeeping.joint.presenter

import com.sunny.zy.base.IBaseView
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


    //获取协同数据及监听协同数据
//    fun getJointList(type: Int, observer: Observer<ArrayList<JointBean>>): ArrayList<JointBean> {
//        return when (type) {
//            0 -> {
//                view?.let {
//                    viewModel.jointIssuedListLiveData.observe(
//                        it.getLifLifecycleOwner(), observer
//                    )
//                }
//                viewModel.jointIssuedListLiveData.value ?: arrayListOf()
//            }
//
//            1 -> {
//                view?.let {
//                    viewModel.jointListLiveData.observe(
//                        it.getLifLifecycleOwner(), observer
//                    )
//                }
//                viewModel.jointListLiveData.value ?: arrayListOf()
//            }
//
//            2 -> {
//                view?.let {
//                    viewModel.jointRecycleLiveData.observe(
//                        it.getLifLifecycleOwner(), observer
//                    )
//                }
//                viewModel.jointRecycleLiveData.value ?: arrayListOf()
//            }
//            else -> {
//                arrayListOf()
//            }
//        }
//    }
//
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

    //
//
    //加载协同回收站数据
    override fun loadJointRecycle(page:Int) {
        launch(Main) {
            jointModel.jointRecycle(page)?.let {
                if (view is JointContract.IJointRecycleBinView) {
                    (view as JointContract.IJointRecycleBinView).showRecycleList(it)
                }
            }
            hideLoading()
        }
    }
}