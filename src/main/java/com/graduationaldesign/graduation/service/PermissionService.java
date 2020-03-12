package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Permission;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
public interface PermissionService {

    void deleteByPrimaryKeyIn(List<Long> lstprimaryKey) throws Exception;

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    PageBean<Permission> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Permission> lstRecord);


}
