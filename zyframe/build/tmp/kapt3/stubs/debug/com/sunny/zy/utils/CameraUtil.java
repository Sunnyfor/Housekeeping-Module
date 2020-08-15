package com.sunny.zy.utils;

import java.lang.System;

/**
 * Desc 相机相册工具类
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020年3月4日 11:56:34
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\u001d\u001a\u00020\u001aJ \u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"J\u0016\u0010#\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010$\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/sunny/zy/utils/CameraUtil;", "", "activity", "Lcom/sunny/zy/base/BaseActivity;", "(Lcom/sunny/zy/base/BaseActivity;)V", "aspectX", "", "aspectY", "cameraType", "file", "Ljava/io/File;", "isCrop", "", "onResultListener", "Lcom/sunny/zy/utils/CameraUtil$OnResultListener;", "getOnResultListener", "()Lcom/sunny/zy/utils/CameraUtil$OnResultListener;", "setOnResultListener", "(Lcom/sunny/zy/utils/CameraUtil$OnResultListener;)V", "outputX", "outputY", "photoType", "type", "uri", "Landroid/net/Uri;", "initFile", "", "intentCamera", "intentPhoto", "intentPhotoAndCrop", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "setAspectXY", "setOutputXY", "startPhotoZoom", "mUri", "OnResultListener", "zyframe_debug"})
public final class CameraUtil {
    @org.jetbrains.annotations.Nullable()
    private com.sunny.zy.utils.CameraUtil.OnResultListener onResultListener;
    private final int photoType = 100;
    private boolean isCrop = false;
    private final int cameraType = 102;
    private java.io.File file;
    private android.net.Uri uri;
    private int type;
    private int aspectX = 1;
    private int aspectY = 1;
    private int outputX = 150;
    private int outputY = 150;
    private com.sunny.zy.base.BaseActivity activity;
    
    @org.jetbrains.annotations.Nullable()
    public final com.sunny.zy.utils.CameraUtil.OnResultListener getOnResultListener() {
        return null;
    }
    
    public final void setOnResultListener(@org.jetbrains.annotations.Nullable()
    com.sunny.zy.utils.CameraUtil.OnResultListener p0) {
    }
    
    public final void intentCamera() {
    }
    
    private final void intentPhoto(boolean isCrop) {
    }
    
    public final void intentPhoto() {
    }
    
    public final void intentPhotoAndCrop() {
    }
    
    /**
     * 结果回调需要在Activity回调中调用
     */
    public final void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void startPhotoZoom(android.net.Uri mUri) {
    }
    
    public final void setAspectXY(int aspectX, int aspectY) {
    }
    
    public final void setOutputXY(int outputX, int outputY) {
    }
    
    private final void initFile() {
    }
    
    public CameraUtil(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.base.BaseActivity activity) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/sunny/zy/utils/CameraUtil$OnResultListener;", "", "onResult", "", "file", "Ljava/io/File;", "zyframe_debug"})
    public static abstract interface OnResultListener {
        
        public abstract void onResult(@org.jetbrains.annotations.NotNull()
        java.io.File file);
    }
}