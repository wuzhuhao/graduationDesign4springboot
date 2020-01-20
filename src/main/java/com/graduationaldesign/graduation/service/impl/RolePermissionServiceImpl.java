package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.RolePermissionMapper;
import com.graduationaldesign.graduation.pojo.RolePermission;
import com.graduationaldesign.graduation.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return rolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RolePermission record) {
        return rolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(RolePermission record) {
        return rolePermissionMapper.insertSelective(record);
    }

    @Override
    public RolePermission selectByPrimaryKey(Long id) {
        return rolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RolePermission record) {
        return rolePermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RolePermission record) {
        return rolePermissionMapper.updateByPrimaryKey(record);
    }

}
