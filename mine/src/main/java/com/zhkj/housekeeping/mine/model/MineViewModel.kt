package com.zhkj.housekeeping.mine.model

import androidx.lifecycle.ViewModel
import com.zhkj.housekeeping.mine.MyCompanyInfo

class MineViewModel : ViewModel() {
    var isShowUpdateMark = false
    var username: String? = null
    var myCompanyInfo: MyCompanyInfo? = null
}