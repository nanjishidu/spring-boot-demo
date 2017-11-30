package com.example.controller.common;

//ErrorApiResult
public class ErrorApiResult extends ApiResult {

    public ErrorApiResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
}