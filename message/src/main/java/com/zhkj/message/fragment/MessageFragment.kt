package com.zhkj.message.fragment

import com.sunny.zy.ZyFrameStore
import com.sunny.zy.fragment.PullRefreshFragment
import com.zhkj.message.R
import com.zhkj.message.adapter.FriendGroupAdapter
import com.zhkj.message.bean.FriendsBean
import com.zhkj.message.contract.MessageContract
import com.zhkj.message.presenter.MessagePresenter
import kotlinx.coroutines.cancel

class MessageFragment : PullRefreshFragment<Any>(), MessageContract.IFriendsView {

    private val presenter: MessageContract.Presenter by lazy {
        MessagePresenter(this)
    }


    override fun setLayout(): Int = 0

    override fun initView() {
        getBaseActivity().simpleTitle(getString(R.string.message))

        enableLoadMore = false

        adapter = FriendGroupAdapter()

        loadData = {
            presenter.loadFriendData()
        }

        super.initView()
    }


    override fun loadData() {
        ZyFrameStore.getData<FriendsBean>(FriendsBean::class.java.simpleName).let {
            if (it == null) {
                showLoading()
                presenter.loadFriendData()
            } else {
                showFriendData(it)
            }
        }
    }

    override fun close() {
        presenter.cancel()
    }

    override fun showFriendData(friendsBean: FriendsBean) {
        ZyFrameStore.setData(friendsBean.javaClass.simpleName, friendsBean)
        val dataList = arrayListOf<Any>()
        dataList.add(
            FriendsBean.Groups.Group(
                "rw64", "工作总群", "", "2", "rw"
            )
        )
        dataList.addAll(friendsBean.group)
        addData(dataList)
    }

}