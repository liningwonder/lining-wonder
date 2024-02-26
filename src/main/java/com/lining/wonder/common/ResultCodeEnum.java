package com.lining.wonder.common;

import lombok.Getter;

/**
 * 枚举类名带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开
 * @author liningwonder
 */
@Getter
public enum ResultCodeEnum {
    //OK
    SC_OK(2000, "操作成功"),
    //Bad Request
    SC_BAD_REQUEST(4000, "客户端错误"),
    //request validate error
    SC_VALIDATE_ERROR(4002, "请求参数校验失败"),
    //body type error
    SC_BODY_ERROR(4002, "参数错误"),
    //404
    SC_NOT_FOUND(4004, "请求路径错误"),
    //405
    SC_METHOD_ERROR(4005, "请求方法错误"),
    
    //415
    SC_MEDIA_ERROR(4015, "请求体格式错误"),

    //need system define
    SC_UNKNOWN_ERROR(5001, "未知错误"),

    //need system fix
    SC_INTERNAL_SERVER_ERROR(5000, "服务器内部错误"),
    
    SC_TOKE_ERROR(6000, "token异常"),
    
    //未登录
    SC_TOKEN_NOT_LOGIN(6001, "请先登录"),
    
    SC_TOKEN_PERMISSION_ERROR(6002, "无权限")
    
    ;
    private int code;
    private String msg;
    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
