package com.graduationaldesign.graduation.service;


import com.graduationaldesign.graduation.pojo.Sysdict;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wuzhuhao
 * @Date: 2020/3/22 0022 15:46
 */
public interface SysdictService {


    int deleteByPrimaryKey(Long id);

    int insert(Sysdict record);

    int insertSelective(Sysdict record);

    Sysdict selectByPrimaryKey(Long id);

    Map<String, Map<Object, String>> selectByModel(String Modelvalue);

    int updateByPrimaryKeySelective(Sysdict record);

    int updateByPrimaryKey(Sysdict record);

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Sysdict> lstRecord);

    public void deleteByPrimaryKeyIn(List<Long> lstPrimaryKey) throws Exception;//分页service层

    PageBean<Sysdict> listByPage(HashMap<String, Object> params, int page, int pageSize) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
