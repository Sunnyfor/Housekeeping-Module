package com.sunny.zy.utils;

import java.lang.System;

/**
 * Desc单例 Toast
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/10/25 11:03
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/sunny/zy/utils/ToastUtil;", "", "()V", "toast", "Landroid/widget/Toast;", "show", "", "content", "", "type", "", "showInterfaceError", "msg", "code", "zyframe_debug"})
public final class ToastUtil {
    private static android.widget.Toast toast;
    public static final com.sunny.zy.utils.ToastUtil INSTANCE = null;
    
    /**
     * 显示Toast
     * @param content Toast信息
     */
    public final void show(@org.jetbrains.annotations.Nullable()
    java.lang.String content, int type) {
    }
    
    public final void show(@org.jetbrains.annotations.Nullable()
    java.lang.String content) {
    }
    
    public final void show() {
    }
    
    public final void showInterfaceError(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    /**
     * 为兼容旧的网络请求框架，后期可以删除
     */
    public final void showInterfaceError(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    private ToastUtil() {
        super();
    }
}