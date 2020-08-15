package com.sunny.zy.utils;

import java.lang.System;

/**
 * 文件操作相关工具类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/sunny/zy/utils/FileUtils;", "", "()V", "deleteAllFile", "", "deleteFolderFile", "filePath", "", "formatFileSize", "fileS", "", "getCacheDir", "Ljava/io/File;", "getCacheSize", "getFile", "name", "getFolderSize", "file", "getUriFromPath", "Landroid/net/Uri;", "path", "zyframe_debug"})
public final class FileUtils {
    public static final com.sunny.zy.utils.FileUtils INSTANCE = null;
    
    /**
     * 获取换成你文件路径
     */
    private final java.io.File getCacheDir() {
        return null;
    }
    
    /**
     * 根据文件名获取文件
     */
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getFile(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    /**
     * 获取目录缓存大小
     */
    public final long getCacheSize() {
        return 0L;
    }
    
    /**
     * 转换文件大小
     *
     * @param fileS
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatFileSize(long fileS) {
        return null;
    }
    
    /**
     * 获取指定文件夹内所有文件大小的和
     *
     * @param file file
     * @return size
     * @throws Exception
     */
    private final long getFolderSize(java.io.File file) {
        return 0L;
    }
    
    /**
     * 删除所有缓存文件
     */
    public final void deleteAllFile() {
    }
    
    private final void deleteFolderFile(java.lang.String filePath) {
    }
    
    /**
     * 从一个文件路径得到URI
     */
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getUriFromPath(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    private FileUtils() {
        super();
    }
}