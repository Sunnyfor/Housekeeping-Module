package com.zhkj.message.mine.model

import androidx.lifecycle.ViewModel
import com.zhkj.message.mine.MyCompanyInfo

class MineViewModel : ViewModel() {
    var isShowUpdateMark = false
    var username: String? = null
    var myCompanyInfo: MyCompanyInfo? = null
}