package com.zhkj.im.bean

import android.os.Parcel
import android.os.Parcelable
import com.starrtc.starrtcsdk.core.im.message.XHIMMessage

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/28 14:50
 */
class IMMessageBean(xHIMMessage: XHIMMessage?) : Parcelable {

    constructor() : this(null)

    var fromId: String? = xHIMMessage?.fromId
    var targetId: String? = xHIMMessage?.targetId
    var time: Long = xHIMMessage?.time ?: 0
    var msgIndex: Int = xHIMMessage?.msgIndex ?: 0
    var contentData: String? = xHIMMessage?.contentData
    var atList: String? = xHIMMessage?.atList
    var type: Int = xHIMMessage?.type ?: 0
    var code: Int = xHIMMessage?.code ?: 0

    constructor(parcel: Parcel) : this() {
        fromId = parcel.readString()
        targetId = parcel.readString()
        time = parcel.readLong()
        msgIndex = parcel.readInt()
        contentData = parcel.readString()
        atList = parcel.readString()
        type = parcel.readInt()
        code = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fromId)
        parcel.writeString(targetId)
        parcel.writeLong(time)
        parcel.writeInt(msgIndex)
        parcel.writeString(contentData)
        parcel.writeString(atList)
        parcel.writeInt(type)
        parcel.writeInt(code)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IMMessageBean> {
        override fun createFromParcel(parcel: Parcel): IMMessageBean {
            return IMMessageBean(parcel)
        }

        override fun newArray(size: Int): Array<IMMessageBean?> {
            return arrayOfNulls(size)
        }
    }
}