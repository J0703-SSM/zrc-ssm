package com.xing.admin.domain;

import com.xing.role.domain.Role;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "[\\u4e00-\\u9fa50-9A-Za-z]{3,20}",message = "20长度以内的汉字、字母、数字的组合")
    @NotBlank(message = "用户名不能为空")
    private String admName;
    /** 管理员登录名*/
    @Pattern(regexp = "^[a-zA-Z0-9\\w]{1,20}$",message = "20长度以内的字母、数字、下划线的组合")
    @NotBlank(message = "用户名不能为空")
    private String admLoginName;
    /** 管理员密码*/
    @Pattern(regexp = "^[a-zA-Z0-9\\w]{1,20}$",message = "20长度以内的字母、数字、下划线的组合")
    @NotBlank(message = "密码不能为空")
    private String admLoginPwd;
    /** 管理员注册确认密码*/
    private String admLoginPwd2;
    /** 管理员电话*/
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$",
            message = "请输入正确的电话")
    private String admPhone;
    /** 管理员Email*/
    @Pattern(regexp = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$",
            message = "请输入正确的邮箱")
    private String admEmail;
    /** 授权时间 */
    private Date authorizationTime;

    /** 管理员拥有的角色*/
    private List<Role> rolList = new ArrayList<Role>();

    @Override
    public String toString() {
        return "Admin{" +
                "admId='" + admId + '\'' +
                ", admName='" + admName + '\'' +
                ", admLoginName='" + admLoginName + '\'' +
                ", admLoginPwd='" + admLoginPwd + '\'' +
                ", admLoginPwd2='" + admLoginPwd2 + '\'' +
                ", admPhone='" + admPhone + '\'' +
                ", admEmail='" + admEmail + '\'' +
                '}';
    }

    public Admin() {
    }

    public Admin(String admName, String admLoginName, String admLoginPwd, String admLoginPwd2, String admPhone, String admEmail) {
        this.admName = admName;
        this.admLoginName = admLoginName;
        this.admLoginPwd = admLoginPwd;
        this.admLoginPwd2 = admLoginPwd2;
        this.admPhone = admPhone;
        this.admEmail = admEmail;
    }

    public Admin(String admId, String admName, String admLoginName, String admLoginPwd, String admPhone, String admEmail, Date authorizationTime) {
        this.admId = admId;
        this.admName = admName;
        this.admLoginName = admLoginName;
        this.admLoginPwd = admLoginPwd;
        this.admPhone = admPhone;
        this.admEmail = admEmail;
        this.authorizationTime = authorizationTime;
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

    public String getAdmPhone() {
        return admPhone;
    }

    public void setAdmPhone(String admPhone) {
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
