package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.ReportMapper;
import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:09
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportMapper reportMapper;

    @Override
    public int deleteByPrimaryKey(String subId,Integer reportType) {
        return reportMapper.deleteByPrimaryKey(subId,reportType);
    }

    @Override
    public int insert(Report record) {
        return reportMapper.insert(record);
    }

    @Override
    public int insertSelective(Report record) {
        return reportMapper.insertSelective(record);
    }

    @Override
    public Report selectByPrimaryKey(String subId, Integer reportType) {
        return reportMapper.selectByPrimaryKey(subId,reportType);
    }

    @Override
    public int updateByPrimaryKeySelective(Report record) {
        return reportMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Report record) {
        return reportMapper.updateByPrimaryKey(record);
    }

}
