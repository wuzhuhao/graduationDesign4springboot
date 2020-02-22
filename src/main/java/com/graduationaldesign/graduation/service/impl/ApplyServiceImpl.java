package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.ApplyMapper;
import com.graduationaldesign.graduation.pojo.Apply;
import com.graduationaldesign.graduation.pojo.ApplyExample;
import com.graduationaldesign.graduation.service.ApplyService;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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

    @Override
    public PageBean<Apply> listByPage(HashMap<String, Object> params, int page, int pageSize) {
        PageBean<Apply> pageBean = new PageBean<>();
        ApplyExample example = new ApplyExample();
        ApplyExample.Criteria criteria = example.createCriteria();
        List<Apply> list = this.applyMapper.selectByExample(example);
        pageBean.setBeanList(list);
//        pageBean.setParams();
        return pageBean;
    }
}
