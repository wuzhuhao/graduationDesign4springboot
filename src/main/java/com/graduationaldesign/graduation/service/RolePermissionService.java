package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.RolePermission;

/**
* @Author: wuzhuhao
* @Date: 2020/1/20 21:09
*/
public interface RolePermissionService{


int deleteByPrimaryKey(Long id);

int insert(RolePermission record);

int insertSelective(RolePermission record);

RolePermission selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(RolePermission record);

int updateByPrimaryKey(RolePermission record);

}
