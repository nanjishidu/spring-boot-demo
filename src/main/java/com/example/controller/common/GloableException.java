package com.example.controller.common;

/**
 * 全局GloableException
 *
 * @author  nanjishiu
 * @version 1.0, 2017/11
 */
public class GloableException extends RuntimeException {
    public GloableException(String code, String message) {
        super(code);
        this.code = code;
        this.message = message;
    }
    private String code;
    private String message;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}