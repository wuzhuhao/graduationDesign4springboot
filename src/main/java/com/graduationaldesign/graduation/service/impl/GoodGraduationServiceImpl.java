package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.GoodGraduationMapper;
import com.graduationaldesign.graduation.pojo.GoodGraduation;
import com.graduationaldesign.graduation.pojo.GoodGraduationExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.GoodGraduationService;
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
 * @Date: 2020/1/20 21:09
 */
@Service
public class GoodGraduationServiceImpl implements GoodGraduationService {

    @Resource
    private GoodGraduationMapper goodGraduationMapper;
    @Autowired
    RootPropeties rootPropeties;

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
                                               int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<GoodGraduation> pageBean = new PageBean<>();
        GoodGraduationExample example = new GoodGraduationExample();
        GoodGraduationExample.Criteria criteria = example.createCriteria();
        ExampleHelper.searchJoin(GoodGraduation.class, example, criteria, params);
        ExampleHelper.addCondition(GoodGraduation.class, criteria, params);
        List<GoodGraduation> list = this.goodGraduationMapper.selectByExampleWithBLOBs(example);
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        GoodGraduationExample example = new GoodGraduationExample();
        GoodGraduationExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        goodGraduationMapper.deleteByExample(example);
    }

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<GoodGraduation> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getGoodGraduation());
        try {
            goodGraduationMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getGoodGraduation());
        }
        return ResponseStatus.success(message);
    }
}
