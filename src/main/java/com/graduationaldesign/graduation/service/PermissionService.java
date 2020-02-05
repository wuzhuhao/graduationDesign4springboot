package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Permission;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
public interface PermissionService {

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

}
