package com.xing.test;

import com.xing.domain.Permissions;
import com.xing.mapper.PermissionsMapper;
import com.xing.mapper.RoleMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.UUID;

/**
 * Created by dllo on 17/11/11.
 */
public class MainTest {
    private ApplicationContext context;
//    @Qualifier("permissionsMapper")
//    @Autowired
//    private PermissionsMapper permissionsMapper;


    @Before
    public void init(){
        /*启动spring容器*/
        context = new ClassPathXmlApplicationContext("spring-config.xml");
//        permissionsMapper = context.getBean(PermissionsMapper.class);
    }

    /**
     * 添加信息测试
     */
    @Test
    public void addInfo(){
        String  a = String.valueOf(UUID.randomUUID());
        System.out.println(context);
        System.out.println(a);
    }
}
