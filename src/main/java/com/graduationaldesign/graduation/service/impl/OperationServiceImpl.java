package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.OperationMapper;
import com.graduationaldesign.graduation.pojo.Operation;
import com.graduationaldesign.graduation.pojo.OperationExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.OperationService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:11
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Resource
    private OperationMapper operationMapper;
    @Autowired
    RootPropeties rootPropeties;

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
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<Operation> pageBean = new PageBean<>();
        OperationExample example = new OperationExample();
        OperationExample.Criteria criteria = example.createCriteria();
        ExampleHelper.searchJoin(Operation.class, example, criteria, params);
        ExampleHelper.addCondition(Operation.class, criteria, params);
        List<Operation> list = this.operationMapper.selectByExampleWithBLOBs(example);
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

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Operation> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getOperation());
        try {
            operationMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getOperation());
        }
        return ResponseStatus.success(message);
    }
}
