package com.sunny.zy.widget.utils;

import java.lang.System;

/**
 * Desc
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/4/27 21:09
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/sunny/zy/widget/utils/OverlayViewUtils;", "", "()V", "viewStore", "Ljava/util/HashMap;", "", "Landroid/view/View;", "getView", "context", "Landroid/content/Context;", "viewType", "hideView", "", "viewGroup", "Landroid/view/ViewGroup;", "optionView", "isShow", "", "showView", "zyframe_debug"})
public final class OverlayViewUtils {
    private java.util.HashMap<java.lang.Integer, android.view.View> viewStore;
    
    private final android.view.View getView(android.content.Context context, int viewType) {
        return null;
    }
    
    /**
     * 操作View的显示与关闭
     * @param viewGroup view的容器
     * @param viewType view的显示类型
     * @param isShow true 显示，false关闭
     */
    @org.jetbrains.annotations.Nullable()
    public final android.view.View optionView(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType, boolean isShow) {
        return null;
    }
    
    /**
     * 显示View
     * @param viewGroup view的容器
     * @param viewType view的显示类型
     */
    public final void showView(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
    }
    
    /**
     * 关闭View
     * @param viewGroup view的容器
     * @param viewType view的显示类型
     */
    public final void hideView(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
    }
    
    public OverlayViewUtils() {
        super();
    }
}