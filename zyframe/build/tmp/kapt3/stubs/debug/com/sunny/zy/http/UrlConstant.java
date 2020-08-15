package com.sunny.zy.http;

import java.lang.System;

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/2 16:47
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/sunny/zy/http/UrlConstant;", "", "()V", "APP_VERSION_UPDATE_URL", "", "HOST", "IMAGE_URL", "IP", "PORT", "STS_UPLOAD", "SYS_LOGIN", "TEMP", "getTEMP", "()Ljava/lang/String;", "zyframe_debug"})
public final class UrlConstant {
    private static final java.lang.String IP = "10.0.0.153";
    private static final java.lang.String PORT = "8807";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOST = "https://10.0.0.153:8807";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMAGE_URL = "/sys/sysfujian/download?attID=";
    @org.jetbrains.annotations.Nullable()
    private static final java.lang.String TEMP = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SYS_LOGIN = "sys/login";
    
    /**
     * 检查版本更新
     * versionNumber=1.0.0.1
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String APP_VERSION_UPDATE_URL = "app/appandroidversion/findNewOne";
    
    /**
     * 文件上传
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STS_UPLOAD = "sys/sysfujian/upload";
    public static final com.sunny.zy.http.UrlConstant INSTANCE = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTEMP() {
        return null;
    }
    
    private UrlConstant() {
        super();
    }
}