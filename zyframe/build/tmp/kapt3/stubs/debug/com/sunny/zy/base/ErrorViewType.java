package com.sunny.zy.base;

import java.lang.System;

/**
 * 错误View的类型枚举
 * Created by zhangye on 2018/8/2.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/sunny/zy/base/ErrorViewType;", "", "errorCode", "", "errorMessage", "", "errorIcon", "(ILjava/lang/String;I)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getErrorIcon", "setErrorIcon", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "zyframe_debug"})
public final class ErrorViewType {
    private int errorCode;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String errorMessage;
    private int errorIcon;
    public static final int loading = 10000;
    public static final int emptyData = 10001;
    public static final int networkError = 10001;
    public static final com.sunny.zy.base.ErrorViewType.Companion Companion = null;
    
    public final int getErrorCode() {
        return 0;
    }
    
    public final void setErrorCode(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    public final void setErrorMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getErrorIcon() {
        return 0;
    }
    
    public final void setErrorIcon(int p0) {
    }
    
    public ErrorViewType(int errorCode, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMessage, int errorIcon) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    /**
     * 错误View的类型枚举
     * Created by zhangye on 2018/8/2.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.sunny.zy.base.ErrorViewType copy(int errorCode, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMessage, int errorIcon) {
        return null;
    }
    
    /**
     * 错误View的类型枚举
     * Created by zhangye on 2018/8/2.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 错误View的类型枚举
     * Created by zhangye on 2018/8/2.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 错误View的类型枚举
     * Created by zhangye on 2018/8/2.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/sunny/zy/base/ErrorViewType$Companion;", "", "()V", "emptyData", "", "loading", "networkError", "zyframe_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}