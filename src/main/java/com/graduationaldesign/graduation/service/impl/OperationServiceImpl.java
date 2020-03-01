package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.OperationMapper;
import com.graduationaldesign.graduation.pojo.Operation;
import com.graduationaldesign.graduation.pojo.OperationExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.OperationService;
import com.graduationaldesign.graduation.util.PageBean;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:11
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Resource
    private OperationMapper operationMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return operationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Operation record) {
        return operationMapper.insert(record);
    }

    @Override
    public int insertSelective(Operation record) {
        return operationMapper.insertSelective(record);
    }

    @Override
    public Operation selectByPrimaryKey(Integer id) {
        return operationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Operation record) {
        return operationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Operation record) {
        return operationMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<Operation> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Operation> pageBean = new PageBean<>();
        OperationExample example = new OperationExample();
        OperationExample.Criteria criteria = example.createCriteria();
        ExampleHelper.addCondition(Operation.class, criteria, params);
        List<Operation> list = this.operationMapper.selectByExample(example);
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        OperationExample example = new OperationExample();
        OperationExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        operationMapper.deleteByExample(example);
    }

}
