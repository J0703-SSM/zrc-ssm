package com.xing.admin.test;

import com.xing.admin.domain.Admin;
import com.xing.role.domain.Permissions;
import com.xing.role.domain.Role;
import com.xing.admin.service.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by dllo on 17/11/13.
 */
public class AdminTest {
    private ApplicationContext context;
    @Qualifier("adminService")
    @Autowired
    private AdminService adminService;
    @Before
    public void init(){
        /*启动spring容器*/
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        adminService = context.getBean(AdminService.class);
    }
    /**
     * 添加管理员测试类
     */
    @Test
    public void addAdmin(){
        String a = String.valueOf(UUID.randomUUID());
        String b = a.substring(0,4);
        String c = a.substring(a.length()-4,a.length());
        a = b + c ;
        System.out.println(new Date());
        Admin admin = new Admin(a,"测试管理员1号","zhang","456","112830584","a324566@qq.com",new Date());
        Role role = new Role();
        Role role2 = new Role();
        role.setRolId("f2f52886");
        role2.setRolId("7491b79d");
        List<Role> rs = new ArrayList<Role>();
        rs.add(role);
        rs.add(role2);
        admin.setRolList(rs);
        adminService.addAdmin(admin);
    }

    /**
     * 根据id查询管理员带出它所有的信息测试
     */
    @Test
    public void findById(){
        Admin admin =  adminService.findAdminById("39743f05");
        System.out.println(admin);
        for (Role role : admin.getRolList()) {
            System.out.println(role);
            for (Permissions permissions : role.getPerList()) {
                System.out.println(permissions);
            }
        }
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll(){
        List<Admin> admins = adminService.findAllAdmin();
        for (Admin admin : admins) {
            System.out.println(admin);
            for (Role role : admin.getRolList()) {
                System.out.println(role);
                for (Permissions permissions : role.getPerList()) {
                    System.out.println(permissions);
                }
            }
        }
    }

}
