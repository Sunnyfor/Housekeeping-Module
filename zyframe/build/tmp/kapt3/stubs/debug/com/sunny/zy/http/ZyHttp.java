package com.sunny.zy.http;

import java.lang.System;

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/4/28 02:07
 */
@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J5\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0002J5\u0010\u0013\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJW\u0010\u0015\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00182\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eJU\u0010\u001c\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00182\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019JU\u0010\u001d\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00182\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J5\u0010\u001e\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/sunny/zy/http/ZyHttp;", "", "()V", "iResponseParser", "Lcom/sunny/zy/http/parser/IResponseParser;", "zyRequest", "Lcom/sunny/zy/http/ZyRequest;", "deleteJson", "", "T", "url", "", "json", "httpResultBean", "Lcom/sunny/zy/http/bean/HttpResultBean;", "(Ljava/lang/String;Ljava/lang/String;Lcom/sunny/zy/http/bean/HttpResultBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execution", "request", "Lokhttp3/Request;", "formUpload", "filePath", "get", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/util/HashMap;Lcom/sunny/zy/http/bean/HttpResultBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOkHttpClient", "Lokhttp3/OkHttpClient;", "patch", "post", "postJson", "zyframe_debug"})
public final class ZyHttp {
    private static com.sunny.zy.http.ZyRequest zyRequest;
    private static com.sunny.zy.http.parser.IResponseParser iResponseParser;
    public static final com.sunny.zy.http.ZyHttp INSTANCE = null;
    
    /**
     * 初始化OKHttp
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>okhttp3.OkHttpClient getOkHttpClient(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.bean.HttpResultBean<T> httpResultBean) {
        return null;
    }
    
    /**
     * get请求
     * @param url URL服务器地址
     * @param params 传递的数据map（key,value)
     * @param onResult 解析类型 例如为String::class.java
     * @return HttpResultBean<clazz> 网络请求结果
     */
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>java.lang.Object get(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.util.HashMap<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.bean.HttpResultBean<T> httpResultBean, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    /**
     * postForm请求
     * @param url URL服务器地址
     * @param params 传递的数据map（key,value)
     * @param clazz 解析类型 例如为String::class.java
     * @return HttpResultBean<clazz> 网络请求结果
     */
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>java.lang.Object post(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.util.HashMap<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.bean.HttpResultBean<T> httpResultBean, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>java.lang.Object patch(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.util.HashMap<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.bean.HttpResultBean<T> httpResultBean, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    /**
     * post传递JSON请求
     * @param url URL服务器地址
     * @param json 传递的json字符串
     * @param clazz 解析类型 例如为String::class.java
     * @return HttpResultBean<clazz> 网络请求结果
     */
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>java.lang.Object postJson(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String json, @org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.bean.HttpResultBean<T> httpResultBean, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>java.lang.Object deleteJson(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String json, @org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.bean.HttpResultBean<T> httpResultBean, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>java.lang.Object formUpload(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath, @org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.bean.HttpResultBean<T> httpResultBean, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    /**
     * 执行网络请求并处理结果
     * @param request OkHttp请求对象
     * @param onResult 网络请求回调
     * @return HttpResultBean<clazz> 网络请求结果
     */
    private final <T extends java.lang.Object>void execution(okhttp3.Request request, com.sunny.zy.http.bean.HttpResultBean<T> httpResultBean) {
    }
    
    private ZyHttp() {
        super();
    }
}