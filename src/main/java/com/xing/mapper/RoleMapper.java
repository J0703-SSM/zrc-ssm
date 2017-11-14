package com.xing.mapper;

import com.xing.domin.Role;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface RoleMapper {
    /**
     * 添加角色
     * @param role
     */
    void addRole (Role role);

    /**
     * 添加角色权限
     * @param role
     */
    void addRole_Per (Role role);

    /**
     * 查询所有
     * @return
     */
    List<Role> findAllRole ();

    /**
     * 根据Id查询角色
     * @param rolId id
     * @return 查询到的角色
     */
    Role findRoleById (String rolId);

    /**
     * 修改角色
     * @param role 传过来的修改完成的角色
     */
    void updateRole(Role role);

    /**
     * 删除全部权限
     */
    void deleteAllRole_Per(String rolId);
}
