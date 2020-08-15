package com.sunny.zy.contract;

import java.lang.System;

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/15 12:07
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/sunny/zy/contract/VersionUpdateContract;", "", "Presenter", "View", "zyframe_debug"})
public abstract interface VersionUpdateContract {
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/sunny/zy/contract/VersionUpdateContract$View;", "Lcom/sunny/zy/base/IBaseView;", "downLoadResult", "", "path", "", "noNewVersion", "progress", "", "showVersionUpdate", "versionBean", "Lcom/sunny/zy/bean/VersionBean;", "zyframe_debug"})
    public static abstract interface View extends com.sunny.zy.base.IBaseView {
        
        public abstract void showVersionUpdate(@org.jetbrains.annotations.NotNull()
        com.sunny.zy.bean.VersionBean versionBean);
        
        public abstract void noNewVersion();
        
        public abstract void downLoadResult(@org.jetbrains.annotations.NotNull()
        java.lang.String path);
        
        public abstract void progress(int progress);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/sunny/zy/contract/VersionUpdateContract$Presenter;", "Lcom/sunny/zy/base/BasePresenter;", "Lcom/sunny/zy/contract/VersionUpdateContract$View;", "view", "(Lcom/sunny/zy/contract/VersionUpdateContract$View;)V", "checkVersion", "", "version", "", "downLoadAPk", "url", "", "zyframe_debug"})
    public static abstract class Presenter extends com.sunny.zy.base.BasePresenter<com.sunny.zy.contract.VersionUpdateContract.View> {
        
        public abstract void checkVersion(int version);
        
        public abstract void downLoadAPk(@org.jetbrains.annotations.NotNull()
        java.lang.String url);
        
        public Presenter(@org.jetbrains.annotations.NotNull()
        com.sunny.zy.contract.VersionUpdateContract.View view) {
            super(null);
        }
    }
}