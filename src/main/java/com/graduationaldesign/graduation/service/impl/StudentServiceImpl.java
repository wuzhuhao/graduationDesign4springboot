package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.StudentMapper;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.StudentExample;
import com.graduationaldesign.graduation.pojo.UserModel;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 19:33
 */
@Service
@CacheConfig(cacheNames = "student")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(Student student) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStuIdEqualTo(student.getStuId());
        if (studentMapper.selectByExample(studentExample).size() == 0) {
            throw new RuntimeException("账号不存在！");
        } else {
            criteria.andStuPasswordEqualTo(student.getStuPassword());
            List<Student> list = studentMapper.selectByExample(studentExample);
            if (list.size() == 0) {
                throw new RuntimeException("密码错误！");
            } else {
                list.get(0).getAcademy();
                return list.get(0);
            }
        }
    }

    //    @Cacheable //开启缓存
    //    @Cacheable(key = "#p0", unless = "#result == null")
    //    sync=true 有一个线程正在忙于计算该值，而其他线程则被阻塞，直到缓存中更新该条目为止
    @Override
    @Cacheable(keyGenerator = "keyGenerator", unless = "#result == null")
    public Student getStuById(String id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    //    @CachePut(keyGenerator = "keyGenerator")
    @Override
    public String changeInformation(UserModel userModel) {
        String message;
        Student student = getStuById(userModel.getId());
        if (student == null) {
            throw new RuntimeException("账号不存在,请重新登陆！");
        }
        student.setModel(userModel);
        if (studentMapper.updateByPrimaryKey(student) > 0) {
            message = "修改成功！";
        } else {
            message = "修改失败！";
        }
        return message;
    }


    private boolean checkPassword(String id, String oldPassword) {
        Student student = studentMapper.selectByPrimaryKey(id);
        boolean flag = true;
        if (!student.getStuPassword().equals(oldPassword)) {
            flag = false;
        }
        return flag;
    }

    @Override
    public String changPassword(String id, String oldPassword, String newPassword) {
        if (!checkPassword(id, oldPassword)) {
            throw new RuntimeException("原密码不正确!");
        }
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStuIdEqualTo(id);
        if (studentMapper.updateByExampleSelective(new Student(newPassword), studentExample) > 0) {
            return "修改成功！";
        }
        return "修改失败！";
    }

    @Override
    public int deleteByPrimaryKey(String stuId) {
        return studentMapper.deleteByPrimaryKey(stuId);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(String stuId) {
        return studentMapper.selectByPrimaryKey(stuId);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<Student> listByPage(HashMap<String, Object> params, int page, int pageSize) {
        PageBean<Student> pageBean = new PageBean<>();
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        List<Student> list = this.studentMapper.selectByExample(example);
        pageBean.setBeanList(list);
//        pageBean.setParams();
        return pageBean;
    }

}
