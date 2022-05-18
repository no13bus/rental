package com.prudential.rental.exception;

import com.prudential.rental.web.ApiResponse;
import com.prudential.rental.web.BaseErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author: xxxx
 * @createDate: 2018/9/4
 * @company: (C) Copyright xxxxx
 * @since: JDK 1.8
 * @Description:
 */
@ControllerAdvice
@Slf4j
public class DefaultGlobalExceptionHandler {
    @ExceptionHandler(value = {BusinessException.class})
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ApiResponse defaultErrorHandler(AbstractErrorCodeException ex) {
        /*
         * 返回json数据或者String数据： 那么需要在方法上加上注解：@ResponseBody 添加return即可。
         */
        // 在这里判断异常，根据不同的异常返回错误。
        if (ex.getErrorCode() != null) {
            return ApiResponse.buildFail(ex.getErrorCode());
        } else {
            return ApiResponse.buildFail();
        }
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ApiResponse defaultErrorHandler(IllegalArgumentException ex) {
        return ApiResponse.buildFail(BaseErrorCode.ERR_SYSTEM_PARAM_CHECK.withErrorDesc(ex.getMessage()));
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ApiResponse defaultErrorHandler(NoHandlerFoundException ex) {
        return ApiResponse.buildFail(BaseErrorCode.ERR_SYSTEM_API_ERROR.withErrorDesc("错误的请求地址"));
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ApiResponse defaultErrorHandler(Exception ex) {
        return ApiResponse.buildFail(BaseErrorCode.ERR_SYSTEM_ERROR.withErrorDesc(ex.getMessage()));
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ApiResponse defaultErrorHandler(Throwable ex) {
        return ApiResponse.buildFail(BaseErrorCode.ERR_SYSTEM_UNKNOW.withErrorDesc(ex.getMessage()));
    }
}
