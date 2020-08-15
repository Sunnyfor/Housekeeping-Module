package com.sunny.zy.base;

import java.lang.System;

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/2 16:23
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/sunny/zy/base/PageModel;", "T", "Lcom/sunny/zy/base/BaseModel;", "Lcom/sunny/zy/base/PageModel$Page;", "()V", "Page", "zyframe_debug"})
public final class PageModel<T extends java.lang.Object> extends com.sunny.zy.base.BaseModel<com.sunny.zy.base.PageModel.Page<T>> {
    
    public PageModel() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t\u00a8\u0006\u001b"}, d2 = {"Lcom/sunny/zy/base/PageModel$Page;", "T", "", "()V", "currPage", "", "getCurrPage", "()I", "setCurrPage", "(I)V", "list", "Ljava/util/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "pageSize", "getPageSize", "setPageSize", "totalCount", "getTotalCount", "setTotalCount", "totalPage", "getTotalPage", "setTotalPage", "toString", "", "zyframe_debug"})
    public static final class Page<T extends java.lang.Object> {
        private int totalCount = 0;
        private int pageSize = 1;
        private int totalPage = 1;
        private int currPage = 1;
        @org.jetbrains.annotations.NotNull()
        private java.util.ArrayList<T> list;
        
        public final int getTotalCount() {
            return 0;
        }
        
        public final void setTotalCount(int p0) {
        }
        
        public final int getPageSize() {
            return 0;
        }
        
        public final void setPageSize(int p0) {
        }
        
        public final int getTotalPage() {
            return 0;
        }
        
        public final void setTotalPage(int p0) {
        }
        
        public final int getCurrPage() {
            return 0;
        }
        
        public final void setCurrPage(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<T> getList() {
            return null;
        }
        
        public final void setList(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<T> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public Page() {
            super();
        }
    }
}