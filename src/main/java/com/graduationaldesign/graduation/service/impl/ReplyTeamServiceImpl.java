package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.ReplyTeamMapper;
import com.graduationaldesign.graduation.pojo.ReplyTeam;
import com.graduationaldesign.graduation.pojo.ReplyTeamExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.ReplyTeamService;
import com.graduationaldesign.graduation.util.PageBean;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:08
 */
@Service
public class ReplyTeamServiceImpl implements ReplyTeamService {

    @Resource
    private ReplyTeamMapper replyTeamMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return replyTeamMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ReplyTeam record) {
        return replyTeamMapper.insert(record);
    }

    @Override
    public int insertSelective(ReplyTeam record) {
        return replyTeamMapper.insertSelective(record);
    }

    @Override
    public ReplyTeam selectByPrimaryKey(Integer id) {
        return replyTeamMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ReplyTeam record) {
        return replyTeamMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReplyTeam record) {
        return replyTeamMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<ReplyTeam> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<ReplyTeam> pageBean = new PageBean<>();
        ReplyTeamExample example = new ReplyTeamExample();
        ReplyTeamExample.Criteria criteria = example.createCriteria();
        ExampleHelper.addCondition(ReplyTeam.class, criteria, params);
        List<ReplyTeam> list = this.replyTeamMapper.selectByExample(example);
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        ReplyTeamExample example = new ReplyTeamExample();
        ReplyTeamExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        replyTeamMapper.deleteByExample(example);
    }
}
