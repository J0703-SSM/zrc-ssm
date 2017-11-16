package com.xing.role.service.impl;

import com.xing.base.domain.PageBean;
import com.xing.role.domain.Role;
import com.xing.role.service.RoleService;
import com.xing.role.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by dllo on 17/11/12.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
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

    @Override
    public PageBean<Role> findAllRoleByPage(PageBean<Role> pageBean) {
        pageBean.setTotalRecode(roleMapper.findAllCountByPage());
        pageBean.setStart((pageBean.getPageCode() - 1) * pageBean.getPageSize());
        pageBean.setBeanList(roleMapper.findAllRoleByPage(pageBean));
        return pageBean;
    }
}
