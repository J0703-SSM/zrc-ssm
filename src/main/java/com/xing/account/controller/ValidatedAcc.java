package com.xing.account.controller;

import com.xing.base.response.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 前台Acc较验
 */
@RequestMapping("/valAcc")
@Controller
public class ValidatedAcc {
    /**
     * 验证用户名字
     * @param accName
     * @return
     */
    @ResponseBody
    @RequestMapping("/accName")
    public AjaxResult validationName(String accName){
        AjaxResult ajaxResult = new AjaxResult();
        if (accName.isEmpty()) {
            ajaxResult.setErrorCode(0);
            ajaxResult.setMessage("姓名不能为空");
            return ajaxResult;
        }
        // 动态方法 判断一部分是否匹配
        Pattern pat = Pattern.compile("[\\u4E00-\\u9FA5]{2,5}(?:·[\\u4E00-\\u9FA5]{2,5})*");
        Matcher matcher = pat.matcher(accName);
        // 完全匹配
        boolean isMatch = matcher.matches();
        if (isMatch) {
            ajaxResult.setErrorCode(1);
            ajaxResult.setMessage("");
        } else {
            ajaxResult.setErrorCode(0);
            ajaxResult.setMessage("请输入正确格式的姓名");
        }
        return ajaxResult;
    }
    @ResponseBody
    @RequestMapping("/idCard")
    public AjaxResult validationIdCard(String idCard){
        AjaxResult ajaxResult = new AjaxResult();
        if (idCard.isEmpty()) {
            ajaxResult.setErrorCode(0);
            ajaxResult.setMessage("身份证不能为空");
            return ajaxResult;
        }
        // 动态方法 判断一部分是否匹配
        Pattern pat = Pattern.compile("^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");
        Matcher matcher = pat.matcher(idCard);
        // 完全匹配
        boolean isMatch = matcher.matches();
        if (isMatch) {
            ajaxResult.setErrorCode(1);
            ajaxResult.setMessage("");
        } else {
            ajaxResult.setErrorCode(0);
            ajaxResult.setMessage("请输入有效的身份证号");
        }
        return ajaxResult;
    }
    @ResponseBody
    @RequestMapping("/accLoginName")
    public AjaxResult validationAccLoginName (String accLoginName){
        AjaxResult ajaxResult = new AjaxResult();
        if (accLoginName.isEmpty()) {
            ajaxResult.setErrorCode(0);
            ajaxResult.setMessage("登录名不能为空");
            return ajaxResult;
        }
        // 动态方法 判断一部分是否匹配
        Pattern pat = Pattern.compile("^[a-zA-Z0-9\\w]{1,20}$");
        Matcher matcher = pat.matcher(accLoginName);
        // 完全匹配
        boolean isMatch = matcher.matches();
        if (isMatch) {
            ajaxResult.setErrorCode(1);
            ajaxResult.setMessage("");
        } else {
            ajaxResult.setErrorCode(0);
            ajaxResult.setMessage("账号是20长度以内的字母、数字、下划线的组合");
        }
        return ajaxResult;
    }
    @ResponseBody
    @RequestMapping("/accLoginPwd")
    public AjaxResult validationAccLoginPwd (String accLoginPwd){
        AjaxResult ajaxResult = new AjaxResult();
        if (accLoginPwd.isEmpty()) {
            ajaxResult.setErrorCode(0);
            ajaxResult.setMessage("密码不能为空");
            return ajaxResult;
        }
        // 动态方法 判断一部分是否匹配
        Pattern pat = Pattern.compile("^[a-zA-Z0-9\\w]{1,20}$");
        Matcher matcher = pat.matcher(accLoginPwd);
        // 完全匹配
        boolean isMatch = matcher.matches();
        if (isMatch) {
            ajaxResult.setErrorCode(1);
            ajaxResult.setMessage("");
        } else {
            ajaxResult.setErrorCode(0);
            ajaxResult.setMessage("密码是20长度以内的字母、数字、下划线的组合");
        }
        return ajaxResult;
    }
    @ResponseBody
    @RequestMapping("/accPhone")
    public AjaxResult validationAccPhone (String accPhone){
        AjaxResult ajaxResult = new AjaxResult();
        if (accPhone.isEmpty()) {
            ajaxResult.setErrorCode(0);
            ajaxResult.setMessage("电话不能为空");
            return ajaxResult;
        }
        // 动态方法 判断一部分是否匹配
        Pattern pat = Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
        Matcher matcher = pat.matcher(accPhone);
        // 完全匹配
        boolean isMatch = matcher.matches();
        if (isMatch) {
            ajaxResult.setErrorCode(1);
            ajaxResult.setMessage("");
        } else {
            ajaxResult.setErrorCode(0);
            ajaxResult.setMessage("请输入正确的电话格式");
        }
        return ajaxResult;
    }
}
