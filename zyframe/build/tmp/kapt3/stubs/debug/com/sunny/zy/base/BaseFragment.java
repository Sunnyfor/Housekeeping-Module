package com.sunny.zy.base;

import java.lang.System;

/**
 * Created by zhangye on 2018/8/2.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H&J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H&J\b\u0010\u001a\u001a\u00020\u0012H&J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0006H&J&\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010&\u001a\u00020\'H&J\u000e\u0010(\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0006J+\u0010)\u001a\u00020\u00122\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060+\"\u00020\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/sunny/zy/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/sunny/zy/base/IBaseView;", "Landroid/view/View$OnClickListener;", "()V", "bodyView", "Landroid/view/View;", "getBodyView", "()Landroid/view/View;", "setBodyView", "(Landroid/view/View;)V", "overlayViewBean", "Lcom/sunny/zy/widget/utils/OverlayViewUtils;", "rootView", "Landroid/widget/FrameLayout;", "savedInstanceState", "Landroid/os/Bundle;", "close", "", "getBaseActivity", "Lcom/sunny/zy/base/BaseActivity;", "hideError", "errorType", "Lcom/sunny/zy/base/ErrorViewType;", "hideLoading", "initView", "loadData", "onClick", "v", "onClickEvent", "view", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "setLayout", "", "setLayoutView", "setOnClickListener", "views", "", "onClickListener", "([Landroid/view/View;Landroid/view/View$OnClickListener;)V", "showError", "showLoading", "showMessage", "message", "", "zyframe_debug"})
public abstract class BaseFragment extends androidx.fragment.app.Fragment implements com.sunny.zy.base.IBaseView, android.view.View.OnClickListener {
    private android.os.Bundle savedInstanceState;
    private final com.sunny.zy.widget.utils.OverlayViewUtils overlayViewBean = null;
    private android.widget.FrameLayout rootView;
    @org.jetbrains.annotations.Nullable()
    private android.view.View bodyView;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getBodyView() {
        return null;
    }
    
    public final void setBodyView(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunny.zy.base.BaseActivity getBaseActivity() {
        return null;
    }
    
    /**
     * 批量注册点击事件
     * @param views 注册事件的View
     */
    public final void setOnClickListener(@org.jetbrains.annotations.NotNull()
    android.view.View[] views, @org.jetbrains.annotations.Nullable()
    android.view.View.OnClickListener onClickListener) {
    }
    
    public abstract int setLayout();
    
    public abstract void initView();
    
    public abstract void onClickEvent(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    public abstract void loadData();
    
    public final void setLayoutView(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void showLoading() {
    }
    
    @java.lang.Override()
    public void hideLoading() {
    }
    
    @java.lang.Override()
    public void showError(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.base.ErrorViewType errorType) {
    }
    
    @java.lang.Override()
    public void hideError(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.base.ErrorViewType errorType) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    public abstract void close();
    
    public BaseFragment() {
        super();
    }
}