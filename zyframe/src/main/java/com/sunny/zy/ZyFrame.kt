package com.sunny.zy

import android.content.Context
import java.util.*

/**
 * 应用类
 * Created by zhangye on 2018/8/2.
 */
object ZyFrame {

    private lateinit var instance: Context

    fun init(context: Context) {
        instance = context.applicationContext
    }

    fun getContext() = instance

    private val storeMap = HashMap<String, Any>() //内存数据存储

    @Suppress("UNCHECKED_CAST")
    fun <T> getData(key: String, isDelete: Boolean): T? {

        if (!storeMap.containsKey(key)) {
            return null
        }

        val result = storeMap[key]

        if (isDelete) {
            removeData(key)
        }
        return result as T
    }


    /**
     * 存储数据
     */
    fun setData(key: String, t: Any?) {
        if (t != null) {
            storeMap[key] = t
        }
    }

    /**
     * 删除数据
     */
    fun removeData(key: String) {
        storeMap.remove(key)
    }
}