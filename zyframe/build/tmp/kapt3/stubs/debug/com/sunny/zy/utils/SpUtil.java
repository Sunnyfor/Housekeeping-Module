package com.sunny.zy.utils;

import java.lang.System;

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/8 17:17
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0004J)\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017\u00a2\u0006\u0002\u0010\u0018J#\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fJ\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u0013J\u0016\u0010!\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0001J\u0016\u0010#\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/sunny/zy/utils/SpUtil;", "", "()V", "FILE_NAME", "", "password", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "userInfoBean", "username", "clear", "", "getBoolean", "", "key", "flag", "getInteger", "", "getObject", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "getString", "content", "remove", "setBoolean", "setInteger", "setObject", "obj", "setString", "zyframe_debug"})
public final class SpUtil {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String username = "mUsername";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String password = "mPassword";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String userInfoBean = "mUserInfoBean";
    
    /**
     * 文件名
     */
    private static final java.lang.String FILE_NAME = "sharedPreferences_info";
    public static final com.sunny.zy.utils.SpUtil INSTANCE = null;
    
    private final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    /**
     * 保存String信息
     */
    public final void setString(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getString(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String content) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getString(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return null;
    }
    
    /**
     * 保存Boolean类型的信息
     */
    public final void setBoolean(@org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean flag) {
    }
    
    public final boolean getBoolean(@org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean flag) {
        return false;
    }
    
    public final boolean getBoolean(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return false;
    }
    
    /**
     * 保存Integer信息
     */
    public final void setInteger(@org.jetbrains.annotations.NotNull()
    java.lang.String key, int content) {
    }
    
    public final int getInteger(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return 0;
    }
    
    /**
     * 保存Object信息
     */
    public final void setObject(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.Object obj) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>T getObject(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>T getObject(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type type) {
        return null;
    }
    
    /**
     * 删除元素
     */
    public final void remove(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    /**
     * 清空share文件
     */
    public final void clear() {
    }
    
    private SpUtil() {
        super();
    }
}