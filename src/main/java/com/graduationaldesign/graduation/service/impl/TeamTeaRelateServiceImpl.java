package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.TeamTeaRelateMapper;
import com.graduationaldesign.graduation.pojo.TeamTeaRelate;
import com.graduationaldesign.graduation.pojo.TeamTeaRelateExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.TeamTeaRelateService;
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
 * @Date: 2020/3/28 0028 23:30
 */
@Service
public class TeamTeaRelateServiceImpl implements TeamTeaRelateService {

    @Resource
    private TeamTeaRelateMapper teamTeaRelateMapper;
    @Autowired
    RootPropeties rootPropeties;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return teamTeaRelateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TeamTeaRelate record) {
        return teamTeaRelateMapper.insert(record);
    }

    @Override
    public int insertSelective(TeamTeaRelate record) {
        return teamTeaRelateMapper.insertSelective(record);
    }

    @Override
    public TeamTeaRelate selectByPrimaryKey(Integer id) {
        return teamTeaRelateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TeamTeaRelate record) {
        return teamTeaRelateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TeamTeaRelate record) {
        return teamTeaRelateMapper.updateByPrimaryKey(record);
    }


    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<TeamTeaRelate> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getTeamTeaRelate());
        try {
            teamTeaRelateMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getTeamTeaRelate());
        }
        return ResponseStatus.success(message, this);
    }


    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        TeamTeaRelateExample example = new TeamTeaRelateExample();
        TeamTeaRelateExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        teamTeaRelateMapper.deleteByExample(example);
    }


    @Override
    public PageBean<TeamTeaRelate> listByPage(HashMap<String, Object> params, int page, int pageSize) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<TeamTeaRelate> pageBean = new PageBean<>();
        TeamTeaRelateExample example = new TeamTeaRelateExample();
        TeamTeaRelateExample.Criteria criteria = example.createCriteria();
        ExampleHelper.searchJoin(TeamTeaRelate.class, example, criteria, params);
        ExampleHelper.addCondition(TeamTeaRelate.class, criteria, params);
        List<TeamTeaRelate> list = this.teamTeaRelateMapper.selectByExample(example);
        pageBean.setBeanList(list);
        return pageBean;
    }

}
