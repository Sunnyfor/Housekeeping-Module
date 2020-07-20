package com.zhkj.user.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/7/20 14:16
 */
@Suppress("UNCHECKED_CAST")
data class OtherUserBean(
    var userId: String? = null,
    var username: String? = null,
    var salt: String? = null,
    var email: String? = null,
    var mobile: String? = null,
    var status: String? = null,
    var roleIdList: ArrayList<Int>? = null,
    var createTime: String? = null,
    var deptId: String? = null,
    var deptName: String? = null,
    var imagesId: String? = null,
    var sign: String? = null

) : Parcelable {
    //本地字段，用于判断是否 已经是参与人
    var isAlreadyJoinPeople: Boolean = false

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readArrayList(Int::class.java.classLoader) as ArrayList<Int>?,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
        isAlreadyJoinPeople = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userId)
        parcel.writeString(username)
        parcel.writeString(salt)
        parcel.writeString(email)
        parcel.writeString(mobile)
        parcel.writeString(status)
        parcel.writeList(roleIdList)
        parcel.writeString(createTime)
        parcel.writeString(deptId)
        parcel.writeString(deptName)
        parcel.writeString(imagesId)
        parcel.writeString(sign)
        parcel.writeByte(if (isAlreadyJoinPeople) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OtherUserBean> {
        override fun createFromParcel(parcel: Parcel): OtherUserBean {
            return OtherUserBean(parcel)
        }

        override fun newArray(size: Int): Array<OtherUserBean?> {
            return arrayOfNulls(size)
        }
    }

}