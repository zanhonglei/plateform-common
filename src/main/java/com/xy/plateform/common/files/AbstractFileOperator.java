package com.xy.plateform.common.files;

import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;
import java.util.List;

/**
 * @author zanhonglei
 * @version V1.0
 * @Description:
 * @date 2020/2/8
 */
public abstract class AbstractFileOperator {
    /**
     * * 删除文件
     *      * 1. 如果传入的目录,则删除该目录下所有文件
     *      * 2. 如果传入是文件,则删除该文件
     *      * 3. 如果传入的目录或者文件不存在,抛出异常
     * @param path
     * @throws NoSuchFileException
     * @throws NotDirectoryException
     */
    public abstract void deletes(String path) throws NoSuchFileException, NotDirectoryException;

    /**
     * 列出该目录下所有文件
     * @param path 目录
     * @return 文件绝对路径集合
     */
    public abstract List<String> listFiles(String path);

    /**
     * 创建文件,同时也会把不存在的目录创建出来
     * @param path
     * @param isCover true 覆盖 ; false 不覆盖
     * @return
     */
    public  abstract boolean createFile(String path,boolean isCover);
}
