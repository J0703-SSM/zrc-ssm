package com.xing.base.response;


/**
 * json封装
 * Created by dllo on 17/11/8.
 */
public class AjaxResult<T> {
    private int errorCode;// 响应码
    private String message;// 当返回错误时,给出错误信息
    private T t;// 用户对象

    public AjaxResult() {
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "errorCode=" + errorCode +
                ", message='" + message + '\'' +
                ", T =" + t +
                '}';
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

