package com.sunny.zy.bean;

import java.lang.System;

/**
 * Desc
 * Author JoannChen
 * Mail yongzuo.chen@foxmail.com
 * Date 2020/7/8 17:29
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b;\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010\'\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001c\u00103\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001c\u00106\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001c\u00109\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001c\u0010<\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\b\u00a8\u0006?"}, d2 = {"Lcom/sunny/zy/bean/UploadBean;", "", "()V", "associatioTableID", "", "getAssociatioTableID", "()Ljava/lang/String;", "setAssociatioTableID", "(Ljava/lang/String;)V", "format", "getFormat", "setFormat", "fuJianDm", "getFuJianDm", "setFuJianDm", "fullNamePdf", "getFullNamePdf", "setFullNamePdf", "fullname", "getFullname", "setFullname", "groupId", "getGroupId", "setGroupId", "id", "getId", "setId", "name", "getName", "setName", "processInstanceIdNum", "getProcessInstanceIdNum", "setProcessInstanceIdNum", "reWuJl", "getReWuJl", "setReWuJl", "realname", "getRealname", "setRealname", "remark", "getRemark", "setRemark", "size", "getSize", "setSize", "src", "getSrc", "setSrc", "type", "getType", "setType", "updatedate", "getUpdatedate", "setUpdatedate", "userName", "getUserName", "setUserName", "userid", "getUserid", "setUserid", "yeWuDm", "getYeWuDm", "setYeWuDm", "zyframe_debug"})
public final class UploadBean {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String associatioTableID;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String format;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String fuJianDm;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String fullname;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String groupId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String processInstanceIdNum;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String reWuJl;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String realname;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String remark;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String size;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String userName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String userid;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String yeWuDm;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String type;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String fullNamePdf;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String updatedate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String src;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAssociatioTableID() {
        return null;
    }
    
    public final void setAssociatioTableID(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFormat() {
        return null;
    }
    
    public final void setFormat(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFuJianDm() {
        return null;
    }
    
    public final void setFuJianDm(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFullname() {
        return null;
    }
    
    public final void setFullname(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGroupId() {
        return null;
    }
    
    public final void setGroupId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProcessInstanceIdNum() {
        return null;
    }
    
    public final void setProcessInstanceIdNum(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReWuJl() {
        return null;
    }
    
    public final void setReWuJl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRealname() {
        return null;
    }
    
    public final void setRealname(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRemark() {
        return null;
    }
    
    public final void setRemark(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSize() {
        return null;
    }
    
    public final void setSize(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserid() {
        return null;
    }
    
    public final void setUserid(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getYeWuDm() {
        return null;
    }
    
    public final void setYeWuDm(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFullNamePdf() {
        return null;
    }
    
    public final void setFullNamePdf(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUpdatedate() {
        return null;
    }
    
    public final void setUpdatedate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSrc() {
        return null;
    }
    
    public final void setSrc(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public UploadBean() {
        super();
    }
}