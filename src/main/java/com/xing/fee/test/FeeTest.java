package com.xing.fee.test;

import com.xing.fee.domain.Fee;
import com.xing.fee.service.FeeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/15.
 */
public class FeeTest {
    private ApplicationContext context;
    @Qualifier("feeService")
    @Autowired
    private FeeService feeService;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        feeService = context.getBean(FeeService.class);
    }
    /**
     * 添加资费信息测试
     */
    @Test
    public void addFee(){
        Fee fee = new Fee();
        fee.setFeeKind(1);
        fee.setBasicCost("50");
        fee.setContent("这是一个包月50块的服务器,性能还行");
        feeService.addFee(fee);
    }
    /**
     * 查询所有Fee信息测试
     */
    @Test
    public void findAllFee(){
        for (Fee fee : feeService.findAllFee()) {
            System.out.println(fee);
        }
    }
}
