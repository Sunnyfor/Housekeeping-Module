package com.sunny.zy.http.bean;

import java.lang.System;

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/4/29 12:37
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0005\u00a8\u0006\u0018"}, d2 = {"Lcom/sunny/zy/http/bean/HttpResultBean;", "T", "Lcom/sunny/zy/http/bean/BaseHttpResultBean;", "serializedName", "", "(Ljava/lang/String;)V", "bean", "getBean", "()Ljava/lang/Object;", "setBean", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "msg", "getMsg", "()Ljava/lang/String;", "setMsg", "getSerializedName", "setSerializedName", "isSuccess", "", "notifyData", "", "baseHttpResultBean", "toString", "zyframe_debug"})
public abstract class HttpResultBean<T extends java.lang.Object> extends com.sunny.zy.http.bean.BaseHttpResultBean<T> {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String msg = "OK";
    @org.jetbrains.annotations.Nullable()
    private T bean;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String serializedName;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsg() {
        return null;
    }
    
    public final void setMsg(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T getBean() {
        return null;
    }
    
    public final void setBean(@org.jetbrains.annotations.Nullable()
    T p0) {
    }
    
    public final boolean isSuccess() {
        return false;
    }
    
    @java.lang.Override()
    public void notifyData(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.bean.BaseHttpResultBean<T> baseHttpResultBean) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSerializedName() {
        return null;
    }
    
    public final void setSerializedName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public HttpResultBean(@org.jetbrains.annotations.NotNull()
    java.lang.String serializedName) {
        super();
    }
    
    public HttpResultBean() {
        super();
    }
}