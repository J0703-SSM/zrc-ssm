package com.xing.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 管理员类
 */
public class Admin {
    /** 管理员id*/
    private String admId;
    /** 管理员姓名*/
    private String admName;
    /** 管理员登录名*/
    private String admLoginName;
    /** 管理员密码*/
    private String admLoginPwd;
    /** 管理员注册确认密码*/
    private String admLoginPwd2;
    /** 管理员电话*/
    private Integer admPhone;
    /** 管理员Email*/
    private String admEmail;
    private Date authorizationTime;

    /** 管理员拥有的角色*/
    private List<Role> rolList = new ArrayList<Role>();

    public Admin() {
    }

    public Admin(String admName, String admLoginName, String admLoginPwd, String admLoginPwd2, Integer admPhone, String admEmail) {
        this.admName = admName;
        this.admLoginName = admLoginName;
        this.admLoginPwd = admLoginPwd;
        this.admLoginPwd2 = admLoginPwd2;
        this.admPhone = admPhone;
        this.admEmail = admEmail;
    }

    public Admin(String admId, String admName, String admLoginName, String admLoginPwd, String admLoginPwd2, Integer admPhone, String admEmail) {
        this.admId = admId;
        this.admName = admName;
        this.admLoginName = admLoginName;
        this.admLoginPwd = admLoginPwd;
        this.admLoginPwd2 = admLoginPwd2;
        this.admPhone = admPhone;
        this.admEmail = admEmail;
    }

    public String getAdmId() {
        return admId;
    }

    public void setAdmId(String admId) {
        this.admId = admId;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getAdmLoginName() {
        return admLoginName;
    }

    public void setAdmLoginName(String admLoginName) {
        this.admLoginName = admLoginName;
    }

    public String getAdmLoginPwd() {
        return admLoginPwd;
    }

    public void setAdmLoginPwd(String admLoginPwd) {
        this.admLoginPwd = admLoginPwd;
    }

    public String getAdmLoginPwd2() {
        return admLoginPwd2;
    }

    public void setAdmLoginPwd2(String admLoginPwd2) {
        this.admLoginPwd2 = admLoginPwd2;
    }

    public Integer getAdmPhone() {
        return admPhone;
    }

    public void setAdmPhone(Integer admPhone) {
        this.admPhone = admPhone;
    }

    public String getAdmEmail() {
        return admEmail;
    }

    public void setAdmEmail(String admEmail) {
        this.admEmail = admEmail;
    }

    public List<Role> getRolList() {
        return rolList;
    }

    public void setRolList(List<Role> rolList) {
        this.rolList = rolList;
    }

    public Date getAuthorizationTime() {
        return authorizationTime;
    }

    public void setAuthorizationTime(Date authorizationTime) {
        this.authorizationTime = authorizationTime;
    }
}