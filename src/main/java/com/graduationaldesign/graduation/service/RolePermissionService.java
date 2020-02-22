package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.RolePermission;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
public interface RolePermissionService {

    int deleteByPrimaryKey(Long id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    PageBean<RolePermission> listByPage(HashMap<String, Object> params, int page, int pageSize);

}
