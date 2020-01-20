package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.DesignShowMapper;
import com.graduationaldesign.graduation.pojo.DesignShow;
import com.graduationaldesign.graduation.service.DesignShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:15
 */
@Service
public class DesignShowServiceImpl implements DesignShowService {

    @Resource
    private DesignShowMapper designShowMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return designShowMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DesignShow record) {
        return designShowMapper.insert(record);
    }

    @Override
    public int insertSelective(DesignShow record) {
        return designShowMapper.insertSelective(record);
    }

    @Override
    public DesignShow selectByPrimaryKey(Integer id) {
        return designShowMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DesignShow record) {
        return designShowMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DesignShow record) {
        return designShowMapper.updateByPrimaryKey(record);
    }

}
