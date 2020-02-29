package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.ReplyTeam;
import com.graduationaldesign.graduation.util.PageBean;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

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

    PageBean<ReplyTeam> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

}
