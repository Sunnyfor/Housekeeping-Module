package com.sunny.zy.base;

import java.lang.System;

/**
 * Created by ZhangYe on 2018/8/2.
 */
@android.annotation.SuppressLint(value = {"SourceLockedOrientationActivity"})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\b\b\'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH&J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012H\u0002J\u000e\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00150\u0015J\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\nJ\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH&J\b\u0010\u001d\u001a\u00020\nH&J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H&J\u0012\u0010\"\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010#\u001a\u00020\nH\u0014J\"\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u0003J\b\u0010(\u001a\u00020&H&J\u001f\u0010)\u001a\u00020\n2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0+\"\u00020 \u00a2\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\nJ\u0010\u0010.\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\u0010\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u000eH\u0016J\u000e\u00102\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/sunny/zy/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/sunny/zy/base/IBaseView;", "Landroid/view/View$OnClickListener;", "()V", "overlayViewBean", "Lcom/sunny/zy/widget/utils/OverlayViewUtils;", "savedInstanceState", "Landroid/os/Bundle;", "close", "", "defaultTitle", "Landroidx/appcompat/widget/Toolbar;", "title", "", "getFrameBody", "Landroid/widget/FrameLayout;", "getRightImageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getTitleView", "Landroid/widget/TextView;", "getToolBar", "hideError", "errorType", "Lcom/sunny/zy/base/ErrorViewType;", "hideKeyboard", "hideLoading", "initView", "loadData", "onClick", "view", "Landroid/view/View;", "onClickEvent", "onCreate", "onDestroy", "rightTitle", "res", "", "onClickListener", "setLayout", "setOnClickListener", "views", "", "([Landroid/view/View;)V", "setSupportActionBar", "showError", "showLoading", "showMessage", "message", "simpleTitle", "zyframe_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity implements com.sunny.zy.base.IBaseView, android.view.View.OnClickListener {
    private android.os.Bundle savedInstanceState;
    private final com.sunny.zy.widget.utils.OverlayViewUtils overlayViewBean = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 设置布局操作
     */
    public abstract int setLayout();
    
    /**
     * 初始化View操作
     */
    public abstract void initView();
    
    /**
     * 加载数据操作
     */
    public abstract void loadData();
    
    /**
     * 点击事件回调
     */
    public abstract void onClickEvent(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void close();
    
    /**
     * 获取title容器
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.Toolbar getToolBar() {
        return null;
    }
    
    public final android.widget.TextView getTitleView() {
        return null;
    }
    
    /**
     * 获取body容器
     */
    @org.jetbrains.annotations.NotNull()
    public final android.widget.FrameLayout getFrameBody() {
        return null;
    }
    
    public final void setSupportActionBar() {
    }
    
    /**
     * 显示loading覆盖层
     */
    @java.lang.Override()
    public void showLoading() {
    }
    
    /**
     * 隐藏loading覆盖层
     */
    @java.lang.Override()
    public void hideLoading() {
    }
    
    /**
     * 显示error覆盖层
     */
    @java.lang.Override()
    public void showError(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.base.ErrorViewType errorType) {
    }
    
    /**
     * 隐藏error覆盖层
     */
    @java.lang.Override()
    public void hideError(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.base.ErrorViewType errorType) {
    }
    
    /**
     * 显示Toast
     */
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * 批量注册点击事件
     * @param views 注册事件的View
     */
    public final void setOnClickListener(@org.jetbrains.annotations.NotNull()
    android.view.View... views) {
    }
    
    /**
     * 点击事件处理
     */
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    /**
     * 只有文字标题的toolbar
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.Toolbar simpleTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    /**
     * 带返回键的toolbar
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.Toolbar defaultTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.Toolbar rightTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title, int res, @org.jetbrains.annotations.Nullable()
    android.view.View.OnClickListener onClickListener) {
        return null;
    }
    
    private final android.widget.ImageView getRightImageView() {
        return null;
    }
    
    /**
     * 隐藏输入法键盘
     */
    public final void hideKeyboard() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public BaseActivity() {
        super();
    }
}