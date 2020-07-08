package com.zhkj.housekeeping.joint.presenter

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.housekeeping.work.joint.bean.JointBean
import com.sunny.zy.base.BasePresenter
import com.sunny.zy.base.IBaseView
import com.zhkj.housekeeping.joint.model.JointViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/4 11:43
 */
class JointPresenter(view: IBaseView) : BasePresenter<IBaseView>(view) {

//    private val viewModel: JointViewModel by lazy {
//        ViewModelProvider(view.getViewModelStoreOwner()).get(JointViewModel::class.java)
//    }


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
//    //加载协同数据
//    fun loadJointList(page: Int, type: Int) {
//        launch(Main) {
//            showLoading()
//            viewModel.getJointList(page, type)
//            hideLoading()
//        }
//    }
//
//
//    //加载协同回收站数据
//    fun loadJointRecycle() {
//        launch(Main) {
//            showLoading()
//            viewModel.jointRecycle()
//            hideLoading()
//        }
//    }
}