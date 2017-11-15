package com.xing.role.controller;

import com.xing.role.domain.Permissions;
import com.xing.role.domain.Role;
import com.xing.role.service.PermissionsService;
import com.xing.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 角色管理控制器
 * Created by dllo on 17/11/11.
 */
@Controller
public class RoleController {
    @Qualifier("roleService")
    @Autowired
    private RoleService roleService;
    @Qualifier("permissionsService")
    @Autowired
    private PermissionsService permissionsService;
    /**
     * 转跳添加角色界面
     */
    @RequestMapping(value = "/role/role_add")
    public String role_add(){
        return "role/role_add";
    }

    /**
     * 进行角色添加
     */
    @RequestMapping(value ="/role/add")
    public String add(String rolName,String[] perId){
        String a = UUID.randomUUID().toString();
        String b = a.substring(0,4);
        String c = a.substring(a.length()-4,a.length());
        // 截取UUId前4位和后四位当做id
        a = b + c ;
        Role role = new Role(a,rolName);
        List<Permissions> ps = new ArrayList<Permissions>();
        for (String s : perId) {
            Permissions permissions = new Permissions(s);
            ps.add(permissions);
        }
        role.setPerList(ps);
        roleService.addRole(role);
        return "/role/role_add";
    }

    /**
     * 转跳角色修改界面
     */
    @RequestMapping(value ="/role/role_modi")
    public String role_modi(String rolId, Model model){
        Role role = roleService.findRoleById(rolId);
        model.addAttribute("role",role);
        return "role/role_modi";
    }

    /**
     * 进入界面时加载全部的权限
     * @return 返回保存为json的权限
     */
    @ResponseBody
    @RequestMapping(value = "/role/findAllPer")
    public List<Permissions> findAllPerInRoleModi(){
        return permissionsService.findAllPer();
    }

    /**
     * 修改角色
     */
    @RequestMapping(value = "/role/updateRole")
    public String updateRole(Role role,String[] perId){
        Role newRole = roleService.findRoleById(role.getRolId());
        // 如果查询出来的角色名和目前的不同
        if (!newRole.getRolName().equals(role.getRolName())){
            //则修改角色名
            roleService.updateRole(role);
        }
        // 如果查询出来的角色权限数与目前的不等
        if (newRole.getPerList().size() != perId.length){
            // 则直接修改权限集合
            // 先删除全部
            roleService.deleteAllRole_Per(role.getRolId());
            // 再添加新关系
            List<Permissions> ps = new ArrayList<Permissions>();
            for (String s : perId) {
                Permissions permissions = new Permissions(s);
                ps.add(permissions);
            }
            role.setPerList(ps);
            roleService.addRole(role);
        }
        return "role/role_modi";
    }
}
