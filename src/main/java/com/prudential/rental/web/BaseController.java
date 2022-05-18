package com.prudential.rental.web;

import com.prudential.rental.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author: xxxx
 * @createDate: 2018/9/4
 * @company: (C) Copyright xxxxx
 * @since: JDK 1.8
 * @Description:
 */
public class BaseController {
    public Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 默认参数校验处理方法
     *
     * @param bindingResult
     */
    public void checkParameters(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (Object object : bindingResult.getAllErrors()) {
                if (object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                    sb.append("[ " + fieldError.getDefaultMessage() + " ] ");
                }
            }
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
