package com.xing.role.mapper;

import com.xing.base.domain.PageBean;
import com.xing.role.domain.Role;

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
     * 解除角色对应权限
     */
    void deleteAllRole_Per(String rolId);

    /**
     * 删除角色前解除拥有这个角色的管理员与之的关系
     * @param rolId 传入的角色id
     */
    void deleteAdmRolByRid(String rolId);

    int  deleteRolById(String rolId);

    /**
     * 根据管理员角色表查询出单个管理员的全部权限
     * @param admId 传入的管理员ID
     * @return 返回的带着权限信息的角色集合
     */
    List<Role> findRolesByAId(String admId);

    /**
     * 根据分页信息查询当页角色集合
     * @param pageBean 传过来的pg应该带着起始位置和页码尺寸
     * @return 返回角色集合
     */
    List<Role> findAllRoleByPage(PageBean pageBean);

    /**
     * 查询总记录数
     */
    int findAllCountByPage();
}
