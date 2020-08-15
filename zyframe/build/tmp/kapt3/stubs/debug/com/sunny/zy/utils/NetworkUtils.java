package com.sunny.zy.utils;

import java.lang.System;

/**
 * 网络请求判断
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/sunny/zy/utils/NetworkUtils;", "", "()V", "TYPE_PPPOE", "", "TYPE_UN_ACTIVE", "getNetworkType", "con", "Landroid/content/Context;", "isNetworkAvaliable", "", "zyframe_debug"})
public final class NetworkUtils {
    
    /**
     * 没有可用网络
     */
    private static final int TYPE_UN_ACTIVE = -2;
    
    /**
     * pppoe连接
     */
    public static final int TYPE_PPPOE = 18;
    public static final com.sunny.zy.utils.NetworkUtils INSTANCE = null;
    
    public final boolean isNetworkAvaliable(@org.jetbrains.annotations.NotNull()
    android.content.Context con) {
        return false;
    }
    
    /**
     * 返回当前可用的网络类型
     *
     * @param con
     * @return
     */
    public final int getNetworkType(@org.jetbrains.annotations.NotNull()
    android.content.Context con) {
        return 0;
    }
    
    private NetworkUtils() {
        super();
    }
}