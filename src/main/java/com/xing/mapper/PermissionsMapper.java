package com.xing.mapper;

import com.xing.domain.Permissions;

/**
 * Created by dllo on 17/11/11.
 */
public interface PermissionsMapper {
    /**
     * 添加一个权限
     * @param permissions 添加的权限
     */
    void addPermissions(Permissions permissions);
}
