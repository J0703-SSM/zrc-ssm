package com.xing.fee.controller;

import com.xing.base.response.AjaxLoginResult;
import com.xing.fee.domain.Fee;
import com.xing.fee.domain.Fee2;
import com.xing.fee.domain.Fee3;
import com.xing.fee.service.FeeService;
import com.xing.fee.validationGroup.ValidationGroup1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资费管理控制器
 */
@Controller
public class FeeController {
    @Qualifier("feeService")
    @Autowired
    private FeeService feeService;
    /**
     * 进入资费信息添加界面
     */
    @RequestMapping("/fee/fee_add")
    public String addFee() {
        return "/fee/fee_add";
    }

    /**
     * 添加资费信息
     */
    @RequestMapping("/fee/add")
    public String add(
            @Validated Fee fee,
            BindingResult result,
            Model model) {
        System.out.println(fee);
        if (result.hasErrors()) {
            // 获取某个属性的错误信息
            FieldError feeNameError = result.getFieldError("feeName");
            FieldError basicTimeError = result.getFieldError("basicTime");
            FieldError basicCostError = result.getFieldError("basicCost");
            FieldError unitCostError = result.getFieldError("unitCost");
            model.addAttribute("feeNameError",feeNameError);
            model.addAttribute("basicTimeError",basicTimeError);
            model.addAttribute("basicCostError",basicCostError);
            model.addAttribute("unitCostError",unitCostError);
            return "/fee/fee_add";
        }
        addFee(fee);
        return "/fee/fee_add";
    }

    @RequestMapping("/fee/add1")
    public String add(
            @Validated Fee2 fee,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            // 获取某个属性的错误信息
            FieldError feeNameError = result.getFieldError("feeName");
            FieldError basicCostError = result.getFieldError("basicCost");
            model.addAttribute("feeNameError",feeNameError);
            model.addAttribute("basicCostError",basicCostError);
            return "/fee/fee_add";
        }
        Fee fee1 = new Fee();
        fee1.setFeeName(fee.getFeeName());
        fee1.setBasicCost(fee.getBasicCost());
        addFee(fee1);
        return "/fee/fee_add";
    }

    @RequestMapping("/fee/add3")
    public String add(
            @Validated Fee3 fee,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            // 获取某个属性的错误信息
            FieldError feeNameError = result.getFieldError("feeName");
            FieldError unitCostError = result.getFieldError("unitCost");
            model.addAttribute("feeNameError",feeNameError);
            model.addAttribute("unitCostError",unitCostError);
            return "/fee/fee_add";
        }
        Fee fee1 = new Fee();
        fee1.setFeeName(fee.getFeeName());
        fee1.setUnitCost(fee.getUnitCost());
        addFee(fee1);
        return "/fee/fee_add";
    }
    @ResponseBody
    @RequestMapping("/fee/order")
    public List<Fee> order(Model model){
        List<Fee> fees =  feeService.findFeeOrderByDESC();
        model.addAttribute("fees",fees);
        return fees;
    }

    @ResponseBody
    @RequestMapping("/fee/fee_delete")
    public Map<String, Object> deleteCost(int feeId) {
        Map<String, Object> map = new HashMap<String, Object>();
        int result = feeService.deleteFeeById(feeId);
        if (result > 0) {
            map.put("msg", "删除成功");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }
    private void addFee(Fee fee){
        fee.setNewTime(new Date());
        feeService.addFee(fee);
    }

    @ResponseBody
    @RequestMapping("/fee/fee_open")
    public Map<String, Object> openFee(Fee fee) {
        Map<String, Object> map = new HashMap<String, Object>();
        fee.setOpenTime(new Date());
        fee.setState(1);
        int result = feeService.openFee(fee);
        if (result > 0) {
            map.put("msg", "启动成功");
        } else {
            map.put("msg", "启动失败");
        }
        return map;
    }


}
