package com.sunny.zy.widget.edittext;

import java.lang.System;

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/4 18:35
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J*\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0006\u0010\u0018\u001a\u00020\u000fJ\u001a\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0006\u0010\"\u001a\u00020\u000fJ\u0010\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0016\u001a\u00020\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/sunny/zy/widget/edittext/ClearEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/view/View$OnFocusChangeListener;", "Landroid/text/TextWatcher;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "hasFocus", "", "mClearDrawable", "Landroid/graphics/drawable/Drawable;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "init", "onFocusChange", "v", "Landroid/view/View;", "onTextChanged", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setClearIconVisible", "visible", "setShakeAnimation", "shakeAnimation", "Landroid/view/animation/Animation;", "zyframe_debug"})
public final class ClearEditText extends androidx.appcompat.widget.AppCompatEditText implements android.view.View.OnFocusChangeListener, android.text.TextWatcher {
    
    /**
     * 删除按钮的引用
     */
    private android.graphics.drawable.Drawable mClearDrawable;
    
    /**
     * 控件是否有焦点
     */
    private boolean hasFocus = false;
    private java.util.HashMap _$_findViewCache;
    
    public final void init() {
    }
    
    /**
     * 因为我们不能直接给EditText设置点击事件，所以我们用记住我们按下的位置来模拟点击事件 当我们按下的位置 在 EditText的宽度 -
     * 图标到控件右边的间距 - 图标的宽度 和 EditText的宽度 - 图标到控件右边的间距之间我们就算点击了图标，竖直方向就没有考虑
     */
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    /**
     * 当ClearEditText焦点发生变化的时候，判断里面字符串长度设置清除图标的显示与隐藏
     */
    @java.lang.Override()
    public void onFocusChange(@org.jetbrains.annotations.Nullable()
    android.view.View v, boolean hasFocus) {
    }
    
    /**
     * 设置清除图标的显示与隐藏，调用setCompoundDrawables为EditText绘制上去
     */
    private final void setClearIconVisible(boolean visible) {
    }
    
    /**
     * 当输入框里面内容发生变化的时候回调的方法
     */
    @java.lang.Override()
    public void onTextChanged(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence s, int start, int count, int after) {
    }
    
    @java.lang.Override()
    public void beforeTextChanged(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence s, int start, int count, int after) {
    }
    
    @java.lang.Override()
    public void afterTextChanged(@org.jetbrains.annotations.Nullable()
    android.text.Editable s) {
    }
    
    /**
     * 设置晃动动画
     */
    public final void setShakeAnimation() {
    }
    
    /**
     * 晃动动画
     *
     * @param count 1秒钟晃动多少下
     */
    @org.jetbrains.annotations.Nullable()
    @kotlin.Suppress(names = {"MemberVisibilityCanBePrivate"})
    public final android.view.animation.Animation shakeAnimation(int count) {
        return null;
    }
    
    public ClearEditText(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
    
    public ClearEditText(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
}