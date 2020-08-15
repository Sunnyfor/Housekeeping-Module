package com.sunny.zy.http;

import java.lang.System;

/**
 * 接口配置清单
 * Created by zhangye on 2017/10/12.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/sunny/zy/http/Constant;", "", "()V", "VERSION", "", "authorities", "host", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "isLog", "", "()Z", "setLog", "(Z)V", "isDebug", "zyframe_debug"})
public final class Constant {
    private static boolean isLog = true;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String host = "";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String authorities = "com.zhkj.housekeeping.provider";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VERSION = "v1";
    public static final com.sunny.zy.http.Constant INSTANCE = null;
    
    public final boolean isDebug() {
        return false;
    }
    
    public final boolean isLog() {
        return false;
    }
    
    public final void setLog(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHost() {
        return null;
    }
    
    public final void setHost(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private Constant() {
        super();
    }
}