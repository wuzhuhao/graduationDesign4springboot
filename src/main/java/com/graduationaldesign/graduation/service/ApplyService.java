package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Apply;
import com.graduationaldesign.graduation.util.PageBean;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:05
 */
public interface ApplyService {

    int deleteByPrimaryKey(Integer id);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);

    PageBean<Apply> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    void deleteByPrimaryKeyIn(List<Integer> lstprimaryKey) throws Exception;
}
