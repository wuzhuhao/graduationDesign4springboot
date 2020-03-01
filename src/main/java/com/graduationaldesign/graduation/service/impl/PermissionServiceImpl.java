package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.PermissionMapper;
import com.graduationaldesign.graduation.pojo.Permission;
import com.graduationaldesign.graduation.pojo.PermissionExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.PermissionService;
import com.graduationaldesign.graduation.util.PageBean;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public int insertSelective(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    @Override
    public Permission selectByPrimaryKey(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<Permission> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Permission> pageBean = new PageBean<>();
        PermissionExample example = new PermissionExample();
        PermissionExample.Criteria criteria = example.createCriteria();
        ExampleHelper.addCondition(Permission.class, criteria, params);
        List<Permission> list = this.permissionMapper.selectByExample(example);
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Long> lstPrimaryKey) throws Exception {
        PermissionExample example = new PermissionExample();
        PermissionExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        permissionMapper.deleteByExample(example);
    }
}
