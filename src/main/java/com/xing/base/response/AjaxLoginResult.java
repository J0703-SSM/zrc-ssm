package com.xing.base.response;


/**
 * json封装
 * Created by dllo on 17/11/8.
 */
public class AjaxLoginResult {
    private int errorCode;// 响应码
    private String message;// 当返回错误时,给出错误信息

    public AjaxLoginResult() {
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
}
