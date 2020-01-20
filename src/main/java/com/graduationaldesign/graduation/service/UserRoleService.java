package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.UserRole;

/**
* @Author: wuzhuhao
* @Date: 2020/1/20 21:10
*/
public interface UserRoleService{


int deleteByPrimaryKey(Long id);

int insert(UserRole record);

int insertSelective(UserRole record);

UserRole selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(UserRole record);

int updateByPrimaryKey(UserRole record);

}
