package com.xing.admin.mapper;

import com.xing.admin.domain.Admin;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface AdminMapper {
    /**
     * 添加管理员
     * @param admin
     */
    void addAdmin(Admin admin);

    /**
     * 添加管理员角色信息
     * @param admin
     */
    void addAdmin_Rol(Admin admin);

    /**
     * 根据id查询管理员
     * @param admId
     * @return
     */
    Admin findAdminById(String admId);

    /**
     * 查询所有管理员
     * @return 返回带着所有信息的管理员
     */
    List<Admin> findAllAdmin();
}
