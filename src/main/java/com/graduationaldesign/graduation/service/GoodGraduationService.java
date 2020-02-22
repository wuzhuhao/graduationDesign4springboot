package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.GoodGraduation;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;

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

    PageBean<GoodGraduation> listByPage(HashMap<String, Object> params, int page, int pageSize);

}
