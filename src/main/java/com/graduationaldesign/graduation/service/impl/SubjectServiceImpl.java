package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.SubjectMapper;
import com.graduationaldesign.graduation.pojo.Subject;
import com.graduationaldesign.graduation.service.SubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:10
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;

    @Override
    public int deleteByPrimaryKey(String subId) {
        return subjectMapper.deleteByPrimaryKey(subId);
    }

    @Override
    public int insert(Subject record) {
        return subjectMapper.insert(record);
    }

    @Override
    public int insertSelective(Subject record) {
        return subjectMapper.insertSelective(record);
    }

    @Override
    public Subject selectByPrimaryKey(String subId) {
        return subjectMapper.selectByPrimaryKey(subId);
    }

    @Override
    public int updateByPrimaryKeySelective(Subject record) {
        return subjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Subject record) {
        return subjectMapper.updateByPrimaryKey(record);
    }

}
