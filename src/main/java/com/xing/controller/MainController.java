package com.xing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 17/11/11.
 */
@Controller
public class MainController {
    /**
     * 登录之后显示主页面
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 角色管理界面
     */
    @RequestMapping("/role/role_list")
    public String role_list(){
        return "role/role_list";
    }

    /**
     * 管理员界面
     */
    @RequestMapping("/admin/admin_list")
    public String admin_list(){
        return "admin/admin_list";
    }
    /**
     * 资费管理界面
     */
    @RequestMapping("/fee/fee_list")
    public String fee_list(){
        return "fee/fee_list";
    }
    /**
     * 账务账号界面
     */
    @RequestMapping("/account/account_list")
    public String account_list(){
        return "/account/account_list";
    }
    /**
     * 业务账号界面
     */
    @RequestMapping("/service/service_list")
    public String service_list(){
        return "service/service_list";
    }
    /**
     * 账单管理界面
     */
    @RequestMapping("/bill/bill_list")
    public String bill_list(){
        return "bill/bill_list";
    }
    /**
     * 报表界面
     */
    @RequestMapping("/report/report_list")
    public String report_list(){
        return "report/report_list";
    }
    /**
     * 个人信息界面
     */
    @RequestMapping("/user/user_info")
    public String user_info(){
        return "user/user_info";
    }
    /**
     * 修改密码界面
     */
    @RequestMapping("/user/user_modi_pwd")
    public String user_modi_pwd(){
        return "/user/user_modi_pwd";
    }

}
