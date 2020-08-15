package com.sunny.zy.base;

import java.lang.System;

/**
 * baseAdapter
 * Created by zhangye on 2018/1/5.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\u0019\u001a\u00020\u00182\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006J\u0006\u0010\u001b\u001a\u00020\u0018J\u0013\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001eJ\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J\u0013\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0016H\u0016J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0016H\u0016J\u0018\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0016H&J>\u0010)\u001a\u00020\u001826\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R@\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/sunny/zy/base/BaseRecycleAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sunny/zy/base/BaseRecycleViewHolder;", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isDouble", "", "onItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "position", "", "addData", "arrayList", "clearData", "deleteData", "data", "(Ljava/lang/Object;)V", "getData", "(I)Ljava/lang/Object;", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setLayout", "setOnItemClickListener", "zyframe_debug"})
public abstract class BaseRecycleAdapter<T extends java.lang.Object> extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sunny.zy.base.BaseRecycleViewHolder> {
    private boolean isDouble = false;
    private kotlin.jvm.functions.Function2<? super android.view.View, ? super java.lang.Integer, kotlin.Unit> onItemClickListener;
    @org.jetbrains.annotations.NotNull()
    public android.content.Context context;
    private java.util.ArrayList<T> list;
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.sunny.zy.base.BaseRecycleViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public abstract void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.base.BaseRecycleViewHolder holder, int position);
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.view.View setLayout(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType);
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<T> getData() {
        return null;
    }
    
    public final T getData(int position) {
        return null;
    }
    
    public final void addData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<T> arrayList) {
    }
    
    public final void deleteData(int position) {
    }
    
    public final void deleteData(T data) {
    }
    
    public final void clearData() {
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super android.view.View, ? super java.lang.Integer, kotlin.Unit> onItemClickListener) {
    }
    
    public BaseRecycleAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<T> list) {
        super();
    }
}