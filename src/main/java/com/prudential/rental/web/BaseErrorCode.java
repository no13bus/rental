package com.prudential.rental.web;


/**
 * @author: xxxx
 * @createDate: 2018/9/4
 * @company: (C) Copyright xxxxx
 * @since: JDK 1.8
 * @Description:
 */
public class BaseErrorCode {
    public static final ErrorCode SUCCESS = ErrorCode.of("SUCCESS", "调用成功");
    public static final ErrorCode ERR_SYSTEM_ERROR = ErrorCode.of("ERR_SYSTEM_ERROR", "系统错误，稍后重试");
    public static final ErrorCode ERR_SYSTEM_UNKNOW = ErrorCode.of("ERR_SYSTEM_UNKNOW", "系统繁忙,请稍后再试");
    public static final ErrorCode ERR_ORDER_NOT_EXIST = ErrorCode.of("ERR_ORDER_NOT_EXIST", "order is not exist");
    public static final ErrorCode ERR_ORDER_STATE = ErrorCode.of("ERR_ORDER_STATE", "order state is error");
    public static final ErrorCode ERR_CAR_NOT_EXIST = ErrorCode.of("ERR_CAR_NOT_EXIST", "car is not exist");
    public static final ErrorCode ERR_CAR_NO_STOCK = ErrorCode.of("ERR_CAR_NO_STOCK", "car is out of stock");
    public static final ErrorCode ERR_SYSTEM_AUTH_REJECT = ErrorCode.of("ERR_SYSTEM_AUTH_REJECT", "非法请求");
    public static final ErrorCode ERR_SYSTEM_PARAM_MISSING = ErrorCode.of("ERR_SYSTEM_PARAM_MISSING", "缺少关键参数");
    public static final ErrorCode ERR_SYSTEM_PARAM_CHECK = ErrorCode.of("ERR_SYSTEM_PARAM_CHECK", "参数校验失败");
    public static final ErrorCode ERR_SYSTEM_API_ERROR = ErrorCode.of("ERR_SYSTEM_API_ERROR", "请求的接口异常");
    public static final ErrorCode ERR_SYSTEM_SERVICE_ERROR = ErrorCode.of("ERR_SYSTEM_SERVICE_ERROR", "请求的服务异常");
    public static final ErrorCode ERR_SYSTEM_DAO_ERROR = ErrorCode.of("ERR_SYSTEM_DAO_ERROR", "请求的数据异常");

    public BaseErrorCode() {
    }
}
