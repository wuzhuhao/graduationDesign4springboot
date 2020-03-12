package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.GoodGraduationMapper;
import com.graduationaldesign.graduation.pojo.GoodGraduation;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
public interface GoodGraduationService {

    int deleteByPrimaryKey(Integer id);

    int insert(GoodGraduation record);

    int insertSelective(GoodGraduation record);

    GoodGraduation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodGraduation record);

    int updateByPrimaryKey(GoodGraduation record);

    PageBean<GoodGraduation> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    void deleteByPrimaryKeyIn(List<Integer> lstprimaryKey) throws Exception;
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<GoodGraduation> lstRecord);

}
