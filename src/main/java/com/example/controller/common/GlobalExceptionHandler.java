package com.example.controller.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
/**
 * 全局GlobalExceptionHandler
 *
 * @author  nanjishiu
 * @version 1.0, 2017/11
 */
@RestControllerAdvice
//注解@ControllerAdvice是一个组件注解（component annotation），它允许实现类通过类路径扫描被自动检测到。当使用 MVC 命名空间或者 MVC Java 配置时自动启用
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ApiResult handlerException(Exception e) {
        //如果是自定义的异常，返回对应的错误信息
        if (e instanceof GloableException) {
//            e.printStackTrace();
            GloableException exception = (GloableException) e;
            return ApiResult.error(exception.getCode(), exception.getMessage());
        } else {
            //如果不是已知异常，返回系统异常
            e.printStackTrace();
            return ApiResult.error("SYS_EXCEPTION", "系统异常");
        }

    }
}