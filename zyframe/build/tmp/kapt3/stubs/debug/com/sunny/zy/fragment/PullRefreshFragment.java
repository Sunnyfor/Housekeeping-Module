package com.sunny.zy.fragment;

import java.lang.System;

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/4 16:05
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001e\u0010.\u001a\u00020\u001d2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00028\u000000j\b\u0012\u0004\u0012\u00028\u0000`1J\b\u00102\u001a\u00020\u001dH\u0016J\u0013\u00103\u001a\u00020\u001d2\u0006\u0010/\u001a\u00028\u0000\u00a2\u0006\u0002\u00104J\u000e\u00103\u001a\u00020\u001d2\u0006\u00105\u001a\u00020#J\u000e\u00106\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000100J\b\u00107\u001a\u00020\u001dH\u0016J\b\u0010\u001b\u001a\u00020\u001dH\u0016J\u0010\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020#H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+\u00a8\u0006<"}, d2 = {"Lcom/sunny/zy/fragment/PullRefreshFragment;", "T", "Lcom/sunny/zy/base/BaseFragment;", "()V", "adapter", "Lcom/sunny/zy/base/BaseRecycleAdapter;", "getAdapter", "()Lcom/sunny/zy/base/BaseRecycleAdapter;", "setAdapter", "(Lcom/sunny/zy/base/BaseRecycleAdapter;)V", "enableLoadMore", "", "getEnableLoadMore", "()Z", "setEnableLoadMore", "(Z)V", "enableRefresh", "getEnableRefresh", "setEnableRefresh", "isShowEmptyView", "setShowEmptyView", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "loadData", "Lkotlin/Function0;", "", "getLoadData", "()Lkotlin/jvm/functions/Function0;", "setLoadData", "(Lkotlin/jvm/functions/Function0;)V", "page", "", "getPage", "()I", "setPage", "(I)V", "pullRefreshLayout", "Lcom/sunny/zy/widget/PullRefreshRecyclerLayout;", "getPullRefreshLayout", "()Lcom/sunny/zy/widget/PullRefreshRecyclerLayout;", "pullRefreshLayout$delegate", "Lkotlin/Lazy;", "addData", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "close", "deleteData", "(Ljava/lang/Object;)V", "index", "getAllData", "initView", "onClickEvent", "view", "Landroid/view/View;", "setLayout", "zyframe_debug"})
public class PullRefreshFragment<T extends java.lang.Object> extends com.sunny.zy.base.BaseFragment {
    @org.jetbrains.annotations.NotNull()
    private androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
    @org.jetbrains.annotations.Nullable()
    private com.sunny.zy.base.BaseRecycleAdapter<T> adapter;
    private int page = 1;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> loadData;
    private boolean enableRefresh = true;
    private boolean enableLoadMore = true;
    private boolean isShowEmptyView = true;
    private final kotlin.Lazy pullRefreshLayout$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView.LayoutManager getLayoutManager() {
        return null;
    }
    
    public final void setLayoutManager(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.LayoutManager p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.sunny.zy.base.BaseRecycleAdapter<T> getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable()
    com.sunny.zy.base.BaseRecycleAdapter<T> p0) {
    }
    
    public final int getPage() {
        return 0;
    }
    
    public final void setPage(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getLoadData() {
        return null;
    }
    
    public final void setLoadData(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    public final boolean getEnableRefresh() {
        return false;
    }
    
    public final void setEnableRefresh(boolean p0) {
    }
    
    public final boolean getEnableLoadMore() {
        return false;
    }
    
    public final void setEnableLoadMore(boolean p0) {
    }
    
    public final boolean isShowEmptyView() {
        return false;
    }
    
    public final void setShowEmptyView(boolean p0) {
    }
    
    private final com.sunny.zy.widget.PullRefreshRecyclerLayout getPullRefreshLayout() {
        return null;
    }
    
    @java.lang.Override()
    public int setLayout() {
        return 0;
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    @java.lang.Override()
    public void onClickEvent(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void loadData() {
    }
    
    @java.lang.Override()
    public void close() {
    }
    
    public final void addData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<T> data) {
    }
    
    public final void deleteData(int index) {
    }
    
    public final void deleteData(T data) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<T> getAllData() {
        return null;
    }
    
    public PullRefreshFragment() {
        super();
    }
}