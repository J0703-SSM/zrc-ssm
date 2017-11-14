package com.xing.controller;

import com.xing.domin.Role;
import com.xing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Controller
public class MainController {
    @Qualifier("roleService")
    @Autowired
    private RoleService roleService;
    /**
     * 登录之后显示主页面
     */
    @RequestMapping(value ="/index")
    public String index(){
        return "index";
    }

    /**
     * 角色管理界面
     */
    @RequestMapping(value ="/role/role_list")
    public String role_list(Model model){
        // 每次点击进入角色界面,进行查询所有角色
        List<Role> roles = roleService.findAllRole();
        model.addAttribute("roles",roles);
        return "role/role_list";
    }

    /**
     * 管理员界面
     */
    @RequestMapping(value ="/admin/admin_list")
    public String admin_list(){
        return "admin/admin_list";
    }
    /**
     * 资费管理界面
     */
    @RequestMapping(value ="/fee/fee_list")
    public String fee_list(){
        return "fee/fee_list";
    }
    /**
     * 账务账号界面
     */
    @RequestMapping(value ="/account/account_list")
    public String account_list(){
        return "account/account_list";
    }
    /**
     * 业务账号界面
     */
    @RequestMapping(value ="/service/service_list")
    public String service_list(){
        return "service/service_list";
    }
    /**
     * 账单管理界面
     */
    @RequestMapping(value ="/bill/bill_list")
    public String bill_list(){
        return "bill/bill_list";
    }
    /**
     * 报表界面
     */
    @RequestMapping(value ="/report/report_list")
    public String report_list(){
        return "report/report_list";
    }
    /**
     * 个人信息界面
     */
    @RequestMapping(value ="/user/user_info")
    public String user_info(){
        return "user/user_info";
    }
    /**
     * 修改密码界面
     */
    @RequestMapping(value ="/user/user_modi_pwd")
    public String user_modi_pwd(){
        return "user/user_modi_pwd";
    }

}
