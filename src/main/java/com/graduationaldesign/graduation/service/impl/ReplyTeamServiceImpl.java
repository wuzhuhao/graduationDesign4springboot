package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.ReplyTeamMapper;
import com.graduationaldesign.graduation.pojo.ReplyTeam;
import com.graduationaldesign.graduation.pojo.ReplyTeamExample;
import com.graduationaldesign.graduation.pojo.Subject;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.ReplyTeamService;
import com.graduationaldesign.graduation.util.DataConvertUtil;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatu;
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
 * @Date: 2020/1/20 21:08
 */
@Service
public class ReplyTeamServiceImpl implements ReplyTeamService {

    @Resource
    private ReplyTeamMapper replyTeamMapper;
    @Autowired
    RootPropeties rootPropeties;

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
        if (DataConvertUtil.strToBoolean(DataConvertUtil.objToStr(params.get("isJoinStudent")))) {
            example.setDistinct(true);
            example.setJoin(" left join t_scorerecord on t_scorerecord.reply_team_id = reply_team.id left join t_subject on t_subject.sub_id = t_scorerecord.score_sub_id ");
            ExampleHelper.addJoinCondition(Subject.class, criteria, params);
        }
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

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<ReplyTeam> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getReplyTeam());
        try {
            replyTeamMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getReplyTeam());
        }
        return ResponseStatu.success(message);
    }
}
