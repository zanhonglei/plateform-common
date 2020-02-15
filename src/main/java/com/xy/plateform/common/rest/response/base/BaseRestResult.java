package com.xy.plateform.common.rest.response.base;

import lombok.Data;

/**
 * @author zanhonglei
 * @version V1.0
 * @Description:
 * @date 2019/11/2 14:24
 */
@Data
public abstract class BaseRestResult<T> extends BaseResult<T> {
   protected T data;
}
