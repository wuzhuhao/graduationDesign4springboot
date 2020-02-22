package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Academy;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;

/**
 * @Author: wuzhuhao
 * @Date: 2020/2/19 23:55
 */
public interface AcademyService {


    int deleteByPrimaryKey(Integer id);

    int insert(Academy record);

    int insertSelective(Academy record);

    Academy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);

    PageBean<Academy> listByPage(HashMap<String, Object> params, int page, int pageSize);

}
