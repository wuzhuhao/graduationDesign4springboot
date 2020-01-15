package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.Teacher;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 16:48
 */
public interface AdminService {
    Admin getAdminByName(String adminID);
    Admin login(Admin admin);
}
