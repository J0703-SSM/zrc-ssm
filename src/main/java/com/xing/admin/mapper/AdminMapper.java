package com.xing.admin.mapper;

import com.xing.admin.domain.Admin;
import com.xing.base.domain.PageBean;

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
     * 登陆查询
     * @param admLoginName 传入的登陆名
     * @return 返回的查询结果
     */
    Admin login(String admLoginName);

    /**
     * 查询所有管理员
     * @return 返回带着所有信息的管理员
     */
    List<Admin> findAllAdmin();

    /**
     * 查询所有管理员
     * @return 返回只有管理员基础信息的Admin集合
     */
    List<Admin> findAllAdm(PageBean pageBean);

    /**
     * 根据Id查询员工
     * @param admId
     * @return 返回只有基础信息的Admin
     */
    Admin findAdmById(String admId);



    /**
     * 解除管理员的角色
     * @param admId 传入的管理员ID
     * @return 返回删除条数
     */
    int deleteAdmRolById(String admId);

    /**
     * 删除管理员
     * @param admId 传入的管理员Id
     * @return 返回删除条数
     */
    int deleteAdmById(String admId);

    /**
     * 更新管理员
     * @param admin
     */
    void updateAdm(Admin admin);


}
