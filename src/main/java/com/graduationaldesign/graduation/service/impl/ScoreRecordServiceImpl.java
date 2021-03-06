package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.ScoreRecordMapper;
import com.graduationaldesign.graduation.pojo.ScoreRecord;
import com.graduationaldesign.graduation.pojo.ScoreRecordExample;
import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.ScoreRecordService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatus;
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
public class ScoreRecordServiceImpl extends com.graduationaldesign.graduation.service.Service<ScoreRecord, ScoreRecordExample, ScoreRecordMapper> implements ScoreRecordService {

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
    public int updateByScoreSubId(ScoreRecord record) {
        ScoreRecordExample example = new ScoreRecordExample();
        ScoreRecordExample.Criteria criteria = example.createCriteria();
        criteria.andScoreSubIdEqualTo(record.getScoreSubId());
        scoreRecordMapper.updateByExampleSelective(record, example);
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
        return ResponseStatus.success(message);
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        ScoreRecordExample example = new ScoreRecordExample();
        ScoreRecordExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        scoreRecordMapper.deleteByExample(example);
    }

    @Override
    public PageBean<ScoreRecord> listByPage(HashMap<String, Object> params, int page, int pageSize) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<ScoreRecord> pageBean = new PageBean<>();
        ScoreRecordExample example = new ScoreRecordExample();
        ScoreRecordExample.Criteria criteria = example.createCriteria();
        ExampleHelper.searchJoin(ScoreRecord.class, example, criteria, params);
        ExampleHelper.addCondition(ScoreRecord.class, criteria, params);
//        criteria.andJoinStuIdNotEqualTo("");
        List<ScoreRecord> list = this.scoreRecordMapper.selectByExample(example);
        pageBean.setBeanList(list);
        int i = 0;
        for (ScoreRecord scoreRecord : list) {
            scoreRecord.getSubject();
            if (scoreRecord.getSubject() != null) {
                Student student = scoreRecord.getSubject().getStudent();
//                if (student == null) {
//                    list.remove(i);
//                    i++;
//                    continue;
//                }
                scoreRecord.getSubject().getTeacher();
//                i++;
            }
        }
        return pageBean;
    }
//
//    @Override
//    public List<ScoreRecord> selectByParam(Map<String, Object> params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        ScoreRecordExample example = new ScoreRecordExample();
//        ScoreRecordExample.Criteria criteria = example.createCriteria();
//        ExampleHelper.addCondition(ScoreRecord.class, criteria, params);
//        List<ScoreRecord> list = this.scoreRecordMapper.selectByExample(example);
//        return list;
//    }

}
