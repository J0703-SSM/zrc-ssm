package com.xing.test;

import com.xing.role.domain.Permissions;
import com.xing.role.service.PermissionsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PerTest {
    private ApplicationContext context;
    @Qualifier("permissionsService")
    @Autowired
    private PermissionsService permissionsService;
    @Before
    public void init(){
        /*启动spring容器*/
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        permissionsService = context.getBean(PermissionsService.class);
    }
    /**
     * 查询所有权限测试
     */
    @Test
    public void findAllPer(){
        List<Permissions> perList = permissionsService.findAllPer();
        for (Permissions permissions : perList) {
            System.out.println(permissions);
        }
    }
}
