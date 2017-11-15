package com.xing.admin.service;

import com.xing.admin.domain.Admin;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface AdminService {
    void addAdmin(Admin admin);
    Admin findAdminById(String admId);
    List<Admin> findAllAdmin();
}
