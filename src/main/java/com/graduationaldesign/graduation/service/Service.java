package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.mapper.Mapper;
import com.graduationaldesign.graduation.pojo.Example;
import com.graduationaldesign.graduation.pojo.ScoreRecord;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/3/30 0030 22:16
 */
public abstract class Service<T, R extends Example, M extends Mapper> {
    @Autowired
    R example;
    @Autowired
    M mapper;

    public List<T> selectByParam(Map<String, Object> params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object criteria = example.createCriteria();
        ExampleHelper.addCondition(ScoreRecord.class, criteria, params);
        List<T> list = mapper.selectByExample(example);
        return list;
    }
}
