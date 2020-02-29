package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.TeacherMapper;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.pojo.TeacherExample;
import com.graduationaldesign.graduation.pojo.UserModel;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.TeacherService;
import com.graduationaldesign.graduation.util.PageBean;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/15 10:04
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public int deleteByPrimaryKey(String teaId) {
        return teacherMapper.deleteByPrimaryKey(teaId);
    }

    @Override
    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    @Override
    public int insertSelective(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    @Override
    public Teacher selectByPrimaryKey(String teaId) {
        return teacherMapper.selectByPrimaryKey(teaId);
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Teacher record) {
        return teacherMapper.updateByPrimaryKey(record);
    }


    @Override
    public Teacher login(Teacher teacher) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andTeaIdEqualTo(teacher.getTeaId());
        if (teacherMapper.selectByExample(example).size() == 0) {
            throw new RuntimeException("账号不存在！");
        } else {
            criteria.andTeaPasswordEqualTo(teacher.getTeaPassword());
            List<Teacher> list = teacherMapper.selectByExample(example);
            if (list.size() == 0) {
                throw new RuntimeException("密码错误！");
            } else {
                return list.get(0);
            }
        }
    }

    private boolean checkPassword(String id, String oldPassword) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        boolean flag = true;
        if (!teacher.getTeaPassword().equals(oldPassword)) {
            flag = false;
        }
        return flag;
    }

    @Override
    public String changPassword(String id, String oldPassword, String newPassword) {
        if (!checkPassword(id, oldPassword)) {
            throw new RuntimeException("原密码不正确!");
        }
        TeacherExample studentExample = new TeacherExample();
        TeacherExample.Criteria criteria = studentExample.createCriteria();
        criteria.andTeaIdEqualTo(id);
        if (teacherMapper.updateByExampleSelective(new Teacher(newPassword), studentExample) > 0) {
            return "修改成功！";
        }
        return "修改失败！";
    }

    private Teacher getUsetById(String id) {
        Teacher list = teacherMapper.selectByPrimaryKey(id);
        return list;
    }

    @Override
    public String changeInformation(UserModel userModel) {
        String message;
        Teacher teacher = getUsetById(userModel.getId());
        if (teacher == null) {
            throw new RuntimeException("账号不存在,请重新登陆！");
        }
        teacher.setModel(userModel);
        if (teacherMapper.updateByPrimaryKey(teacher) > 0) {
            message = "修改成功！";
        } else {
            message = "修改失败！";
        }
        return message;
    }

    @Override
    public PageBean<Teacher> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        PageBean<Teacher> pageBean = new PageBean<>();
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        ExampleHelper.addCondition(Teacher.class, criteria, params);
        List<Teacher> list = this.teacherMapper.selectByExample(example);
        pageBean.setBeanList(list);
//        pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public Teacher findById(String number) {
        return teacherMapper.selectByPrimaryKey(number);
    }

    @Override
    public void insertListSelective(List<Teacher> lstTeacher) throws Exception {
        for (Teacher teacher : lstTeacher) {
            teacherMapper.insertSelective(teacher);
        }
    }


}
