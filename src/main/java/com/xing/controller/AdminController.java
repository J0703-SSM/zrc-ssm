package com.xing.controller;

import com.xing.domin.Admin;
import com.xing.domin.Role;
import com.xing.service.AdminService;
import com.xing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 管理员控制器
 * Created by dllo on 17/11/11.
 */
@Controller
public class AdminController {
    @Qualifier("adminService")
    @Autowired
    private AdminService adminService;
    @Qualifier("roleService")
    @Autowired
    private RoleService roleService;
    /**
     * 进入添加管理员界面
     */
    @RequestMapping("/admin/admin_add")
    public String admin_add(){
        return "admin/admin_add";
    }
    /**
     * 添加管理员
     */
    @RequestMapping("/admin/add")
    public String addAdmin(Admin admin,String[] rolId){
        // 取UUID前4后4作为id
        String a = String.valueOf(UUID.randomUUID());
        String b = a.substring(0,4);
        String c = a.substring(a.length()-4,a.length());
        a = b + c ;
        admin.setAdmId(a);
        // 取当前时间作为授权时间
        admin.setAuthorizationTime(new Date());
        return "admin/admin_add";
    }
    /**
     * 进入界面时候加载全部的角色
     */
    @ResponseBody
    @RequestMapping("/admin/findAllRol")
    public List<Role> findAllRole(){
        return roleService.findAllRole();
    }
}
