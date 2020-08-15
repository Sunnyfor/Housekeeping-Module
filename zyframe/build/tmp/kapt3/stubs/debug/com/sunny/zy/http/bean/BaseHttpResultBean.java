package com.sunny.zy.http.bean;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010,\u001a\u00020\u000bJ\u0016\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\b\u00100\u001a\u00020\'H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/sunny/zy/http/bean/BaseHttpResultBean;", "T", "", "()V", "contentLength", "", "getContentLength", "()J", "setContentLength", "(J)V", "done", "", "getDone", "()Z", "setDone", "(Z)V", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "httpCode", "", "getHttpCode", "()I", "setHttpCode", "(I)V", "readLength", "getReadLength", "setReadLength", "typeToken", "Ljava/lang/reflect/Type;", "getTypeToken", "()Ljava/lang/reflect/Type;", "setTypeToken", "(Ljava/lang/reflect/Type;)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "httpIsSuccess", "notifyData", "", "baseHttpResultBean", "toString", "zyframe_debug"})
public abstract class BaseHttpResultBean<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.reflect.Type typeToken;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String url = "";
    private int httpCode = 0;
    private long contentLength = 0L;
    private long readLength = 0L;
    private boolean done = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Exception exception;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.reflect.Type getTypeToken() {
        return null;
    }
    
    public final void setTypeToken(@org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final void setUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getHttpCode() {
        return 0;
    }
    
    public final void setHttpCode(int p0) {
    }
    
    public final long getContentLength() {
        return 0L;
    }
    
    public final void setContentLength(long p0) {
    }
    
    public final long getReadLength() {
        return 0L;
    }
    
    public final void setReadLength(long p0) {
    }
    
    public final boolean getDone() {
        return false;
    }
    
    public final void setDone(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Exception getException() {
        return null;
    }
    
    public final void setException(@org.jetbrains.annotations.Nullable()
    java.lang.Exception p0) {
    }
    
    public final boolean httpIsSuccess() {
        return false;
    }
    
    public abstract void notifyData(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.bean.BaseHttpResultBean<T> baseHttpResultBean);
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public BaseHttpResultBean() {
        super();
    }
}