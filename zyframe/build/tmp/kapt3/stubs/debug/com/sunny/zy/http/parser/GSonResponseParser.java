package com.sunny.zy.http.parser;

import java.lang.System;

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/4/29 14:51
 */
@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/sunny/zy/http/parser/GSonResponseParser;", "Lcom/sunny/zy/http/parser/IResponseParser;", "()V", "mGSon", "Lcom/google/gson/Gson;", "parserResponse", "T", "responseBody", "Lokhttp3/ResponseBody;", "type", "Ljava/lang/reflect/Type;", "serializedName", "", "(Lokhttp3/ResponseBody;Ljava/lang/reflect/Type;Ljava/lang/String;)Ljava/lang/Object;", "writeResponseBodyToDisk", "Ljava/io/File;", "data", "Ljava/io/InputStream;", "zyframe_debug"})
public final class GSonResponseParser implements com.sunny.zy.http.parser.IResponseParser {
    private final com.google.gson.Gson mGSon = null;
    
    @java.lang.Override()
    public <T extends java.lang.Object>T parserResponse(@org.jetbrains.annotations.NotNull()
    okhttp3.ResponseBody responseBody, @org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type type, @org.jetbrains.annotations.Nullable()
    java.lang.String serializedName) {
        return null;
    }
    
    private final java.io.File writeResponseBodyToDisk(java.io.InputStream data, java.lang.String serializedName) {
        return null;
    }
    
    public GSonResponseParser() {
        super();
    }
}