package com.xing.admin.service.impl;

import com.xing.admin.domain.Admin;
import com.xing.admin.mapper.AdminMapper;
import com.xing.admin.service.AdminService;
import com.xing.base.domain.PageBean;
import com.xing.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Qualifier("adminMapper")
    @Autowired
    private AdminMapper adminMapper;
    @Qualifier("roleService")
    @Autowired
    private RoleService roleService;
    @Override
    public void addAdmin(Admin admin) {
        Admin admin1 =  adminMapper.findAdminById(admin.getAdmId());
        if (null == admin1){
            adminMapper.addAdmin(admin);
        }
        adminMapper.addAdmin_Rol(admin);
    }

    @Override
    public Admin findAdminById(String admId) {
        Admin admin = adminMapper.findAdmById(admId);
        admin.setRolList(roleService.findRolesByAId(admId));
        return admin;
    }

    @Override
    public Admin login(String admLoginName) {
        return adminMapper.login(admLoginName);
    }

    @Override
    public PageBean<Admin> findAllAdmin(PageBean<Admin> pageBean) {
        List<Admin> admins = adminMapper.findAllAdm(pageBean);
        for (Admin admin : admins) {
            admin.setRolList(roleService.findRolesByAId(admin.getAdmId()));
        }
        pageBean.setBeanList(admins);
        return pageBean;
    }

    @Override
    public int deleteAdminById(String admId) {
        // 由于级联关系先解除管理员的角色
        int r = adminMapper.deleteAdmRolById(admId);
        // 再进行删除
        int a = adminMapper.deleteAdmById(admId);

        return r + a;
    }

    @Override
    public void updateAdm(Admin admin) {
        adminMapper.updateAdm(admin);
        // 更新管理员角色关系时先删除原先的所有关系
        adminMapper.deleteAdmRolById(admin.getAdmId());
        // 再加入新的关系
        adminMapper.addAdmin_Rol(admin);
    }

    @Override
    public void deleteAdmRolById(String admId) {
        adminMapper.deleteAdmRolById(admId);
    }
}
