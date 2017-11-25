package com.xing.base.controller;

import com.xing.admin.domain.Admin;
import com.xing.base.domain.PageBean;
import com.xing.fee.domain.Fee;
import com.xing.fee.service.FeeService;
import com.xing.role.domain.Permissions;
import com.xing.role.domain.Role;
import com.xing.admin.service.AdminService;
import com.xing.role.service.PermissionsService;
import com.xing.role.service.RoleService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Controller
public class MainController {
    @Qualifier("roleService")
    @Autowired
    private RoleService roleService;
    @Qualifier("adminService")
    @Autowired
    private AdminService adminService;
    @Qualifier("feeService")
    @Autowired
    private FeeService feeService;
    @Qualifier("permissionsService")
    @Autowired
    private PermissionsService permissionsService;
    /**
     * 登录之后显示主页面
     */
    @RequestMapping(value ="/index")
    public String index(){
        return "index";
    }

    /**
     * 进入系统默认进入登陆界面
     * @return
     */
    @RequestMapping(value = "/")
    public String main(){
        return "login";
    }

    /**
     * 登陆方法
     */
    @RequestMapping(value = "/login")
    public String login(
            Admin admin,
            HttpServletRequest request,
            Model model){
        Admin admin1 = adminService.login(admin.getAdmLoginName());
        if (admin1 != null && admin1.getAdmLoginPwd().equals(admin.getAdmLoginPwd())){
            request.getServletContext().setAttribute("admin",admin1);
            //登陆成功进入主界面
            return "index";
        }
        model.addAttribute("logmsg","账号密码错误");
        return "/login";
    }

    /**
     * 角色管理界面
     */
    @RequestMapping(value ="/role_list")
    public String role_list(PageBean<Role> pg,Model model){
        // 每次点击进入角色界面,进行查询所有角色
        /*
			1. 得到 pageCode
				> 如果pc参数不存在,pc=1
				> 如果pc存在,就转成int类型
		 */
        if (pg.getPageCode() == 0){
            pg.setPageCode(1);
        }
        pg = roleService.findAllRoleByPage(pg);
        model.addAttribute("roles",pg.getBeanList());
        model.addAttribute("pg",pg);
        return "role/role_list";
    }
    /**
     * 管理员界面
     */
    @RequestMapping(value ="/admin_list")
    public String admin_list(PageBean<Admin> pg,Model model){
        // 每次进入管理员界面,加载所有的管理员信息进行显示
        /*
			1. 得到 pageCode
				> 如果pc参数不存在,pc=1
				> 如果pc存在,就转成int类型
		 */
        if (pg.getPageCode() == 0){
            pg.setPageCode(1);
        }
        pg = adminService.findAllAdmin(pg);
        List<Permissions> pers = permissionsService.findAllPer();
        model.addAttribute("pers",pers);
        model.addAttribute("admins",pg.getBeanList());
        model.addAttribute("pg",pg);
        return "admin/admin_list";
    }
    /**
     * 资费管理界面
     */
    @RequestMapping(value ="/fee_list")
    public String fee_list(PageBean<Fee> pg,Model model){
        // 每次进入资费管理界面,加载所有的资费信息进行显示
        if (pg.getPageCode() == 0){
            pg.setPageCode(1);
        }
        pg = feeService.findAllFeeByPage(pg);
        model.addAttribute("fees",pg.getBeanList());
        model.addAttribute("pg",pg);
        return "fee/fee_list";
    }
    /**
     * 账务账号界面
     */
    @RequestMapping(value ="/account_list")
    public String account_list(){
        return "account/account_list";
    }
    /**
     * 业务账号界面
     */
    @RequestMapping(value ="/service_list")
    public String service_list(){
        return "service/service_list";
    }
    /**
     * 账单管理界面
     */
    @RequestMapping(value ="/bill_list")
    public String bill_list(){
        return "bill/bill_list";
    }
    /**
     * 报表界面
     */
    @RequestMapping(value ="/report_list")
    public String report_list(){
        return "report/report_list";
    }
    /**
     * 个人信息界面
     */
    @RequestMapping(value ="/user_info")
    public String user_info(){
        return "user/user_info";
    }
    /**
     * 修改密码界面
     */
    @RequestMapping(value ="/user_modi_pwd")
    public String user_modi_pwd(){
        return "user/user_modi_pwd";
    }

    private int getPc(String pageCode) {
		/*
			1. 得到 pageCode
				> 如果pc参数不存在,pc=1
				> 如果pc存在,就转成int类型
		 */
        if (pageCode == null || pageCode.trim().isEmpty()){
            return 1;
        }
        return Integer.parseInt(pageCode);
    }
}
