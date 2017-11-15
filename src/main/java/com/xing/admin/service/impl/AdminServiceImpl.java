package com.xing.admin.service.impl;

import com.xing.admin.domain.Admin;
import com.xing.admin.mapper.AdminMapper;
import com.xing.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Qualifier("adminMapper")
    @Autowired
    private AdminMapper adminMapper;
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
        return adminMapper.findAdminById(admId);
    }

    @Override
    public List<Admin> findAllAdmin() {
        return adminMapper.findAllAdmin();
    }
}
