package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yxq
 * @data 2021/6/27 14:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T     data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }

}
