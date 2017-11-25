package com.xing.account.domain;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by dllo on 17/11/17.
 */
public class Account {
    /**账户id*/
    private String accId;
    /**账户名*/
    private String accName;
    /**账户身份证*/
    private String accIdCard;
    /**账户登录名*/
    private String accLoginName;
    /**账户登录密码*/
    private String accLoginPwd;
    /**账户登录确认密码*/
    private String accLoginPwd2;
    /**账户电话*/
    private String accPhone;
    /**账户状态*/
    private int state;
    /**创建时间*/
    private Date newTime;
    /**上一次登录时间*/
    private Date lastLogin;

    // 可选项
    /**账户推荐人身份证*/
    private String accInviteIdCard;
    /**账户生日*/
    private Date birthday;
    /**账户电子邮箱*/
    private String email;
    /**账户职业*/
    private String accWork;
    /**账户性别*/
    private String gender;
    /**用户地址*/
    private String address;
    /**账户邮编*/
    private String zipCode;
    /**账户qq*/
    private String tNumber;


    public Account() {
    }

//    public Date getBirthdayByIdCard(){
//        StringBuilder sb = new StringBuilder();
//        String year = accIdCard.substring(6,10);
//        String months = accIdCard.substring(10,12);
//        String day = accIdCard.substring(12,14);
//        sb.append(year).append("-").append(months).append("-").append(day);
//        return new Date(String.valueOf(sb));
//
//    }

    @Override
    public String toString() {
        return "Account{" +
                "accId='" + accId + '\'' +
                ", accName='" + accName + '\'' +
                ", accIdCard='" + accIdCard + '\'' +
                ", accLoginName='" + accLoginName + '\'' +
                ", accLoginPwd='" + accLoginPwd + '\'' +
                ", accLoginPwd2='" + accLoginPwd2 + '\'' +
                ", accPhone='" + accPhone + '\'' +
                ", accInviteIdCard='" + accInviteIdCard + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", accWork='" + accWork + '\'' +
                ", gender='" + gender + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", tNumber='" + tNumber + '\'' +
                '}';
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccIdCard() {
        return accIdCard;
    }

    public void setAccIdCard(String accIdCard) {
        this.accIdCard = accIdCard;
    }

    public String getAccLoginName() {
        return accLoginName;
    }

    public void setAccLoginName(String accLoginName) {
        this.accLoginName = accLoginName;
    }

    public String getAccLoginPwd() {
        return accLoginPwd;
    }

    public void setAccLoginPwd(String accLoginPwd) {
        this.accLoginPwd = accLoginPwd;
    }

    public String getAccLoginPwd2() {
        return accLoginPwd2;
    }

    public void setAccLoginPwd2(String accLoginPwd2) {
        this.accLoginPwd2 = accLoginPwd2;
    }

    public String getAccPhone() {
        return accPhone;
    }

    public void setAccPhone(String accPhone) {
        this.accPhone = accPhone;
    }

    public String getAccInviteIdCard() {
        return accInviteIdCard;
    }

    public void setAccInviteIdCard(String accInviteIdCard) {
        this.accInviteIdCard = accInviteIdCard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String gettNumber() {
        return tNumber;
    }

    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }

    public String getAccWork() {
        return accWork;
    }

    public void setAccWork(String accWork) {
        this.accWork = accWork;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
