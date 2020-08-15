package com.sunny.zy.http.parser;

import java.lang.System;

/**
 * Desc 数据解析
 * Author ZhangYe
 * Mail zhangye98@foxmail.com
 * Date 2020/4/29 14:47
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/sunny/zy/http/parser/IResponseParser;", "", "parserResponse", "T", "responseBody", "Lokhttp3/ResponseBody;", "type", "Ljava/lang/reflect/Type;", "serializedName", "", "(Lokhttp3/ResponseBody;Ljava/lang/reflect/Type;Ljava/lang/String;)Ljava/lang/Object;", "zyframe_debug"})
public abstract interface IResponseParser {
    
    public abstract <T extends java.lang.Object>T parserResponse(@org.jetbrains.annotations.NotNull()
    okhttp3.ResponseBody responseBody, @org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type type, @org.jetbrains.annotations.Nullable()
    java.lang.String serializedName);
    
    /**
     * Desc 数据解析
     * Author ZhangYe
     * Mail zhangye98@foxmail.com
     * Date 2020/4/29 14:47
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}