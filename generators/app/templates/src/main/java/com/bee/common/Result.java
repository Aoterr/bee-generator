package com.bee.common;

import com.bee.common.util.JsonUtil;

public class Result<T> {
    protected static final int ERROR_CODE = 500;
    protected static final int UN_AUTH = 401;
    protected static final int SUCCESS_CODE = 200;


    private int code;
    protected T data;


    protected Result() {
    }

    private Result(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> successfulResponse() {
        return new Result(SUCCESS_CODE);
    }

    public static <T> Result<T> successfulResponse(T data) {
        return new Result(SUCCESS_CODE, data);
    }


    public static <T> Result<T> errorResponse(int code, T data) {
        return new Result(code, data);
    }

    public static <T> Result<T> unAuthResponse() {
        return new Result(401, "请登录");
    }

    public static void main(String[] args) {
        String tr = JsonUtil.toJsonString(Result.successfulResponse());
        System.out.println(tr);
        tr = JsonUtil.toJsonString(Result.successfulResponse("sdfds"));
        System.out.println(tr);
    }
}
