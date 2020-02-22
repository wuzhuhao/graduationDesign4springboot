package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.NoticeMapper;
import com.graduationaldesign.graduation.pojo.Notice;
import com.graduationaldesign.graduation.pojo.NoticeExample;
import com.graduationaldesign.graduation.service.NoticeService;
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
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Notice record) {
        return noticeMapper.insert(record);
    }

    @Override
    public int insertSelective(Notice record) {
        return noticeMapper.insertSelective(record);
    }

    @Override
    public Notice selectByPrimaryKey(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Notice record) {
        return noticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return noticeMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<Notice> listByPage(HashMap<String, Object> params, int page, int pageSize) {
        PageBean<Notice> pageBean = new PageBean<>();
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        List<Notice> list = this.noticeMapper.selectByExample(example);
        pageBean.setBeanList(list);
//        pageBean.setParams();
        return pageBean;
    }
}
