package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.RoleMapper;
import com.graduationaldesign.graduation.pojo.Role;
import com.graduationaldesign.graduation.pojo.RoleExample;
import com.graduationaldesign.graduation.service.RoleService;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<Role> listByPage(HashMap<String, Object> params, int page, int pageSize) {
        PageBean<Role> pageBean = new PageBean<>();
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        List<Role> list = this.roleMapper.selectByExample(example);
        pageBean.setBeanList(list);
//        pageBean.setParams();
        return pageBean;
    }

}
