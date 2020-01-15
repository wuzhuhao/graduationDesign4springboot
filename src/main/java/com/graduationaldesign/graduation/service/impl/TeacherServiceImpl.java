package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.TeacherMapper;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.StudentExample;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.pojo.TeacherExample;
import com.graduationaldesign.graduation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/15 10:04
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public Teacher login(Teacher teacher) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andTeaIdEqualTo(teacher.getTeaId());
        if (teacherMapper.selectByExample(example).size()==0){
            throw new RuntimeException("账号不存在！");
        }
        else{
            criteria.andTeaPasswordEqualTo(teacher.getTeaPassword());
            List<Teacher> list = teacherMapper.selectByExample(example);
            if (list.size()==0){
                throw new RuntimeException("密码错误！");
            }else{
                return list.get(0);
            }
        }
    }
}
