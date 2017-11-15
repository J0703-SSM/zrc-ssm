package com.xing.role.domain;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 权限类
 */
public class Permissions {
    /** 权限id*/
    private String perId;
    /** 权限名*/
    @NotBlank(message = "账号不能为空")
    private String perName;
    /** 权限内容,权限说明*/
    private String perContent;

    public Permissions() {
    }

    public Permissions(String perId) {
        this.perId = perId;
    }

    public Permissions(String perName, String perContent) {
        this.perName = perName;
        this.perContent = perContent;
    }

    public Permissions(String perId, String perName, String perContent) {
        this.perId = perId;
        this.perName = perName;
        this.perContent = perContent;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "perId=" + perId +
                ", perName='" + perName + '\'' +
                ", perContent='" + perContent + '\'' +
                '}';
    }

    public String getPerId() {
        return perId;
    }

    public void setPerId(String perId) {
        this.perId = perId;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getPerContent() {
        return perContent;
    }

    public void setPerContent(String perContent) {
        this.perContent = perContent;
    }
}
