package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.UserModel;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;

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

    PageBean<Admin> listByPage(HashMap<String, Object> params, int page, int pageSize);

    Admin findById(String number);
}
