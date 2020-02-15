package com.xy.plateform.common.rest.response;

import com.xy.plateform.common.rest.response.base.BaseRestResult;
import lombok.Data;

/**
 * @author zanhonglei
 * @version V1.0
 * @Description:
 * @date 2020/2/8
 */
@Data
public class RestResult<T> extends BaseRestResult<T> {

    private RestResult(T t, int code,String message,boolean success){
        this.data = t;
        this.code = code;
        this.msg = message;
        this.success = success;
    }

    /**
     * 成功返回结果集
     * @param data
     * @return
     */
    public static RestResult data(Object data){
        return new RestResult<>(data, 200, "",true);
    }

    /**
     * 成功
     * @return
     */
    public static RestResult success(){
        return new RestResult<>("", 200, "",true);
    }

    /**
     * 失败
     * @param code
     * @param message
     * @return
     */
    public static RestResult error(int code,String message){
        return new RestResult<>("", code, message,false);
    }

    /**
     * 失败
     * @param code
     * @return
     */
    public static RestResult error(int code){
        return new RestResult<>("", code, "",false);
    }


}
