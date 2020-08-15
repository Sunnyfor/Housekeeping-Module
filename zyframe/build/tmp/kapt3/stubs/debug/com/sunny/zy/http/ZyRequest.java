package com.sunny.zy.http;

import java.lang.System;

/**
 * Desc
 * Author ZhangYe
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/4/29 12:22
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J6\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\rJ\u0014\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J6\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\rJ6\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\rJ\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/sunny/zy/http/ZyRequest;", "", "()V", "deleteJsonRequest", "Lokhttp3/Request;", "url", "", "json", "formUploadRequest", "filePath", "getRequest", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getUrlSb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "patchFormRequest", "postFormRequest", "postJsonRequest", "zyframe_debug"})
public final class ZyRequest {
    
    private final java.lang.StringBuilder getUrlSb(java.lang.String url) {
        return null;
    }
    
    /**
     * GET请求生成
     */
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.Request getRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.util.HashMap<java.lang.String, java.lang.String> params) {
        return null;
    }
    
    /**
     * POST-JSON请求生成
     */
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.Request postJsonRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String json) {
        return null;
    }
    
    /**
     * POST-FORM请求生成
     */
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.Request postFormRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.util.HashMap<java.lang.String, java.lang.String> params) {
        return null;
    }
    
    /**
     * PATCH-Form请求生成
     */
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.Request patchFormRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.util.HashMap<java.lang.String, java.lang.String> params) {
        return null;
    }
    
    /**
     * DELETE请求
     */
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.Request deleteJsonRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String json) {
        return null;
    }
    
    /**
     * FORM形式上传文件
     */
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.Request formUploadRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return null;
    }
    
    public ZyRequest() {
        super();
    }
}