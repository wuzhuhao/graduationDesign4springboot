package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.ReplyTeam;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:08
 */
public interface ReplyTeamService {

    int deleteByPrimaryKey(Integer id);

    int insert(ReplyTeam record);

    int insertSelective(ReplyTeam record);

    ReplyTeam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReplyTeam record);

    int updateByPrimaryKey(ReplyTeam record);

}
