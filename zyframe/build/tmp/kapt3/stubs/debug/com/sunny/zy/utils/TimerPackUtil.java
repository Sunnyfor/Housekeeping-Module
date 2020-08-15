package com.sunny.zy.utils;

import java.lang.System;

/**
 * Desc 调取系统日期
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2019/11/1 15:33
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0015H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/sunny/zy/utils/TimerPackUtil;", "", "()V", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "timeSb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "showCurrentTime", "", "showDateAndTimePack", "", "context", "Landroid/content/Context;", "view", "Landroid/widget/TextView;", "onTimePackResult", "Lcom/sunny/zy/utils/TimerPackUtil$OnTimePackResult;", "showDatePack", "isResult", "", "showTimePack", "isClear", "OnTimePackResult", "zyframe_debug"})
public final class TimerPackUtil {
    private static final java.lang.StringBuilder timeSb = null;
    private static final java.util.Calendar calendar = null;
    public static final com.sunny.zy.utils.TimerPackUtil INSTANCE = null;
    
    private final void showDatePack(android.content.Context context, com.sunny.zy.utils.TimerPackUtil.OnTimePackResult onTimePackResult, boolean isResult) {
    }
    
    public final void showDatePack(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.sunny.zy.utils.TimerPackUtil.OnTimePackResult onTimePackResult) {
    }
    
    private final void showTimePack(android.content.Context context, com.sunny.zy.utils.TimerPackUtil.OnTimePackResult onTimePackResult, boolean isClear) {
    }
    
    public final void showTimePack(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.sunny.zy.utils.TimerPackUtil.OnTimePackResult onTimePackResult) {
    }
    
    public final void showDateAndTimePack(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.sunny.zy.utils.TimerPackUtil.OnTimePackResult onTimePackResult) {
    }
    
    /**
     * 选择时间并给相应的组件设置时间
     */
    public final void showDateAndTimePack(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.TextView view) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String showCurrentTime() {
        return null;
    }
    
    private TimerPackUtil() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/sunny/zy/utils/TimerPackUtil$OnTimePackResult;", "", "onSelect", "", "timeStr", "", "zyframe_debug"})
    public static abstract interface OnTimePackResult {
        
        public abstract void onSelect(@org.jetbrains.annotations.NotNull()
        java.lang.String timeStr);
    }
}