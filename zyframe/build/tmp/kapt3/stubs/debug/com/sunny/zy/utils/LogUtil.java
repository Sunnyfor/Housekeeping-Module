package com.sunny.zy.utils;

import java.lang.System;

/**
 * 移植xUtils日志代码
 * Created by 张野 on 2017/10/12.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/sunny/zy/utils/LogUtil;", "", "()V", "allowD", "", "allowE", "allowI", "allowV", "allowW", "allowWtf", "customLogger", "Lcom/sunny/zy/utils/LogUtil$CustomLogger;", "customTagPrefix", "", "d", "", "content", "tr", "", "e", "generateTag", "caller", "Ljava/lang/StackTraceElement;", "getCallerStackTraceElement", "i", "v", "w", "wtf", "CustomLogger", "zyframe_debug"})
public final class LogUtil {
    private static java.lang.String customTagPrefix = "";
    private static boolean allowD;
    private static boolean allowE;
    private static boolean allowI;
    private static boolean allowV;
    private static boolean allowW;
    private static boolean allowWtf;
    private static com.sunny.zy.utils.LogUtil.CustomLogger customLogger;
    public static final com.sunny.zy.utils.LogUtil INSTANCE = null;
    
    public final void d(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void d(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable tr) {
    }
    
    public final void e(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void e(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable tr) {
    }
    
    public final void i(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void i(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable tr) {
    }
    
    public final void v(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void v(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable tr) {
    }
    
    public final void w(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void w(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable tr) {
    }
    
    public final void w(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable tr) {
    }
    
    public final void wtf(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void wtf(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable tr) {
    }
    
    public final void wtf(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable tr) {
    }
    
    private final java.lang.String generateTag(java.lang.StackTraceElement caller) {
        return null;
    }
    
    private final java.lang.StackTraceElement getCallerStackTraceElement() {
        return null;
    }
    
    private LogUtil() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/sunny/zy/utils/LogUtil$CustomLogger;", "", "d", "", "var1", "", "var2", "var3", "", "e", "i", "v", "w", "wtf", "zyframe_debug"})
    public static abstract interface CustomLogger {
        
        public abstract void d(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2);
        
        public abstract void d(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable var3);
        
        public abstract void e(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2);
        
        public abstract void e(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable var3);
        
        public abstract void i(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2);
        
        public abstract void i(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable var3);
        
        public abstract void v(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2);
        
        public abstract void v(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable var3);
        
        public abstract void w(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2);
        
        public abstract void w(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable var3);
        
        public abstract void w(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable var2);
        
        public abstract void wtf(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2);
        
        public abstract void wtf(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.String var2, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable var3);
        
        public abstract void wtf(@org.jetbrains.annotations.NotNull()
        java.lang.String var1, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable var2);
    }
}