package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.OperationMapper;
import com.graduationaldesign.graduation.pojo.Operation;
import com.graduationaldesign.graduation.pojo.OperationExample;
import com.graduationaldesign.graduation.service.OperationService;
import com.graduationaldesign.graduation.util.PageBean;
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
    public PageBean<Operation> listByPage(HashMap<String, Object> params, int page, int pageSize) {
        PageBean<Operation> pageBean = new PageBean<>();
        OperationExample example = new OperationExample();
        OperationExample.Criteria criteria = example.createCriteria();
        List<Operation> list = this.operationMapper.selectByExample(example);
        pageBean.setBeanList(list);
//        pageBean.setParams();
        return pageBean;
    }

}
