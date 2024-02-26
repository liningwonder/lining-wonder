/**
 * Copyright (c) 2023 the UnionPay. All rights reserved.
 *
 * @Author Ning Li
 * @Date 2023/11/15
 * @Description TODO
 */

package com.lining.wonder.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    private Result(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
    }

    private Result(ResultCodeEnum resultCodeEnum, T data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
        this.data = data;
    }

    private void resetMsg(String msg) {
        this.msg = msg;
    }

    public static <T> Result<T> build(ResultCodeEnum resultCodeEnum) {
        return new Result<T>(resultCodeEnum);
    }

    public static <T> Result<T> build(ResultCodeEnum resultCodeEnum, T data) {
        return new Result<T>(resultCodeEnum, data);
    }

    public Result<T> msg(String msg) {
        this.resetMsg(msg);
        return this;
    }

}
