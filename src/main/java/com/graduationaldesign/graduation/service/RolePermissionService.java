package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.RolePermission;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

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

    PageBean<RolePermission> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;

    void deleteByPrimaryKeyIn(List<Long> lstprimaryKey) throws Exception;

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<RolePermission> lstRecord);

}
