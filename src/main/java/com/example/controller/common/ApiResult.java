package com.example.controller.common;

//ApiResult
public abstract class ApiResult {

    protected String code;
    protected String message;
    protected Object data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static ApiResult jdata(Object data) {
        return new SuccessApiResult("SUCCESS",data);
    }
    public static ApiResult jmessage(String message) {
        return new SuccessApiResult(message,null);
    }
    public static ApiResult error(String errorCode, String errorMessage) {
        return new ErrorApiResult(errorCode, errorMessage);
    }

}


