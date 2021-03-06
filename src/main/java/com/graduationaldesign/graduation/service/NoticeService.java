package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Notice;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

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

    PageBean<Notice> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;

    void deleteByPrimaryKeyIn(List<Integer> lstprimaryKey) throws Exception;

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Notice> lstRecord);

}
