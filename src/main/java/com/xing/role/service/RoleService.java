package com.xing.role.service;

import com.xing.base.domain.PageBean;
import com.xing.role.domain.Role;

import java.util.List;

/**
 * Created by dllo on 17/11/12.
 */
public interface RoleService {
    void addRole(Role role);
    void updateRole(Role role);
    void deleteAllRole_Per(String rolId);
    int deleteRolById(String rolId);
    List<Role> findAllRole();
    List<Role> findRolesByAId(String admId);
    Role findRoleById(String rolId);
    PageBean<Role> findAllRoleByPage(PageBean<Role> pageBean);
}
