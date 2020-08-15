package com.sunny.zy.http;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/sunny/zy/http/ProgressResponseBody;", "Lokhttp3/ResponseBody;", "responseBody", "progressListener", "Lcom/sunny/zy/http/ProgressResponseBody$ProgressResponseListener;", "(Lokhttp3/ResponseBody;Lcom/sunny/zy/http/ProgressResponseBody$ProgressResponseListener;)V", "bufferedSource", "Lokio/BufferedSource;", "getBufferedSource", "()Lokio/BufferedSource;", "setBufferedSource", "(Lokio/BufferedSource;)V", "getProgressListener", "()Lcom/sunny/zy/http/ProgressResponseBody$ProgressResponseListener;", "setProgressListener", "(Lcom/sunny/zy/http/ProgressResponseBody$ProgressResponseListener;)V", "getResponseBody", "()Lokhttp3/ResponseBody;", "setResponseBody", "(Lokhttp3/ResponseBody;)V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "Lokio/Source;", "ProgressResponseListener", "zyframe_debug"})
public final class ProgressResponseBody extends okhttp3.ResponseBody {
    @org.jetbrains.annotations.Nullable()
    private okio.BufferedSource bufferedSource;
    @org.jetbrains.annotations.Nullable()
    private okhttp3.ResponseBody responseBody;
    @org.jetbrains.annotations.NotNull()
    private com.sunny.zy.http.ProgressResponseBody.ProgressResponseListener progressListener;
    
    @org.jetbrains.annotations.Nullable()
    public final okio.BufferedSource getBufferedSource() {
        return null;
    }
    
    public final void setBufferedSource(@org.jetbrains.annotations.Nullable()
    okio.BufferedSource p0) {
    }
    
    @java.lang.Override()
    public long contentLength() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public okhttp3.MediaType contentType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okio.BufferedSource source() {
        return null;
    }
    
    private final okio.Source source(okio.Source source) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final okhttp3.ResponseBody getResponseBody() {
        return null;
    }
    
    public final void setResponseBody(@org.jetbrains.annotations.Nullable()
    okhttp3.ResponseBody p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunny.zy.http.ProgressResponseBody.ProgressResponseListener getProgressListener() {
        return null;
    }
    
    public final void setProgressListener(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.ProgressResponseBody.ProgressResponseListener p0) {
    }
    
    public ProgressResponseBody(@org.jetbrains.annotations.Nullable()
    okhttp3.ResponseBody responseBody, @org.jetbrains.annotations.NotNull()
    com.sunny.zy.http.ProgressResponseBody.ProgressResponseListener progressListener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/sunny/zy/http/ProgressResponseBody$ProgressResponseListener;", "", "onResponseProgress", "", "bytesRead", "", "contentLength", "done", "", "zyframe_debug"})
    public static abstract interface ProgressResponseListener {
        
        public abstract void onResponseProgress(long bytesRead, long contentLength, boolean done);
    }
}