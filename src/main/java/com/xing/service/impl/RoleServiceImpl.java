package com.xing.service.impl;

import com.xing.domin.Role;
import com.xing.mapper.RoleMapper;
import com.xing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by dllo on 17/11/12.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService  {
    @Qualifier("roleMapper")
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public void addRole(Role role) {
        if (roleMapper.findRoleById(role.getRolId()) == null){
            roleMapper.addRole(role);
        }
        roleMapper.addRole_Per(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public void deleteAllRole_Per(String rolId) {
        roleMapper.deleteAllRole_Per(rolId);
    }

    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    @Override
    public Role findRoleById(String rolId) {
        return roleMapper.findRoleById(rolId);
    }
}
