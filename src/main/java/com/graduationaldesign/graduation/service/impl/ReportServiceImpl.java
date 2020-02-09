package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.ReportMapper;
import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.pojo.ReportExample;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.service.ReportService;
import com.graduationaldesign.graduation.util.PageBean;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportMapper reportMapper;

    @Override
    public int deleteByPrimaryKey(String subId, Integer reportType) {
        return reportMapper.deleteByPrimaryKey(subId, reportType);
    }

    @Override
    public String deleteById(Integer reportId) {
        if (reportId == null) {
            throw new RuntimeException("删除报告失败，id不能为空");
        }
        ReportExample example = new ReportExample();
        example.createCriteria().andIdEqualTo(reportId);
        if (reportMapper.deleteByExample(example) <= 0) {
            throw new RuntimeException("删除报告失败");
        }
        return "删除报告成功";
    }

    @Override
    public String insert(Report record) {
        if (reportMapper.insert(record) <= 0) {
            throw new RuntimeException("增加报告失败");
        }
        return "增加报告成功";
    }

    @Override
    public int insertSelective(Report record) {
        return reportMapper.insertSelective(record);
    }

    @Override
    public Report selectByPrimaryKey(String subId, Integer reportType) {
        return reportMapper.selectByPrimaryKey(subId, reportType);
    }

    @Override
    public String updateByPrimaryKeySelective(Report record) throws RuntimeException {
        String message = "修改成功";
        ReportExample example = new ReportExample();
        example.createCriteria().andIdEqualTo(record.getId());
        if (reportMapper.updateByExampleSelective(record, example) <= 0) {
            throw new RuntimeException("修改失败");
        }
        return message;
    }

    @Override
    public int updateByPrimaryKey(Report record) {
        return reportMapper.updateByPrimaryKey(record);
    }

    @Override
    public Report selectById(int reportId) {
        ReportExample reportExample = new ReportExample();
        ReportExample.Criteria criteria = reportExample.createCriteria();
        criteria.andIdEqualTo(reportId);
        List<Report> list = reportMapper.selectByExampleWithBLOBs(reportExample);
        if (list.size() <= 0) {
            throw new RuntimeException("该报告不存在");
        }
        return list.get(0);
    }

    @Override
    public PageBean<Report> listByPage(HashMap<String, Object> params, int page, Integer pageSize,
            int reportType) {
        PageBean<Report> pageBean = new PageBean<>();
        ReportExample reportExample = new ReportExample();
        StringBuilder orderby = new StringBuilder();
        if (params.get("orderId") != null) {
            if (params.get("orderId").equals("2")) {
                orderby.append("id DESC");
            } else {
                orderby.append("id ASC");
            }
        }
        if (params.get("orderTime") != null) {
            if (orderby.length() != 0) {
                orderby.append(",");
            }
            if (params.get("orderTime").equals("2")) {
                orderby.append("report_subtime DESC");
            } else {
                orderby.append("report_subtime ASC");
            }
        }
        if (orderby.length() != 0) {
            reportExample.setOrderByClause(orderby.toString());
        }
        ReportExample.Criteria criteria = reportExample.createCriteria();
        if (reportType == 1 || reportType == 2) {
            criteria.andReportTypeEqualTo(reportType);
        }
        List<Report> list = reportMapper.selectByExample(reportExample);
        pageBean.setBeanList(list);
        pageBean.setParams(params);
        return pageBean;
    }


    /**
     * 获取学生的报告列表
     *
     * @param params
     * @param page
     * @param pageSize
     * @param student
     * @param reportType
     * @return
     */
    @Override
    public PageBean<Report> listByPageOfStu(HashMap<String, Object> params, int page,
            Integer pageSize,
            Student student, int reportType) {
        PageBean<Report> pageBean = new PageBean<>();
        ReportExample example = new ReportExample();
        example.setJoin("left join t_subject on t_report.report_sub_id = t_subject.sub_id");
        StringBuilder orderby = new StringBuilder();
        if (params.get("orderId") != null) {
            if (params.get("orderId").equals("2")) {
                orderby.append("id DESC");
            } else {
                orderby.append("id ASC");
            }
        }
        if (params.get("orderTime") != null) {
            if (orderby.length() != 0) {
                orderby.append(",");
            }
            if (params.get("orderTime").equals("2")) {
                orderby.append("report_subtime DESC");
            } else {
                orderby.append("report_subtime ASC");
            }
        }
        ReportExample.Criteria criteria = example.createCriteria();
        criteria.andJoinStuIdEqualTo(student.getStuId());
        if (reportType == 1 || reportType == 2) {
            criteria.andReportTypeEqualTo(reportType);
        }
        List<Report> list = reportMapper.selectByExample(example);
        pageBean.setBeanList(list);
        pageBean.setParams(params);
        return pageBean;
    }

    @Override
    public PageBean<Report> listByPageOfTea(HashMap<String, Object> params, int page,
            Integer pageSize, Teacher teacher, int reportType) {
        PageBean<Report> pageBean = new PageBean<>();
        ReportExample example = new ReportExample();
        example.setJoin("left join t_subject on t_report.report_sub_id = t_subject.sub_id");
        StringBuilder orderby = new StringBuilder();
        if (params.get("orderId") != null) {
            if (params.get("orderId").equals("2")) {
                orderby.append("id DESC");
            } else {
                orderby.append("id ASC");
            }
        }
        if (params.get("orderTime") != null) {
            if (orderby.length() != 0) {
                orderby.append(",");
            }
            if (params.get("orderTime").equals("2")) {
                orderby.append("report_subtime DESC");
            } else {
                orderby.append("report_subtime ASC");
            }
        }
        ReportExample.Criteria criteria = example.createCriteria();
        criteria.andJoinTeaIdEqualTo(teacher.getTeaId());
        if (reportType == 1 || reportType == 2) {
            criteria.andReportTypeEqualTo(reportType);
        }
        List<Report> list = reportMapper.selectByExample(example);
        pageBean.setBeanList(list);
        pageBean.setParams(params);
        return pageBean;
    }
}
