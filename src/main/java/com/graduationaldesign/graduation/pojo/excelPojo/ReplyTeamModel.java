package com.graduationaldesign.graduation.pojo.excelPojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graduationaldesign.graduation.pojo.ReplyTeam;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/4/11 0011 16:40
 */
@Data
@JsonIgnoreProperties(value = {"handler"})
@ExcelTarget("replyTeamModel")
public class ReplyTeamModel implements Serializable {
    private Integer id;

    @Excel(name = "答辩小组名称", width = 30, orderNum = "0", needMerge = true)
    private String teamName;

    @Excel(name = "答辩地址", width = 30, orderNum = "1", needMerge = true)
    private String teamAddress;

    @Excel(name = "答辩时间", width = 30, orderNum = "2", format = "yyyy/MM/dd HH:mm", needMerge = true)
    private Date replyTime;

    @Excel(name = "答辩小组组长ID", width = 30, orderNum = "3", needMerge = true)
    private String teamLeaderId;
    @Excel(name = "学生选题ID", width = 30, orderNum = "4", needMerge = true)
    private String replyTeamSubId;
    @ExcelCollection(name = "答辩小组导师成员", orderNum = "5")
    private List<ReplyTeamExt> lstReplyTeamExt;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getTeamAddress() {
        return teamAddress;
    }

    public void setTeamAddress(String teamAddress) {
        this.teamAddress = teamAddress == null ? null : teamAddress.trim();
    }

    public String getReplyTime() {
        return DateUtil.formatDateTime(replyTime);
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(String teamLeaderId) {
        this.teamLeaderId = teamLeaderId == null ? null : teamLeaderId.trim();
    }

    public String getReplyTeamSubId() {
        return replyTeamSubId;
    }

    public void setReplyTeamSubId(String replyTeamSubId) {
        this.replyTeamSubId = replyTeamSubId;
    }

    public ReplyTeamModel() {
    }

    public ReplyTeamModel(String teamName, String teamAddress, Date replyTime, String teamLeaderId, String replyTeamSubId) {
        this.teamName = teamName;
        this.teamAddress = teamAddress;
        this.replyTime = replyTime;
        this.teamLeaderId = teamLeaderId;
        this.replyTeamSubId = replyTeamSubId;
    }

    public List<ReplyTeamExt> getLstReplyTeamExt() {
        return lstReplyTeamExt;
    }

    public void setLstReplyTeamExt(List<ReplyTeamExt> lstReplyTeamExt) {
        this.lstReplyTeamExt = lstReplyTeamExt;
    }

    public ReplyTeam convertReplyTeam() {
        return new ReplyTeam(teamName, teamAddress, replyTime, teamLeaderId, replyTeamSubId, lstReplyTeamExt);
    }
}
