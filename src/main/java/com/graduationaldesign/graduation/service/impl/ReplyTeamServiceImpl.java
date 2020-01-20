package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.ReplyTeamMapper;
import com.graduationaldesign.graduation.pojo.ReplyTeam;
import com.graduationaldesign.graduation.service.ReplyTeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

}
