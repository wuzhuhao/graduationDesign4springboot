package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.mapper.AdminMapper;
import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.UserModel;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatu;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 16:48
 */
public interface AdminService {

    Admin getAdminByName(String adminID);

    Admin login(Admin admin);

    String changPassword(String id, String oldPassword, String newPassword);

    String changeInformation(UserModel userModel);

    int deleteByPrimaryKey(String adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    PageBean<Admin> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    Admin findById(String number);

    void insertListSelective(List<Admin> lstAdmin) throws Exception;

    void deleteByPrimaryKeyIn(List<String> lstPrimaryKey) throws Exception;
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Admin> lstRecord);

}
