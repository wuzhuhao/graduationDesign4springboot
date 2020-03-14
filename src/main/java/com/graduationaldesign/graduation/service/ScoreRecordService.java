package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.ScoreRecord;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/3/14 0014 14:29
 */
public interface ScoreRecordService {


    int deleteByPrimaryKey(Integer id);

    int insert(ScoreRecord record);

    int insertSelective(ScoreRecord record);

    ScoreRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScoreRecord record);

    int updateByPrimaryKey(ScoreRecord record);

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<ScoreRecord> lstRecord);

    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception;//分页service层

    PageBean<ScoreRecord> listByPage(HashMap<String, Object> params, int page, int pageSize);

}
