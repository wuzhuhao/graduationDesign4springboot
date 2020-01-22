package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.SubjectMapper;
import com.graduationaldesign.graduation.pojo.Subject;
import com.graduationaldesign.graduation.service.SubjectService;
import com.graduationaldesign.graduation.util.IDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:10
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;

    @Override
    public String deleteByPrimaryKey(String subId) {
        String message = "删除课题成功";
        if(subjectMapper.deleteByPrimaryKey(subId)<=0){
            message = "删除课题失败";
        }
        return message;
    }

    @Override
    public String insert(Subject record) {
        String message = "增加课题成功！";
        try {
            record.setSubId(IDUtil.generateSubID(record.getSubSource()));
        }catch (NullPointerException ne){
            message ="参数错误，请检查参数！";
        }
        if (subjectMapper.insert(record)<=0){
            message = "增加课题失败！";
        }
        return message;
    }

    @Override
    public int insertSelective(Subject record) {
        return subjectMapper.insertSelective(record);
    }

    @Override
    public Subject selectByPrimaryKey(String subId) {
        return subjectMapper.selectByPrimaryKey(subId);
    }

    @Override
    public String updateByPrimaryKeySelective(Subject record) {
        String message = "修改课题成功";
        if (subjectMapper.updateByPrimaryKeySelective(record)<=0){
            message = "修改课题失败";
        }
        return message;
    }

    @Override
    public int updateByPrimaryKey(Subject record) {
        return subjectMapper.updateByPrimaryKey(record);
    }

}
