package com.sunny.zy.widget;

import java.lang.System;

/**
 * Desc 下拉刷新
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/11/7 23:24
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014J\u0006\u0010$\u001a\u00020 R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/sunny/zy/widget/PullRefreshRecyclerLayout;", "Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emptyView", "Landroid/view/View;", "getEmptyView", "()Landroid/view/View;", "emptyView$delegate", "Lkotlin/Lazy;", "fmLayout", "Landroid/widget/FrameLayout;", "getFmLayout", "()Landroid/widget/FrameLayout;", "fmLayout$delegate", "isShowEmptyView", "", "()Z", "setShowEmptyView", "(Z)V", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "hideEmptyView", "", "setUnEnableRefreshAndLoad", "enableRefresh", "enableLoadMore", "showEmptyView", "zyframe_debug"})
public final class PullRefreshRecyclerLayout extends com.scwang.smart.refresh.layout.SmartRefreshLayout {
    private final kotlin.Lazy fmLayout$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy recyclerView$delegate = null;
    private final kotlin.Lazy emptyView$delegate = null;
    private final android.widget.FrameLayout.LayoutParams layoutParams = null;
    private boolean isShowEmptyView = true;
    private java.util.HashMap _$_findViewCache;
    
    private final android.widget.FrameLayout getFmLayout() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    private final android.view.View getEmptyView() {
        return null;
    }
    
    public final boolean isShowEmptyView() {
        return false;
    }
    
    public final void setShowEmptyView(boolean p0) {
    }
    
    /**
     * 禁止刷新和加载数据
     */
    public final void setUnEnableRefreshAndLoad(boolean enableRefresh, boolean enableLoadMore) {
    }
    
    public final void showEmptyView() {
    }
    
    public final void hideEmptyView() {
    }
    
    public PullRefreshRecyclerLayout(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
    
    public PullRefreshRecyclerLayout(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
}