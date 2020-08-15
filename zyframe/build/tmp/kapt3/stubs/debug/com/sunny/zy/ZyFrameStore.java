package com.sunny.zy;

import java.lang.System;

/**
 * 应用类
 * Created by zhangye on 2018/8/2.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0012\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0010\u001a\u00020\u0007J%\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\nJ\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/sunny/zy/ZyFrameStore;", "", "()V", "activityStack", "Ljava/util/Stack;", "Lcom/sunny/zy/base/BaseActivity;", "instance", "Landroid/content/Context;", "storeMap", "Ljava/util/HashMap;", "", "addActivity", "", "baseActivity", "finishAllActivity", "activity", "getContext", "getData", "T", "key", "isDelete", "", "(Ljava/lang/String;Z)Ljava/lang/Object;", "init", "context", "removeActivity", "removeData", "setData", "t", "zyframe_debug"})
public final class ZyFrameStore {
    private static android.content.Context instance;
    private static final java.util.Stack<com.sunny.zy.base.BaseActivity> activityStack = null;
    private static final java.util.HashMap<java.lang.String, java.lang.Object> storeMap = null;
    public static final com.sunny.zy.ZyFrameStore INSTANCE = null;
    
    public final void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public final <T extends java.lang.Object>T getData(@org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean isDelete) {
        return null;
    }
    
    /**
     * 存储数据
     */
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.Object t) {
    }
    
    /**
     * 删除数据
     */
    public final void removeData(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    /**
     * 存储管理Activity
     */
    public final void addActivity(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.base.BaseActivity baseActivity) {
    }
    
    /**
     * 移除Activity
     */
    public final void removeActivity(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.base.BaseActivity baseActivity) {
    }
    
    /**
     * 关闭所有的Activity
     */
    public final void finishAllActivity(@org.jetbrains.annotations.Nullable()
    com.sunny.zy.base.BaseActivity activity) {
    }
    
    private ZyFrameStore() {
        super();
    }
}