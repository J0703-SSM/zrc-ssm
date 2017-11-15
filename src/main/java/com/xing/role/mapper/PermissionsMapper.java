package com.xing.role.mapper;

import com.xing.role.domain.Permissions;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface PermissionsMapper {
    /**
     * 添加一个权限
     * @param permissions 添加的权限
     */
    void addPermissions(Permissions permissions);

    /**
     * 查询所有权限
     * @return 返回权限集合
     */
    List<Permissions> findAllPer();
}
