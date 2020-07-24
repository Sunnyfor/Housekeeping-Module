package com.zhkj.housekeeping.message

import com.sunny.zy.ZyFrameStore
import com.sunny.zy.fragment.PullRefreshFragment
import com.zhkj.housekeeping.adapter.FriendGroupAdapter
import com.zhkj.housekeeping.bean.FriendsBean
import com.zhkj.housekeeping.contract.MessageContract
import com.zhkj.housekeeping.presenter.MessagePresenter

class MessageFragment : PullRefreshFragment<Any>(), MessageContract.IFriendsView {

    private val presenter: MessageContract.Presenter by lazy {
        MessagePresenter(this)
    }

    override fun setLayout(): Int = R.layout.fram_message

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