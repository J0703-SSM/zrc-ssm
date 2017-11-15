package com.xing.fee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资费管理控制器
 */
@Controller
public class FeeController {
    /**
     * 进入资费信息添加界面
     */
    @RequestMapping("/fee/fee_add")
    public String addFee(){
        return "/fee/fee_add";
    }
}
