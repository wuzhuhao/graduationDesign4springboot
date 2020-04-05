package com.graduationaldesign.graduation.pojo;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.graduationaldesign.graduation.pojo.helper.Column;
import com.graduationaldesign.graduation.pojo.helper.MyPrimaryKey;
import com.graduationaldesign.graduation.pojo.helper.Table;
import com.graduationaldesign.graduation.util.JsonUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Data
@Table(value = "log_operation")
public class Operation implements Serializable {

    /**
     * 自增id
     * 表字段 : log_operation.id
     */
    @MyPrimaryKey
    @Column(columnName = "id")
    private Integer id;

    /**
     * 操作人
     * 表字段 : log_operation.opera_role
     */
    @Column(columnName = "opera_role")
    private String operaRole;

    /**
     * 操作时间
     * 表字段 : log_operation.opera_time
     */
    @Column(columnName = "opera_time")
    private Date operaTime;

    /**
     * 操作内容
     * 表字段 : log_operation.opera_content
     */
    @Column(columnName = "opera_content")
    private String operaContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table log_operation
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 自增id 字段:log_operation.id
     *
     * @return log_operation.id, 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 自增id 字段:log_operation.id
     *
     * @param id the value for log_operation.id, 自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 操作人 字段:log_operation.opera_role
     *
     * @return log_operation.opera_role, 操作人
     */
    public String getOperaRole() {
        return operaRole;
    }

    /**
     * 设置 操作人 字段:log_operation.opera_role
     *
     * @param operaRole the value for log_operation.opera_role, 操作人
     */
    public void setOperaRole(String operaRole) {
        this.operaRole = operaRole == null ? null : operaRole.trim();
    }

    /**
     * 获取 操作时间 字段:log_operation.opera_time
     *
     * @return log_operation.opera_time, 操作时间
     */
    @JsonIgnore
    public Date getOperaTime() {
        return operaTime;
    }

    @JsonGetter(value = "operaTime")
    public String getOperaTimeDetail() {//自定的方法
        return DateUtil.formatDateTime(operaTime);
    }

    /**
     * 设置 操作时间 字段:log_operation.opera_time
     *
     * @param operaTime the value for log_operation.opera_time, 操作时间
     */
    public void setOperaTime(Date operaTime) {
        this.operaTime = operaTime;
    }

    /**
     * 获取 操作内容 字段:log_operation.opera_content
     *
     * @return log_operation.opera_content, 操作内容
     */
    @JsonIgnore
    public String getOperaContent() {
        return operaContent;
    }

    @JsonGetter(value = "operaContent")
    public Map getOperaContentDetail() {//自定的方法
        return JsonUtils.jsonToPojo(operaContent, Map.class);
    }

    /**
     * 设置 操作内容 字段:log_operation.opera_content
     *
     * @param operaContent the value for log_operation.opera_content, 操作内容
     */
    public void setOperaContent(String operaContent) {
        this.operaContent = operaContent == null ? null : operaContent.trim();
    }
}