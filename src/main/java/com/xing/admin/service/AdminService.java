package com.xing.admin.service;

import com.xing.admin.domain.Admin;
import com.xing.base.domain.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface AdminService {
    void addAdmin(Admin admin);
    Admin findAdminById(String admId);
    Admin login(String admLoginName);
    PageBean<Admin> findAllAdmin(PageBean<Admin> pageBean);
    int deleteAdminById(String admId);
    void updateAdm(Admin admin);
    void deleteAdmRolById(String admId);
}
