package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.ReplyTeam;
import com.graduationaldesign.graduation.pojo.excelPojo.ReplyTeamModel;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

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
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;

    void deleteByPrimaryKeyIn(List<Integer> lstprimaryKey) throws Exception;

    ResponseEntity<Object> updateListByPrimaryKeySelective(List<ReplyTeam> lstRecord);

    ResponseEntity<Object> insertListByExcelModel(List<ReplyTeamModel> lstRecord);
}
