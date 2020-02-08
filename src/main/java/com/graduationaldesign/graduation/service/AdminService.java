package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.UserModel;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 16:48
 */
public interface AdminService {

    Admin getAdminByName(String adminID);

    Admin login(Admin admin);

    String changPassword(String id, String oldPassword, String newPassword);

    String changeInformation(UserModel userModel);
}
