package com.xing.test;

import com.xing.domin.Admin;
import com.xing.domin.Role;
import com.xing.service.AdminService;
import com.xing.service.PermissionsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
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

}
