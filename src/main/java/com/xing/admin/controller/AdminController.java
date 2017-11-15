package com.xing.admin.controller;

import com.xing.admin.domain.Admin;
import com.xing.role.domain.Role;
import com.xing.admin.service.AdminService;
import com.xing.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 管理员控制器
 * Created by dllo on 17/11/11.
 */
@Controller
public class AdminController {
    @Qualifier("adminService")
    @Autowired
    private AdminService adminService;
    @Qualifier("roleService")
    @Autowired
    private RoleService roleService;
    /**
     * 进入添加管理员界面
     */
    @RequestMapping("/admin/admin_add")
    public String admin_add(){
        return "admin/admin_add";
    }
    /**
     * 添加管理员
     */
    @RequestMapping("/admin/add")
    public String addAdmin(
            @Validated
            Admin admin,
            BindingResult result,
            String[] rolId,
            Model model){
        if (result.hasErrors()) {
            // 获取某个属性的错误信息
            FieldError admNameError = result.getFieldError("admName");
            FieldError admLoginNameError = result.getFieldError("admLoginName");
            FieldError admLoginPwdError = result.getFieldError("admLoginPwd");
            FieldError admPhoneError = result.getFieldError("admPhone");
            FieldError admEmailError = result.getFieldError("admEmail");
            /* 输入验证错误信息回显 */
            model.addAttribute("naError", admNameError);
            model.addAttribute("lnError", admLoginNameError);
            model.addAttribute("lpError", admLoginPwdError);
            model.addAttribute("phError", admPhoneError);
            model.addAttribute("emError", admEmailError);
            if (!admin.getAdmLoginPwd().equals(admin.getAdmLoginPwd2()) || rolId == null){
                // 再次进行判断两个到底是那个错了,或者都错
                if (!admin.getAdmLoginPwd().equals(admin.getAdmLoginPwd2())){
                    model.addAttribute("lp2Error","两次密码输入不一致,请重新输入");
                }
                if (rolId == null){
                    model.addAttribute("rolError","至少选择一个角色");
                }
            }
            return "admin/admin_add";
        }
        // 二次密码不同或者角色没有选择进入
        if (!admin.getAdmLoginPwd().equals(admin.getAdmLoginPwd2()) || rolId == null){
            // 再次进行判断两个到底是那个错了,或者都错
            if (!admin.getAdmLoginPwd().equals(admin.getAdmLoginPwd2())){
                model.addAttribute("lp2Error","两次密码输入不一致,请重新输入");
            }
            if (rolId == null){
                model.addAttribute("rolError","至少选择一个角色");
            }
            return "admin/admin_add";
        }
        // 取UUID前4后4作为id
        String a = String.valueOf(UUID.randomUUID());
        String b = a.substring(0,4);
        String c = a.substring(a.length()-4,a.length());
        a = b + c ;
        admin.setAdmId(a);
        // 取当前时间作为授权时间
        admin.setAuthorizationTime(new Date());
        // 创建一个集合存角色
        List<Role> roles = new ArrayList<Role>();
        // 遍历获取到的角色id
        for (String s : rolId) {
            // 生成角色对象
            Role role = new Role();
            role.setRolId(s);
            roles.add(role);
        }
        // 将角色集合存入管理员信息中
        admin.setRolList(roles);
        // 保存管理员信息
        adminService.addAdmin(admin);
        return "admin/admin_add";
    }
    /**
     * 进入界面时候加载全部的角色
     */
    @ResponseBody
    @RequestMapping("/admin/findAllRol")
    public List<Role> findAllRole(){
        return roleService.findAllRole();
    }
}
