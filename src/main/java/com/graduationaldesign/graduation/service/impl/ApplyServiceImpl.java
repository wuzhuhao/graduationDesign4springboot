package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.ApplyMapper;
import com.graduationaldesign.graduation.pojo.Apply;
import com.graduationaldesign.graduation.service.ApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:05
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Resource
    private ApplyMapper applyMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return applyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Apply record) {
        return applyMapper.insert(record);
    }

    @Override
    public int insertSelective(Apply record) {
        return applyMapper.insertSelective(record);
    }

    @Override
    public Apply selectByPrimaryKey(Integer id) {
        return applyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Apply record) {
        return applyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Apply record) {
        return applyMapper.updateByPrimaryKey(record);
    }

}
