package com.sunny.zy.utils;

import java.lang.System;

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/12 11:44
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/sunny/zy/utils/ZyCookieJar;", "Lokhttp3/CookieJar;", "()V", "cookieStore", "Ljava/util/HashMap;", "", "", "Lokhttp3/Cookie;", "loadForRequest", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "", "cookies", "zyframe_debug"})
public final class ZyCookieJar implements okhttp3.CookieJar {
    private final java.util.HashMap<java.lang.String, java.util.List<okhttp3.Cookie>> cookieStore = null;
    
    @java.lang.Override()
    public void saveFromResponse(@org.jetbrains.annotations.NotNull()
    okhttp3.HttpUrl url, @org.jetbrains.annotations.NotNull()
    java.util.List<okhttp3.Cookie> cookies) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<okhttp3.Cookie> loadForRequest(@org.jetbrains.annotations.NotNull()
    okhttp3.HttpUrl url) {
        return null;
    }
    
    public ZyCookieJar() {
        super();
    }
}