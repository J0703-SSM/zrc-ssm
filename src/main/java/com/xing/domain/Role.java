package com.xing.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色类
 */
public class Role {
    /** 角色id*/
    private String rolId;
    /** 角色名*/
    private String rolName;
    /** 角色内容以及角色简短说明 */
    private String rolContent;
    /** 角色中的权限集合 */
    private List<Permissions> perList = new ArrayList<Permissions>();


    public Role() {
    }

    public Role(String rolName, String rolContent) {
        this.rolName = rolName;
        this.rolContent = rolContent;
    }

    public Role(String rolId, String rolName, String rolContent) {
        this.rolId = rolId;
        this.rolName = rolName;
        this.rolContent = rolContent;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rolId=" + rolId +
                ", rolName='" + rolName + '\'' +
                ", rolContent='" + rolContent + '\'' +
                '}';
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public String getRolContent() {
        return rolContent;
    }

    public void setRolContent(String rolContent) {
        this.rolContent = rolContent;
    }

    public List<Permissions> getPerList() {
        return perList;
    }

    public void setPerList(List<Permissions> perList) {
        this.perList = perList;
    }
}
