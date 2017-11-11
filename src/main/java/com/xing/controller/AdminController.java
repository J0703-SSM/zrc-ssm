package com.xing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员控制器
 * Created by dllo on 17/11/11.
 */
@Controller
public class AdminController {
    /**
     * 进入添加管理员界面
     */
    @RequestMapping("/admin/admin_add")
    public String admin_add(){
        return "admin/admin_add";
    }
}
