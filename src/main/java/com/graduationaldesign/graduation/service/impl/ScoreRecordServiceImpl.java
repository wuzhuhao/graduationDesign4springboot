package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.ScoreRecordMapper;
import com.graduationaldesign.graduation.pojo.ScoreRecord;
import com.graduationaldesign.graduation.pojo.ScoreRecordExample;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.ScoreRecordService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/3/14 0014 14:29
 */
@Service
public class ScoreRecordServiceImpl implements ScoreRecordService {

    @Resource
    private ScoreRecordMapper scoreRecordMapper;
    @Autowired
    RootPropeties rootPropeties;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scoreRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ScoreRecord record) {
        return scoreRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(ScoreRecord record) {
        return scoreRecordMapper.insertSelective(record);
    }

    @Override
    public ScoreRecord selectByPrimaryKey(Integer id) {
        return scoreRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ScoreRecord record) {
        return scoreRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ScoreRecord record) {
        return scoreRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<ScoreRecord> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getScoreRecord());
        try {
            scoreRecordMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getScoreRecord());
        }
        return ResponseStatu.success(message);
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        ScoreRecordExample example = new ScoreRecordExample();
        ScoreRecordExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        scoreRecordMapper.deleteByExample(example);
    }

    @Override
    public PageBean<ScoreRecord> listByPage(HashMap<String, Object> params, int page, int pageSize) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PageBean<ScoreRecord> pageBean = new PageBean<>();
        ScoreRecordExample example = new ScoreRecordExample();
        ScoreRecordExample.Criteria criteria = example.createCriteria();
        ExampleHelper.addCondition(ScoreRecord.class, criteria, params);
        List<ScoreRecord> list = this.scoreRecordMapper.selectByExample(example);
        pageBean.setBeanList(list);
        return pageBean;
    }
}
