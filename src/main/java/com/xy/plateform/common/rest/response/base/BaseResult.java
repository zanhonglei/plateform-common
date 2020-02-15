package com.xy.plateform.common.rest.response.base;

import lombok.Data;

/**
 * @author zanhonglei
 * @version V1.0
 * @Description:
 * @date 2019/11/7 11:01 下午
 */
@Data
public abstract class BaseResult<T> {
    protected int code;
    protected String msg;
    protected boolean success;
}
