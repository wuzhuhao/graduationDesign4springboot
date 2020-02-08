package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.pojo.UserModel;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/15 0:49
 */
public interface TeacherService {

    Teacher login(Teacher teacher);

    String changPassword(String id, String oldPassword, String newPassword);

    String changeInformation(UserModel userModel);
}
