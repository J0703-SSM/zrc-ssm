package com.xing.role.service.impl;

import com.xing.role.domain.Permissions;
import com.xing.role.mapper.PermissionsMapper;
import com.xing.role.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Service("permissionsService")
public class PermissionsServiceImpl implements PermissionsService {
    @Qualifier("permissionsMapper")
    @Autowired
    private PermissionsMapper permissionsMapper;
    @Override
    public List<Permissions> findAllPer() {
        return permissionsMapper.findAllPer();
    }
}
