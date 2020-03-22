package com.graduationaldesign.graduation.pojo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graduationaldesign.graduation.pojo.helper.Column;
import com.graduationaldesign.graduation.pojo.helper.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Table(value = "t_scorerecord")
@JsonIgnoreProperties(value = {"handler"})
public class ScoreRecord implements Serializable {
    /**
     * 表字段 : t_scorerecord.id
     */
    @Column(columnName = "id")
    private Integer id;

    /**
     * 表字段 : t_scorerecord.score_sub_id
     */
    @Column(columnName = "score_sub_id")
    private String scoreSubId;

    /**
     * 表字段 : t_scorerecord.first_report_score
     */
    @Column(columnName = "first_report_score")
    private Long firstReportScore;

    /**
     * 表字段 : t_scorerecord.final_report_score
     */
    @Column(columnName = "final_report_score")
    private Long finalReportScore;

    /**
     * 表字段 : t_scorerecord.reply_score_
     */
    @Column(columnName = "reply_score_")
    private Long replyScore;

    /**
     * 表字段 : t_scorerecord.reply_team_id
     */
    @Column(columnName = "reply_team_id")
    private Integer replyTeamId;

    /**
     * 表字段 : t_scorerecord.ext1
     */
    @Column(columnName = "ext1")
    private String ext1;

    /**
     * 表字段 : t_scorerecord.ext2
     */
    @Column(columnName = "ext2")
    private String ext2;

    private Subject subject;

    private ReplyTeam replyTeam;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_scorerecord
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:t_scorerecord.id
     *
     * @return t_scorerecord.id,
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:t_scorerecord.id
     *
     * @param id the value for t_scorerecord.id,
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:t_scorerecord.score_sub_id
     *
     * @return t_scorerecord.score_sub_id,
     */
    public String getScoreSubId() {
        return scoreSubId;
    }

    /**
     * 设置  字段:t_scorerecord.score_sub_id
     *
     * @param scoreSubId the value for t_scorerecord.score_sub_id,
     */
    public void setScoreSubId(String scoreSubId) {
        this.scoreSubId = scoreSubId == null ? null : scoreSubId.trim();
    }

    /**
     * 获取  字段:t_scorerecord.first_report_score
     *
     * @return t_scorerecord.first_report_score,
     */
    public Long getFirstReportScore() {
        return firstReportScore;
    }

    /**
     * 设置  字段:t_scorerecord.first_report_score
     *
     * @param firstReportScore the value for t_scorerecord.first_report_score,
     */
    public void setFirstReportScore(Long firstReportScore) {
        this.firstReportScore = firstReportScore;
    }

    /**
     * 获取  字段:t_scorerecord.final_report_score
     *
     * @return t_scorerecord.final_report_score,
     */
    public Long getFinalReportScore() {
        return finalReportScore;
    }

    /**
     * 设置  字段:t_scorerecord.final_report_score
     *
     * @param finalReportScore the value for t_scorerecord.final_report_score,
     */
    public void setFinalReportScore(Long finalReportScore) {
        this.finalReportScore = finalReportScore;
    }

    /**
     * 获取  字段:t_scorerecord.reply_score_
     *
     * @return t_scorerecord.reply_score_,
     */
    public Long getReplyScore() {
        return replyScore;
    }

    /**
     * 设置  字段:t_scorerecord.reply_score_
     *
     * @param replyScore the value for t_scorerecord.reply_score_,
     */
    public void setReplyScore(Long replyScore) {
        this.replyScore = replyScore;
    }

    /**
     * 获取  字段:t_scorerecord.reply_team_id
     *
     * @return t_scorerecord.reply_team_id,
     */
    public Integer getReplyTeamId() {
        return replyTeamId;
    }

    /**
     * 设置  字段:t_scorerecord.reply_team_id
     *
     * @param replyTeamId the value for t_scorerecord.reply_team_id,
     */
    public void setReplyTeamId(Integer replyTeamId) {
        this.replyTeamId = replyTeamId;
    }

    /**
     * 获取  字段:t_scorerecord.ext1
     *
     * @return t_scorerecord.ext1,
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置  字段:t_scorerecord.ext1
     *
     * @param ext1 the value for t_scorerecord.ext1,
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * 获取  字段:t_scorerecord.ext2
     *
     * @return t_scorerecord.ext2,
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 设置  字段:t_scorerecord.ext2
     *
     * @param ext2 the value for t_scorerecord.ext2,
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public Subject getSubject() {
        return subject;
    }

    @JsonGetter(value = "subject")
    public Subject getSubjectDetail() {//自定的方法
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

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

    public ScoreRecord(String scoreSubId) {
        this.scoreSubId = scoreSubId;
    }
}