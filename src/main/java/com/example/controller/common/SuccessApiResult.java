package com.example.controller.common;

//SuccessApiResult
public class SuccessApiResult extends ApiResult {
    public SuccessApiResult(String message ,Object data) {
        this.code = "SYS_SUCCESS";
        this.message = message;
        this.data = data;
    }
}