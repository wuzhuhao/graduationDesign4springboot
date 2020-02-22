package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.GoodGraduationMapper;
import com.graduationaldesign.graduation.pojo.GoodGraduation;
import com.graduationaldesign.graduation.pojo.GoodGraduationExample;
import com.graduationaldesign.graduation.service.GoodGraduationService;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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

    @Override
    public PageBean<GoodGraduation> listByPage(HashMap<String, Object> params, int page,
            int pageSize) {
        PageBean<GoodGraduation> pageBean = new PageBean<>();
        GoodGraduationExample example = new GoodGraduationExample();
        GoodGraduationExample.Criteria criteria = example.createCriteria();
        List<GoodGraduation> list = this.goodGraduationMapper.selectByExample(example);
        pageBean.setBeanList(list);
//        pageBean.setParams();
        return pageBean;
    }

}
