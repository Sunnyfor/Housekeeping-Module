package com.zhkj.task

import android.app.Activity
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.gson.Gson
import com.sunny.zy.base.BaseActivity
import com.sunny.zy.base.BaseModel
import com.sunny.zy.utils.RouterPath
import com.sunny.zy.utils.ToastUtil
import com.zhkj.task.bean.GoodsBean
import com.zhkj.task.contract.GoodsContract
import com.zhkj.task.presenter.GoodsPresenter
import kotlinx.android.synthetic.main.act_add_goods.*
import kotlinx.coroutines.cancel

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/8/13 18:20
 */
@Route(path = RouterPath.ADD_GOODS_ACTIVITY)
class AddGoodsActivity : BaseActivity(), GoodsContract.GoodsView {

    private var goodsList = ArrayList<GoodsBean>()

    @Autowired
    @JvmField
    var taskId: String? = null

    @Autowired
    @JvmField
    var position: Int = -1

    private val goodsPresenter: GoodsContract.Presenter by lazy {
        GoodsPresenter(this)
    }


    override fun setLayout(): Int = R.layout.act_add_goods

    override fun initView() {
        ARouter.getInstance().inject(this)

        defaultTitle(if (position == -1) getString(R.string.add_goods) else getString(R.string.modify_goods))
        setOnClickListener(btn_commit)
    }

    override fun loadData() {
        taskId?.let {
            goodsList.clear()
            goodsPresenter.loadGoodsData(1, it)
        }
    }

    override fun onClickEvent(view: View) {
        when (view.id) {
            btn_commit.id -> {
                if (edit_name.text.isEmpty()) {
                    ToastUtil.show("请填写物品名称！")
                    return
                }

                if (edit_count.text.isEmpty()) {
                    ToastUtil.show("请填写物品数量！")
                    return
                }

                if (position == -1) {
                    goodsList.add(
                        GoodsBean(
                            null,
                            null,
                            null,
                            null,
                            edit_name.text.toString(),
                            edit_count.text.toString(),
                            null,
                            taskId
                        )
                    )
                } else {
                    goodsList[position].let {
                        it.goodsName = edit_name.text.toString()
                        it.goodsNum = edit_count.text.toString()
                    }
                }
                goodsPresenter.updateGoods(taskId ?: "", Gson().toJson(goodsList))
            }
        }
    }

    override fun close() {
        goodsPresenter.cancel()
    }

    override fun showGoodsData(data: ArrayList<GoodsBean>) {
        goodsList.addAll(data)
        if (position != -1) {
            edit_name.setText(goodsList[position].goodsName)
            edit_name.setSelection(edit_name.text.length)
            edit_count.setText(goodsList[position].goodsNum)
        }

    }

    override fun updateGoodsResult(data: BaseModel<Any>) {
        setResult(Activity.RESULT_OK)
        finish()
    }
}