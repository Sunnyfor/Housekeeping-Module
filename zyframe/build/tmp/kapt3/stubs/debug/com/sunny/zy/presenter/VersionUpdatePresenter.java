package com.sunny.zy.presenter;

import java.lang.System;

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/15 12:11
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/sunny/zy/presenter/VersionUpdatePresenter;", "Lcom/sunny/zy/contract/VersionUpdateContract$Presenter;", "view", "Lcom/sunny/zy/contract/VersionUpdateContract$View;", "(Lcom/sunny/zy/contract/VersionUpdateContract$View;)V", "versionUpdateModel", "Lcom/sunny/zy/model/VersionUpdateModel;", "getVersionUpdateModel", "()Lcom/sunny/zy/model/VersionUpdateModel;", "versionUpdateModel$delegate", "Lkotlin/Lazy;", "checkVersion", "", "version", "", "downLoadAPk", "url", "", "zyframe_debug"})
public final class VersionUpdatePresenter extends com.sunny.zy.contract.VersionUpdateContract.Presenter {
    private final kotlin.Lazy versionUpdateModel$delegate = null;
    
    private final com.sunny.zy.model.VersionUpdateModel getVersionUpdateModel() {
        return null;
    }
    
    @java.lang.Override()
    public void checkVersion(int version) {
    }
    
    @java.lang.Override()
    public void downLoadAPk(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    public VersionUpdatePresenter(@org.jetbrains.annotations.NotNull()
    com.sunny.zy.contract.VersionUpdateContract.View view) {
        super(null);
    }
}