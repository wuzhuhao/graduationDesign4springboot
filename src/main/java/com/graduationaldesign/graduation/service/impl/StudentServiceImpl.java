package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.StudentMapper;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.StudentExample;
import com.graduationaldesign.graduation.pojo.UserModel;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.StudentService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 19:33
 */
@Service
@CacheConfig(cacheNames = "student")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    RootPropeties rootPropeties;

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
//    @Cacheable(keyGenerator = "keyGenerator", unless = "#result == null")
    @Cacheable(value = "student", key = "#id", unless = "#result == null")
    public Student findById(String id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    @CacheEvict(value = "student", key = "#id")
    //    @CachePut(value = "student", key = "#id")
    @Override
    public String changeInformation(UserModel userModel) {
        String message;
        Student student = findById(userModel.getId());
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

    @CacheEvict(value = "student", key = "#id")
    @Override
    public Student changPassword(String id, String oldPassword, String newPassword) {
        if (!checkPassword(id, oldPassword)) {
            throw new RuntimeException("原密码不正确!");
        }
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStuIdEqualTo(id);
        Student student = findById(id);
        student.setStuPassword(newPassword);
        if (studentMapper.updateByExampleSelective(student, studentExample) > 0) {
            return student;
        }
        return null;
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
    public void insertListSelective(List<Student> lstStudent) throws Exception {
        for (Student student : lstStudent) {
            studentMapper.insertSelective(student);
        }
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
    public PageBean<Student> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<Student> pageBean = new PageBean<>();
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        ExampleHelper.searchJoin(Student.class, example, criteria, params);
        ExampleHelper.addCondition(Student.class, criteria, params);
        List<Student> list = this.studentMapper.selectByExample(example);
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<String> lstPrimaryKey) throws Exception {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStuIdIn(lstPrimaryKey);
        studentMapper.deleteByExample(example);
    }

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Student> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getStudent());
        try {
            studentMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getStudent());
        }
        return ResponseStatus.success(message);
    }
}
