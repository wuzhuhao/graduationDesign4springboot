package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.ReplyTeamMapper;
import com.graduationaldesign.graduation.pojo.ReplyTeam;
import com.graduationaldesign.graduation.pojo.ReplyTeamExample;
import com.graduationaldesign.graduation.pojo.ScoreRecord;
import com.graduationaldesign.graduation.pojo.TeamTeaRelate;
import com.graduationaldesign.graduation.pojo.excelPojo.ReplyTeamExt;
import com.graduationaldesign.graduation.pojo.excelPojo.ReplyTeamModel;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.ReplyTeamService;
import com.graduationaldesign.graduation.service.ScoreRecordService;
import com.graduationaldesign.graduation.service.TeamTeaRelateService;
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
import java.util.stream.Collectors;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/20 21:08
 */
@Service
public class ReplyTeamServiceImpl implements ReplyTeamService {

    @Resource
    private ReplyTeamMapper replyTeamMapper;
    @Autowired
    RootPropeties rootPropeties;
    @Autowired
    TeamTeaRelateService teamTeaRelateService;
    @Autowired
    ScoreRecordService scoreRecordService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return replyTeamMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ReplyTeam record) {
        return replyTeamMapper.insert(record);
    }

    @Override
    public int insertSelective(ReplyTeam replyTeam) {
        int rowNum = replyTeamMapper.insertSelective(replyTeam);
        if (rowNum > 0) {
            TeamTeaRelate teamTeaRelate = new TeamTeaRelate(replyTeam.getTeamLeaderId(), replyTeam.getId());
            teamTeaRelateService.insertSelective(teamTeaRelate);
            List<ReplyTeamExt> lstReplyTeamExt = replyTeam.getLstReplyTeamExt();
            String replyTeamSubId = replyTeam.getReplyTeamSubId();
            if (lstReplyTeamExt != null && lstReplyTeamExt.size() > 0) {
                for (ReplyTeamExt replyTeamExt : lstReplyTeamExt) {
                    TeamTeaRelate teamTeaRelate1 = new TeamTeaRelate(replyTeamExt.getTeaId(), replyTeam.getId());
                    teamTeaRelateService.insertSelective(teamTeaRelate1);
                }
            }
            if (replyTeamSubId != null && replyTeamSubId.length() > 0 && (!"0".equals(replyTeamSubId))) {
                ScoreRecord scoreRecord = new ScoreRecord();
                scoreRecord.setScoreSubId(replyTeamSubId);
                scoreRecord.setReplyTeamId(replyTeam.getId());
                scoreRecordService.updateByScoreSubId(scoreRecord);
            }
        }
        return rowNum;
    }

    @Override
    public ReplyTeam selectByPrimaryKey(Integer id) {
        return replyTeamMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ReplyTeam record) {
        return replyTeamMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReplyTeam record) {
        return replyTeamMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean<ReplyTeam> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<ReplyTeam> pageBean = new PageBean<>();
        ReplyTeamExample example = new ReplyTeamExample();
        ReplyTeamExample.Criteria criteria = example.createCriteria();
//        if (DataConvertUtil.strToBoolean(DataConvertUtil.objToStr(params.get("isJoinStudent")))) {
//            example.setDistinct(true);
//            example.setJoin(" left join t_scorerecord on t_scorerecord.reply_team_id = reply_team.id left join t_subject on t_subject.sub_id = t_scorerecord.score_sub_id ");
//            ExampleHelper.addJoinCondition(Subject.class, criteria, params);
//        }
        ExampleHelper.searchJoin(ReplyTeam.class, example, criteria, params);
        ExampleHelper.addCondition(ReplyTeam.class, criteria, params);
        List<ReplyTeam> list = this.replyTeamMapper.selectByExample(example);
        pageBean.setBeanList(list);
        return pageBean;
    }

    @Override
    public void deleteByPrimaryKeyIn(List<Integer> lstPrimaryKey) throws Exception {
        ReplyTeamExample example = new ReplyTeamExample();
        ReplyTeamExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(lstPrimaryKey);
        replyTeamMapper.deleteByExample(example);
    }

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<ReplyTeam> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getReplyTeam());
        try {
            replyTeamMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getReplyTeam());
        }
        return ResponseStatus.success(message);
    }

    @Override
    public ResponseEntity<Object> insertListByExcelModel(List<ReplyTeamModel> lstReplyTeamModel) {
        String message = MessageFormat.format("批量导入{0}成功", rootPropeties.getReplyTeam());
        try {
            List<ReplyTeam> list = lstReplyTeamModel.stream().map(e -> e.convertReplyTeam()).collect(Collectors.toList());
            for (ReplyTeam replyTeam : list) {
                //插入答辩组和导师
                insertSelective(replyTeam);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量导入{0}失败", rootPropeties.getReplyTeam());
        }
        return ResponseStatus.success(message);
    }
}
