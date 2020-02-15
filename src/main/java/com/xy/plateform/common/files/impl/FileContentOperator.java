package com.xy.plateform.common.files.impl;

import com.xy.plateform.common.files.AbstractFileContentOperator;

import java.io.File;

/**
 * @author zanhonglei
 * @version V1.0
 * @Description:
 * @date 2020/2/9
 */
public class FileContentOperator extends AbstractFileContentOperator {

    @Override
    public void write(File file, byte[] data) {

    }

    @Override
    public byte[] read(File file) {
        return new byte[0];
    }
}
