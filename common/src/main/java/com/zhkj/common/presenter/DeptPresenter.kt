package com.zhkj.common.presenter

import com.zhkj.common.contract.DeptContract
import com.zhkj.common.model.DeptModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/5 18:30
 */
class DeptPresenter(view: DeptContract.IDeptView) : DeptContract.Presenter(view) {

    private val deptModel: DeptModel by lazy {
        DeptModel()
    }

    //加载部门数据
    override fun loadDeptList() {
        launch(Main) {
            showLoading()
            deptModel.loadDept()?.let {
                view?.showDeptList(it)
            }
            hideLoading()
        }
    }
}