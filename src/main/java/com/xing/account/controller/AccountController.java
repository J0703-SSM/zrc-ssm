package com.xing.account.controller;

import com.xing.account.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/11/17.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    /**
     * 进入业务账号添加界面
     * @return
     */
    @RequestMapping("/account_add")
    public String account_add(){
        return "account/account_add";
    }

    /**
     * 添加业务账号
     */
    @RequestMapping("/add")
    public String add(Account accName){
        System.out.println(accName);
        return "account/account_add";
    }

}
