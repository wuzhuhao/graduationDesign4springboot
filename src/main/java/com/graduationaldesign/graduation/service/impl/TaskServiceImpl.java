package com.graduationaldesign.graduation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.TaskMapper;
import com.graduationaldesign.graduation.pojo.Task;
import com.graduationaldesign.graduation.pojo.TaskExample;
import com.graduationaldesign.graduation.service.TaskService;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:10
 */
@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Autowired
    RootPropeties rootPropeties;

    /*==============私有接口=====================*/
    private PageBean<Task> pageByExample(TaskExample taskExample, int page) {
        int totalpage;
        int totalSize;
        PageBean<Task> pageBean = new PageBean<>();
        //计算数据库总数
        totalSize = (int) taskMapper.countByExample(taskExample);
        //设置一页的数量
        pageBean.setPageSize(rootPropeties.getPageSize());
        //设置总数
        pageBean.setTotalRecord(totalSize);
        //获取总页数
        totalpage = pageBean.getTotalPage();
        //初始化page
        page = (page <= 0) ? 1 : page > totalpage ? totalpage : page;
        pageBean.setCurrentPage(page);
        PageHelper.startPage(page, rootPropeties.getPageSize());
        List<Task> list = taskMapper.selectByExample(taskExample);
        //得到分页的结果对象
        PageInfo<Task> personPageInfo = new PageInfo<>(list);
        //得到分页中的person条目对象
        List<Task> pageList = personPageInfo.getList();
        pageBean.setBeanList(pageList);
        return pageBean;
    }

    /*==============公开接口=====================*/
    @Override
    public String deleteByPrimaryKey(Integer id) throws RuntimeException {
        String message = "删除任务成功";
        if (taskMapper.deleteByPrimaryKey(id) < 0) {
            throw new RuntimeException("删除任务失败");
        }
        return "删除任务成功";
    }

    @Override
    public int insert(Task record) {
        return taskMapper.insert(record);
    }

    @Override
    public String insertSelective(Task record) throws RuntimeException {
        String message = "创建任务成功";
        record.setTaskState("1");
        record.setTaskTime(new Date());
        if (taskMapper.insertSelective(record) <= 0) {
            throw new RuntimeException("创建任务失败");
        }
        return message;
    }

    @Override
    public Task selectByPrimaryKey(Integer id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public String updateByPrimaryKeySelective(Task record) throws RuntimeException {
        if (taskMapper.updateByPrimaryKeySelective(record) <= 0) {
            throw new RuntimeException("修改任务失败");
        }
        return "修改任务成功";
    }

    @Override
    public int updateByPrimaryKey(Task record) {
        return taskMapper.updateByPrimaryKey(record);
    }

    public PageBean<Task> listByPage(HashMap<String, Object> param, int page) {
        PageBean<Task> pageBean;
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        pageBean = pageByExample(taskExample, page);
//        pageBean.setParams();
        return pageBean;
    }

    @Override
    public PageBean<Task> listByTeaWithPage(HashMap<String, Object> param, int page, String teaId) {
//        int total = taskMapper.countByTeaId()
        List<Task> taskList = taskMapper.selectByTeaId(teaId);
        PageBean<Task> pageBean = new PageBean<>();
        pageBean.setBeanList(taskList);
        return pageBean;
    }

    @Override
    public PageBean<Task> listByStuPage(HashMap<String, Object> param, int page, String stuId,
            String type) {
        if (!(type.equals("1") || type.equals("2"))) {
            throw new RuntimeException("type参数错误");
        }
        PageBean<Task> pageBean;
        TaskExample taskExample = new TaskExample();
        taskExample.setJoin("left join t_subject on t_task.task_sub_id = t_subject.sub_id");
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andJoinStuIdEqualTo(stuId);
        criteria.andTaskStateEqualTo(type);
        pageBean = pageByExample(taskExample, page);
        return pageBean;
    }
}
