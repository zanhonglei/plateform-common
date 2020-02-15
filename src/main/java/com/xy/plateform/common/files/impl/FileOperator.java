package com.xy.plateform.common.files.impl;

import com.xy.plateform.common.files.AbstractFileOperator;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zanhonglei
 * @version V1.0
 * @Description:
 * @date 2020/2/8
 */
public class FileOperator extends AbstractFileOperator {

    /**
     * 删除文件
     * 1. 如果传入的目录,则删除该目录下所有文件
     * 2. 如果传入是文件,则删除该文件
     * 3. 如果传入的目录或者文件不存在,抛出异常
     *
     * @param path
     */
    @Override
    public void deletes(String path) throws NoSuchFileException, NotDirectoryException {
        File file = new File(path);
        if (!file.exists()) {
            throw new NoSuchFileException(path, null, "This file does not exist");
        }
        // 删除文件
        if (!file.isFile()) {
            List<String> listFiles = new LinkedList<>();
            listFilesCore(new File(path), listFiles);
            listFiles.forEach(filePath -> {
                File temp = new File(filePath);
                temp.deleteOnExit();
            });
        }
        // 删除空目录
        List<String> listDirs = new LinkedList<>();
        listDirCore(path, listDirs);
        int length = listDirs.size();
        for (int i = length - 1; i >= 0; i--) {
            new File(listDirs.get(i)).delete();
        }

    }

    /**
     * 列出该目录下所有文件
     *
     * @param path 目录
     * @return 文件绝对路径集合
     */
    @Override
    public List<String> listFiles(String path) {
        List<String> listFiles = new LinkedList<>();
        listFilesCore(new File(path), listFiles);
        return listFiles;
    }

    /**
     * 创建文件,同时也会把不存在的目录创建出来
     *
     * @param path
     * @param isCover true 覆盖 ; false 不覆盖
     * @return
     */
    @Override
    public boolean createFile(String path, boolean isCover) {
        File file = new File(path);
        if (isCover) {
            file.deleteOnExit();
        }
        return file.mkdirs();
    }


    public static void main(String[] args) throws NoSuchFileException, NotDirectoryException {
        List<String> listDirs = new LinkedList<>();
        String path = "/Users/zanhonglei/develop/test1/";
        FileOperator fileOperator = new FileOperator();
        fileOperator.deletes(path);
        fileOperator.listDirCore(path, listDirs);
        System.out.println(listDirs.toString());
        System.out.println(fileOperator.listFiles(path));

    }

    /**
     * 递归查找文件
     *
     * @param file
     * @param files
     */
    private void listFilesCore(File file, List<String> files) {
        if (file.isFile()) {
            files.add(file.getPath());
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File temp : listFiles) {
                    listFilesCore(temp, files);
                }
            }
        }
    }

    /**
     * 递归查找目录
     *
     * @param path
     * @param files
     */
    private void listDirCore(String path, List<String> files) {
        File file = new File(path);
        if (file.isDirectory()) {
            files.add(file.getPath());
            String[] listDirs = file.list();
            if (listDirs != null) {
                for (String temp : listDirs) {
                    listDirCore(path + temp + File.separator, files);
                }
            }
        }
    }

}
