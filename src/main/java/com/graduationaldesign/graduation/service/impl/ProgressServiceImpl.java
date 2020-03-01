package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.ProgressMapper;
import com.graduationaldesign.graduation.pojo.Progress;
import com.graduationaldesign.graduation.pojo.ProgressExample;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.ProgressService;
import com.graduationaldesign.graduation.util.PageBean;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
@Service
public class ProgressServiceImpl implements ProgressService {

    @Resource
    private ProgressMapper progressMapper;

    @Override
    public String deleteByPrimaryKey(Integer id) {
        if (id == null || progressMapper.deleteByPrimaryKey(id) <= 0) {
            throw new RuntimeException("删除问题失败");
        }
        return "删除问题成功";
    }

    @Override
    public int insert(Progress record) {
        return progressMapper.insert(record);
    }

    @Override
    public String insertSelective(Progress record) {
        if (progressMapper.insertSelective(record) <= 0) {
            throw new RuntimeException("添加问题失败");
        }
        return "添加问题成功";
    }

    @Override
    public Progress selectByPrimaryKey(Integer id) {
        return progressMapper.selectByPrimaryKey(id);
    }

    @Override
    public String updateByPrimaryKeySelective(Progress record) {
        String message = "修改问题成功";
        record.setProgContentTime(new Date());
        if (progressMapper.updateByPrimaryKeySelective(record) <= 0) {
            throw new RuntimeException("修改问题失败");
        }
        return message;
    }

    @Override
    public String reply(Progress record) {
        String message = "回复问题成功";
        record.setProgReplyTime(new Date());
        if (progressMapper.updateByPrimaryKeySelective(record) <= 0) {
            throw new RuntimeException("回复问题失败");
        }
        return message;
    }

    @Override
    public int updateByPrimaryKey(Progress record) {
        return progressMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<Progress> listByPage(HashMap<String, Object> params, int page,
            Integer pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Progress> pageBean = new PageBean<>();
        ProgressExample example = new ProgressExample();
        StringBuilder orderby = getOrderString(params);
        if (orderby.length() != 0) {
            example.setOrderByClause(orderby.toString());
        }
        ProgressExample.Criteria criteria = example.createCriteria();
        ExampleHelper.addCondition(Progress.class, criteria, params);
        List<Progress> list = progressMapper.selectByExample(example);
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public PageBean<Progress> listByPageOfStu(HashMap<String, Object> params, int page,
            Integer pageSize, Student student)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Progress> pageBean = new PageBean<>();
        ProgressExample example = new ProgressExample();
        example.setJoin("left join t_subject on t_progress.progress_sub_id = t_subject.sub_id");
        StringBuilder orderby = getOrderString(params);
        if (orderby.length() != 0) {
            example.setOrderByClause(orderby.toString());
        }
        ProgressExample.Criteria criteria = example.createCriteria();
        criteria.andJoinStuIdEqualTo(student.getStuId());
        ExampleHelper.addCondition(Progress.class, criteria, params);
        List<Progress> list = progressMapper.selectByExample(example);
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public PageBean<Progress> listByPageOfTea(HashMap<String, Object> params, int page,
            Integer pageSize, Teacher teacher)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<Progress> pageBean = new PageBean<>();
        ProgressExample example = new ProgressExample();
        example.setJoin("left join t_subject on t_progress.progress_sub_id = t_subject.sub_id");
        StringBuilder orderby = getOrderString(params);
        if (orderby.length() != 0) {
            example.setOrderByClause(orderby.toString());
        }
        ProgressExample.Criteria criteria = example.createCriteria();
        criteria.andJoinTeaIdEqualTo(teacher.getTeaId());
        ExampleHelper.addCondition(Progress.class, criteria, params);
        List<Progress> list = progressMapper.selectByExample(example);
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    private StringBuilder getOrderString(HashMap<String, Object> params) {
        StringBuilder orderby = new StringBuilder();
        if (params.get("orderId") != null) {
            if (params.get("orderId").equals("2")) {
                orderby.append("id DESC");
            } else {
                orderby.append("id ASC");
            }
        }
        if (params.get("orderContenTime") != null) {
            if (orderby.length() != 0) {
                orderby.append(",");
            }
            if (params.get("orderContenTime").equals("2")) {
                orderby.append("prog_content_time DESC");
            } else {
                orderby.append("prog_content_time ASC");
            }
        }
        if (params.get("orderReplyTime") != null) {
            if (orderby.length() != 0) {
                orderby.append(",");
            }
            if (params.get("orderReplyTime").equals("2")) {
                orderby.append("prog_reply_time DESC");
            } else {
                orderby.append("prog_reply_time ASC");
            }
        }
        if (params.get("orderSubId") != null) {
            if (orderby.length() != 0) {
                orderby.append(",");
            }
            if (params.get("orderSubId").equals("2")) {
                orderby.append("progress_sub_id DESC");
            } else {
                orderby.append("progress_sub_id ASC");
            }
        }
        return orderby;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        ProgressExample example = new ProgressExample();
        ProgressExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        progressMapper.deleteByExample(example);
    }
}
