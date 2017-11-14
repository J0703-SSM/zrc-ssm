package com.xing.service.impl;

import com.xing.domin.Permissions;
import com.xing.mapper.PermissionsMapper;
import com.xing.service.PermissionsService;
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
