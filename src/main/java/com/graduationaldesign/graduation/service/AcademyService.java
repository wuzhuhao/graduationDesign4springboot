package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Academy;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/2/19 23:55
 */
public interface AcademyService {


    int deleteByPrimaryKey(Integer id);

    void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception;

    int insert(Academy record);

    int insertSelective(Academy record);

    Academy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);

    PageBean<Academy> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;

    Map<Integer, String> getItems();

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Academy> lstRecord);

}
