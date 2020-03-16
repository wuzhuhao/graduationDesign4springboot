package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.DesignShow;
import com.graduationaldesign.graduation.util.PageBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:15
 */
public interface DesignShowService {

    int deleteByPrimaryKey(Integer id);

    int insert(DesignShow record);

    int insertSelective(DesignShow record);

    DesignShow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesignShow record);

    int updateByPrimaryKey(DesignShow record);

    PageBean<DesignShow> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    void deleteByPrimaryKeyIn(List<Integer> lstprimaryKey) throws Exception;

    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<DesignShow> lstRecord);

    void uploadFile(MultipartFile file, Integer showId);
}
