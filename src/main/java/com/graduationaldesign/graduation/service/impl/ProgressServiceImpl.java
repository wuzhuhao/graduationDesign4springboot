package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.ProgressMapper;
import com.graduationaldesign.graduation.pojo.Progress;
import com.graduationaldesign.graduation.service.ProgressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
@Service
public class ProgressServiceImpl implements ProgressService {

    @Resource
    private ProgressMapper progressMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return progressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Progress record) {
        return progressMapper.insert(record);
    }

    @Override
    public int insertSelective(Progress record) {
        return progressMapper.insertSelective(record);
    }

    @Override
    public Progress selectByPrimaryKey(Integer id) {
        return progressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Progress record) {
        return progressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Progress record) {
        return progressMapper.updateByPrimaryKey(record);
    }

}
