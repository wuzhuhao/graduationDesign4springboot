package com.graduationaldesign.graduation.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graduationaldesign.graduation.pojo.helper.Column;
import com.graduationaldesign.graduation.pojo.helper.MyPrimaryKey;
import com.graduationaldesign.graduation.pojo.helper.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties(value = {"handler"})
@Table(value = "reply_team")
@ExcelTarget("score")
public class ReplyTeam implements Serializable {

    /**
     * 表字段 : reply_team.id
     */
    @MyPrimaryKey
    @Column(columnName = "id", viewName = "replyTeamId")
    private Integer id;

    /**
     * 答辩组名称
     * 表字段 : reply_team.team_name
     */
    @Column(columnName = "team_name")
    @Excel(name = "答辩小组名称", width = 30, orderNum = "2")
    private String teamName;

    /**
     * 答辩地址
     * 表字段 : reply_team.team_address
     */
    @Column(columnName = "team_address")
    @Excel(name = "答辩地址", width = 30, orderNum = "3")
    private String teamAddress;

    /**
     * 答辩时间
     * 表字段 : reply_team.reply_time
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(columnName = "reply_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "答辩时间", width = 30, orderNum = "4", format = "yyyy/MM/dd HH:mm")
    private Date replyTime;

    /**
     * 答辩组长id
     * 表字段 : reply_team.team_leader_id
     */
    @Column(columnName = "team_leader_id", joinPojo = "Teacher")
    private String teamLeaderId;
    private Teacher teacher;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reply_team
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:reply_team.id
     *
     * @return reply_team.id,
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:reply_team.id
     *
     * @param id the value for reply_team.id,
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 答辩组名称 字段:reply_team.team_name
     *
     * @return reply_team.team_name, 答辩组名称
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * 设置 答辩组名称 字段:reply_team.team_name
     *
     * @param teamName the value for reply_team.team_name, 答辩组名称
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    /**
     * 获取 答辩地址 字段:reply_team.team_address
     *
     * @return reply_team.team_address, 答辩地址
     */
    public String getTeamAddress() {
        return teamAddress;
    }

    /**
     * 设置 答辩地址 字段:reply_team.team_address
     *
     * @param teamAddress the value for reply_team.team_address, 答辩地址
     */
    public void setTeamAddress(String teamAddress) {
        this.teamAddress = teamAddress == null ? null : teamAddress.trim();
    }

    /**
     * 获取 答辩时间 字段:reply_team.reply_time
     *
     * @return reply_team.reply_time, 答辩时间
     */
    public String getReplyTime() {
        return DateUtil.formatDateTime(replyTime);
    }

    /**
     * 设置 答辩时间 字段:reply_team.reply_time
     *
     * @param replyTime the value for reply_team.reply_time, 答辩时间
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * 获取 答辩组长id 字段:reply_team.team_leader_id
     *
     * @return reply_team.team_leader_id, 答辩组长id
     */
    public String getTeamLeaderId() {
        return teamLeaderId;
    }

    /**
     * 设置 答辩组长id 字段:reply_team.team_leader_id
     *
     * @param teamLeaderId the value for reply_team.team_leader_id, 答辩组长id
     */
    public void setTeamLeaderId(String teamLeaderId) {
        this.teamLeaderId = teamLeaderId == null ? null : teamLeaderId.trim();
    }

    @JsonIgnore
    public Teacher getTeacher() {
        return teacher;
    }

    @JsonGetter(value = "teacher")
    public Teacher getTeacherDetail() {//自定的方法
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ReplyTeam() {
    }
}