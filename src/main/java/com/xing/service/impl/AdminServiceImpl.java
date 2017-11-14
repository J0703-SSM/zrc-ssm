package com.xing.service.impl;

import com.xing.domin.Admin;
import com.xing.mapper.AdminMapper;
import com.xing.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
        adminMapper.addAdmin(admin);
        adminMapper.addAdmin_Rol(admin);
    }
}
