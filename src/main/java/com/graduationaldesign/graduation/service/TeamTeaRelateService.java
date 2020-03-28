package com.graduationaldesign.graduation.service;


import com.graduationaldesign.graduation.pojo.TeamTeaRelate;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/3/28 0028 23:30
 */
public interface TeamTeaRelateService {


    int deleteByPrimaryKey(Integer id);

    int insert(TeamTeaRelate record);

    int insertSelective(TeamTeaRelate record);

    TeamTeaRelate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeamTeaRelate record);

    int updateByPrimaryKey(TeamTeaRelate record);

    PageBean<TeamTeaRelate> listByPage(HashMap<String, Object> params, int page, int pageSize);

    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception;

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<TeamTeaRelate> lstRecord);
}
