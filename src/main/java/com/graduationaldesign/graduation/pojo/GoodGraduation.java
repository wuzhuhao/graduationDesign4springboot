package com.graduationaldesign.graduation.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
public class GoodGraduation implements Serializable {

    /**
     * 表字段 : t_goodgraduation.id
     */
    @MyPrimaryKey
    @Excel(name = "展示内容", orderNum = "1")
    private Integer id;

    /**
     * 外键课题id
     * 表字段 : t_goodgraduation.good_sub_id
     */
    @Excel(name = "展示内容", orderNum = "1")
    private String goodSubId;

    /**
     * 评定时间
     * 表字段 : t_goodgraduation.good_time
     */
    @Excel(name = "展示内容", orderNum = "1")
    private Date goodTime;

    /**
     * 评定理由
     * 表字段 : t_goodgraduation.good_reason
     */
    @Excel(name = "展示内容", orderNum = "1")
    private String goodReason;

    private Subject subject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_goodgraduation
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:t_goodgraduation.id
     *
     * @return t_goodgraduation.id,
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:t_goodgraduation.id
     *
     * @param id the value for t_goodgraduation.id,
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 外键课题id 字段:t_goodgraduation.good_sub_id
     *
     * @return t_goodgraduation.good_sub_id, 外键课题id
     */
    public String getGoodSubId() {
        return goodSubId;
    }

    /**
     * 设置 外键课题id 字段:t_goodgraduation.good_sub_id
     *
     * @param goodSubId the value for t_goodgraduation.good_sub_id, 外键课题id
     */
    public void setGoodSubId(String goodSubId) {
        this.goodSubId = goodSubId == null ? null : goodSubId.trim();
    }

    /**
     * 获取 评定时间 字段:t_goodgraduation.good_time
     *
     * @return t_goodgraduation.good_time, 评定时间
     */
    public String getGoodTime() {
        return DateUtil.formatDateTime(goodTime);
    }

    /**
     * 设置 评定时间 字段:t_goodgraduation.good_time
     *
     * @param goodTime the value for t_goodgraduation.good_time, 评定时间
     */
    public void setGoodTime(Date goodTime) {
        this.goodTime = goodTime;
    }

    /**
     * 获取 评定理由 字段:t_goodgraduation.good_reason
     *
     * @return t_goodgraduation.good_reason, 评定理由
     */
    public String getGoodReason() {
        return goodReason;
    }

    /**
     * 设置 评定理由 字段:t_goodgraduation.good_reason
     *
     * @param goodReason the value for t_goodgraduation.good_reason, 评定理由
     */
    public void setGoodReason(String goodReason) {
        this.goodReason = goodReason == null ? null : goodReason.trim();
    }

    @JsonIgnore
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
}