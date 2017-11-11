package com.xing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 角色管理控制器
 * Created by dllo on 17/11/11.
 */
@Controller
public class RoleController {

    /**
     * 转跳添加用户界面
     */
    @RequestMapping("/role/role_add")
    public String role_add(){
        return "role/role_add";
    }
}
