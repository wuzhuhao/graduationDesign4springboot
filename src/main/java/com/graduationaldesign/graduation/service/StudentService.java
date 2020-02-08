package com.graduationaldesign.graduation.service;

import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.UserModel;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 19:32
 */
public interface StudentService {

    Student login(Student student);

    String changPassword(String id, String oldPassword, String newPassword);

    String changeInformation(UserModel userModel);

    Student getStuById(String id);
}
