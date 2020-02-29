package com.graduationaldesign.graduation.pojo;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graduationaldesign.graduation.pojo.helper.MyPrimaryKey;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class Notice implements Serializable {

    /**
     * 自增id
     * 表字段 : t_notice.id
     */
    @MyPrimaryKey
    private Integer id;

    /**
     * 公告发布时间
     * 表字段 : t_notice.notice_time
     */
    private Date noticeTime;

    /**
     * 公告发布人
     * 表字段 : t_notice.notice_publisher
     */
    private String noticePublisher;

    /**
     * 学院id，外键学院表
     * 表字段 : t_notice.aca_id
     */
    private Integer acaId;

    /**
     * 公告内容
     * 表字段 : t_notice.notice_content
     */
    private String noticeContent;

    private Academy academy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_notice
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 自增id 字段:t_notice.id
     *
     * @return t_notice.id, 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增id 字段:t_notice.id
     *
     * @param id the value for t_notice.id, 自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 公告发布时间 字段:t_notice.notice_time
     *
     * @return t_notice.notice_time, 公告发布时间
     */
    public String getNoticeTime() {
        return DateUtil.formatDateTime(noticeTime);
    }

    /**
     * 设置 公告发布时间 字段:t_notice.notice_time
     *
     * @param noticeTime the value for t_notice.notice_time, 公告发布时间
     */
    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    /**
     * 获取 公告发布人 字段:t_notice.notice_publisher
     *
     * @return t_notice.notice_publisher, 公告发布人
     */
    public String getNoticePublisher() {
        return noticePublisher;
    }

    /**
     * 设置 公告发布人 字段:t_notice.notice_publisher
     *
     * @param noticePublisher the value for t_notice.notice_publisher, 公告发布人
     */
    public void setNoticePublisher(String noticePublisher) {
        this.noticePublisher = noticePublisher == null ? null : noticePublisher.trim();
    }

    /**
     * 获取 学院id，外键学院表 字段:t_notice.aca_id
     *
     * @return t_notice.aca_id, 学院id，外键学院表
     */
    public Integer getAcaId() {
        return acaId;
    }

    /**
     * 设置 学院id，外键学院表 字段:t_notice.aca_id
     *
     * @param acaId the value for t_notice.aca_id, 学院id，外键学院表
     */
    public void setAcaId(Integer acaId) {
        this.acaId = acaId;
    }

    /**
     * 获取 公告内容 字段:t_notice.notice_content
     *
     * @return t_notice.notice_content, 公告内容
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 设置 公告内容 字段:t_notice.notice_content
     *
     * @param noticeContent the value for t_notice.notice_content, 公告内容
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    @JsonIgnore
    public Academy getAcademy() {
        return academy;
    }

    @JsonGetter(value = "academy")
    public Academy getAcademyDetail() {//自定的方法
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
}