package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.OperationMapper;
import com.graduationaldesign.graduation.pojo.Operation;
import com.graduationaldesign.graduation.service.OperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

}
