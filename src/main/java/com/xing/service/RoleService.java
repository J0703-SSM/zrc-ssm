package com.xing.service;

import com.xing.domin.Role;

import java.util.List;

/**
 * Created by dllo on 17/11/12.
 */
public interface RoleService {
    void addRole(Role role);
    void updateRole(Role role);
    void deleteAllRole_Per(String rolId);
    List<Role> findAllRole();
    Role findRoleById(String rolId);

}
