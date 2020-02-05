package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Notice;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
public interface NoticeService {

    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

}
