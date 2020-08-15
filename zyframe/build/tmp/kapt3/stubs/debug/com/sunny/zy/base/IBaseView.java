package com.sunny.zy.base;

import java.lang.System;

/**
 * Created by zhangye on 2018/8/2.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/sunny/zy/base/IBaseView;", "", "hideError", "", "errorType", "Lcom/sunny/zy/base/ErrorViewType;", "hideLoading", "showError", "showLoading", "showMessage", "message", "", "zyframe_debug"})
public abstract interface IBaseView {
    
    public abstract void showLoading();
    
    public abstract void hideLoading();
    
    public abstract void showError(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.base.ErrorViewType errorType);
    
    public abstract void hideError(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.base.ErrorViewType errorType);
    
    public abstract void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message);
}