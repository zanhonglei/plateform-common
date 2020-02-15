package com.xy.plateform.common.exception;

import lombok.Data;

/**
 * @author zanhonglei
 * @version V1.0
 * @Description:
 * @date 2019/11/8 11:22 下午
 */
@Data
public class BaseException extends RuntimeException {
    /**
     * 错误码
     */
    private int errorCode;
    /**
     * 错误动态参数
     */
    private String[] args;

    private BaseException() {
        super();
    }

    public BaseException(String message){
        super(message);
    }

    public BaseException(Integer errorCode, String... args) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.args = args;
    }

    public BaseException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}