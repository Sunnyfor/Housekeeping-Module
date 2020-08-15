package com.sunny.zy.base;

import java.lang.System;

/**
 * Presenter父类
 * Created by zhangye on 2018/8/2.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015R\u0012\u0010\u0006\u001a\u00020\u0007X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005\u00a8\u0006\u0018"}, d2 = {"Lcom/sunny/zy/base/BasePresenter;", "T", "Lcom/sunny/zy/base/IBaseView;", "Lkotlinx/coroutines/CoroutineScope;", "view", "(Lcom/sunny/zy/base/IBaseView;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getView", "()Lcom/sunny/zy/base/IBaseView;", "setView", "Lcom/sunny/zy/base/IBaseView;", "hideError", "", "hideLoading", "showError", "code", "", "message", "", "showLoading", "showMessage", "zyframe_debug"})
public abstract class BasePresenter<T extends com.sunny.zy.base.IBaseView> implements kotlinx.coroutines.CoroutineScope {
    @org.jetbrains.annotations.Nullable()
    private T view;
    
    public final void showError(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void hideError() {
    }
    
    public final void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void showLoading() {
    }
    
    public final void hideLoading() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T getView() {
        return null;
    }
    
    public final void setView(@org.jetbrains.annotations.Nullable()
    T p0) {
    }
    
    public BasePresenter(@org.jetbrains.annotations.Nullable()
    T view) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
}