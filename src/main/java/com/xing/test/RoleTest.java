package com.xing.test;

import com.xing.domin.Permissions;
import com.xing.domin.Role;
import com.xing.mapper.RoleMapper;
import com.xing.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dllo on 17/11/11.
 */
public class RoleTest {
    private ApplicationContext context;
    @Qualifier("roleMapper")
    @Autowired
    private RoleMapper roleMapper;
    @Qualifier("roleService")
    @Autowired
    private RoleService roleService;


    @Before
    public void init(){
        /*启动spring容器*/
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        roleMapper = context.getBean(RoleMapper.class);
        roleService = context.getBean(RoleService.class);
    }

    /**
     * 添加信息测试
     */
    @Test
    public void addInfo(){
        String a = String.valueOf(UUID.randomUUID());
        String b = a.substring(0,4);
        String c = a.substring(a.length()-4,a.length());
        a = b + c ;
        String rolName = "张三";
        List<String> list = new ArrayList<String>();
        List<Permissions> ps = new ArrayList<Permissions>();
        list.add("acc");
        list.add("adm");
        list.add("rol");
        Role role = new Role(a,rolName);
        for (String s : list) {
            Permissions permissions = new Permissions(s);
            ps.add(permissions);
        }
        role.setPerList(ps);
        roleMapper.addRole(role);
        roleMapper.addRole_Per(role);
    }

    /**
     * 查询所有角色测试类
     */
    @Test
    public void findAllRoleTest(){
        List<Role> roles = roleMapper.findAllRole();
        for (Role role : roles) {
            System.out.println("***************");
            System.out.println(role);
            for (Permissions permissions : role.getPerList()) {
                System.out.println(permissions);
            }
        }
    }
    /**
     * 根据id查询role
     */
    @Test
    public void findRoleById(){
        Role role = roleMapper.findRoleById("7491b79d");
        System.out.println(role);
    }
}
