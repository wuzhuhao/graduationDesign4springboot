package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.StudentMapper;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.StudentExample;
import com.graduationaldesign.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 19:33
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student login(Student student) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStuIdEqualTo(student.getStuId());
        if (studentMapper.selectByExample(studentExample).size()==0){
            throw new RuntimeException("账号不存在！");
        }
        else{
            criteria.andStuPasswordEqualTo(student.getStuPassword());
            List<Student> list = studentMapper.selectByExample(studentExample);
            if (list.size()==0){
                throw new RuntimeException("密码错误！");
            }else{
                list.get(0).getAcademy();
                return list.get(0);
            }
        }
    }
}
