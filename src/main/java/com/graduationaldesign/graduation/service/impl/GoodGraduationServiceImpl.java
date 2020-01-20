package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.GoodGraduationMapper;
import com.graduationaldesign.graduation.pojo.GoodGraduation;
import com.graduationaldesign.graduation.service.GoodGraduationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
@Service
public class GoodGraduationServiceImpl implements GoodGraduationService {

    @Resource
    private GoodGraduationMapper goodGraduationMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodGraduationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodGraduation record) {
        return goodGraduationMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodGraduation record) {
        return goodGraduationMapper.insertSelective(record);
    }

    @Override
    public GoodGraduation selectByPrimaryKey(Integer id) {
        return goodGraduationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodGraduation record) {
        return goodGraduationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodGraduation record) {
        return goodGraduationMapper.updateByPrimaryKey(record);
    }

}
