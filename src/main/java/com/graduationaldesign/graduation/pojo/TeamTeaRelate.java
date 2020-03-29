package com.graduationaldesign.graduation.pojo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.graduationaldesign.graduation.pojo.helper.Column;
import com.graduationaldesign.graduation.pojo.helper.MyPrimaryKey;
import com.graduationaldesign.graduation.pojo.helper.Table;

import java.io.Serializable;

/**
 * @author wuzhuhao
 */
@Table(value = "team_tea_relate")
public class TeamTeaRelate implements Serializable {
    /**
     * 表字段 : team_tea_relate.id
     */
    @MyPrimaryKey
    @Column(columnName = "id")
    private Integer id;

    /**
     * 表字段 : team_tea_relate.team_tea_id
     */
    @Column(columnName = "team_tea_id")
    private String teamTeaId;

    /**
     * 表字段 : team_tea_relate.team_id
     */
    @Column(columnName = "team_id")
    private Integer teamId;

    /**
     * 表字段 : team_tea_relate.ext1
     */
    @Column(columnName = "ext1")
    private String ext1;

    /**
     * 表字段 : team_tea_relate.ext2
     */
    @Column(columnName = "ext2")
    private String ext2;

    /**
     * 表字段 : team_tea_relate.ext3
     */
    @Column(columnName = "ext3")
    private String ext3;

    private ReplyTeam replyTeam;

    private Teacher teacher;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team_tea_relate
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:team_tea_relate.id
     *
     * @return team_tea_relate.id,
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:team_tea_relate.id
     *
     * @param id the value for team_tea_relate.id,
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:team_tea_relate.team_tea_id
     *
     * @return team_tea_relate.team_tea_id,
     */
    public String getTeamTeaId() {
        return teamTeaId;
    }

    /**
     * 设置  字段:team_tea_relate.team_tea_id
     *
     * @param teamTeaId the value for team_tea_relate.team_tea_id,
     */
    public void setTeamTeaId(String teamTeaId) {
        this.teamTeaId = teamTeaId == null ? null : teamTeaId.trim();
    }

    /**
     * 获取  字段:team_tea_relate.team_id
     *
     * @return team_tea_relate.team_id,
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * 设置  字段:team_tea_relate.team_id
     *
     * @param teamId the value for team_tea_relate.team_id,
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    /**
     * 获取  字段:team_tea_relate.ext1
     *
     * @return team_tea_relate.ext1,
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置  字段:team_tea_relate.ext1
     *
     * @param ext1 the value for team_tea_relate.ext1,
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * 获取  字段:team_tea_relate.ext2
     *
     * @return team_tea_relate.ext2,
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 设置  字段:team_tea_relate.ext2
     *
     * @param ext2 the value for team_tea_relate.ext2,
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * 获取  字段:team_tea_relate.ext3
     *
     * @return team_tea_relate.ext3,
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * 设置  字段:team_tea_relate.ext3
     *
     * @param ext3 the value for team_tea_relate.ext3,
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    @JsonIgnore
    public ReplyTeam getReplyTeam() {
        return replyTeam;
    }

    @JsonGetter(value = "replyTeam")
    public ReplyTeam getReplyTeamDetail() {//自定的方法
        return replyTeam;
    }

    public void setReplyTeam(ReplyTeam replyTeam) {
        this.replyTeam = replyTeam;
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

    public TeamTeaRelate() {
    }

    public TeamTeaRelate(String teamTeaId, Integer teamId) {
        this.teamTeaId = teamTeaId;
        this.teamId = teamId;
    }
}