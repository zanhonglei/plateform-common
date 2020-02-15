package com.xy.plateform.common.files;

import java.io.File;

/**
 * @author zanhonglei
 * @version V1.0
 * @Description:
 * @date 2020/2/9
 */
public abstract class AbstractFileContentOperator {


    public abstract void write(File file, byte[] data);


    public abstract byte[] read(File file);

}
