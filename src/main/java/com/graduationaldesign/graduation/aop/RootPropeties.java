package com.graduationaldesign.graduation.aop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取全局参数
 *
 * @Author: wuzhuhao
 * @Date: 2020/1/31 16:59
 */
@Component
@ConfigurationProperties(prefix = "root", ignoreUnknownFields = true)
public class RootPropeties {

    //分页页数
    private Integer pageSize;
    //session名称
    private String userAttribute;

    //类对应的字段名称
    private String admin;
    private String academy;
    private String apply;
    private String designShow;
    private String goodGraduation;
    private String notice;
    private String operation;
    private String permission;
    private String progress;
    private String replyTeam;
    private String report;
    private String role;
    private String rolePermission;
    private String student;
    private String subject;
    private String task;
    private String teacher;
    private String userRole;
    private String scoreRecord;
    private String sysdict;
    private String teamTeaRelate;

    public String getSysdict() {
        return sysdict;
    }

    public void setSysdict(String sysdict) {
        this.sysdict = sysdict;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    public String getDesignShow() {
        return designShow;
    }

    public void setDesignShow(String designShow) {
        this.designShow = designShow;
    }

    public String getGoodGraduation() {
        return goodGraduation;
    }

    public void setGoodGraduation(String goodGraduation) {
        this.goodGraduation = goodGraduation;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getReplyTeam() {
        return replyTeam;
    }

    public void setReplyTeam(String replyTeam) {
        this.replyTeam = replyTeam;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRolePermission() {
        return rolePermission;
    }

    public void setRolePermission(String rolePermission) {
        this.rolePermission = rolePermission;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getUserAttribute() {
        return userAttribute;
    }

    public void setUserAttribute(String userAttribute) {
        this.userAttribute = userAttribute;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getScoreRecord() {
        return scoreRecord;
    }

    public void setScoreRecord(String scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    public String getTeamTeaRelate() {
        return teamTeaRelate;
    }

    public void setTeamTeaRelate(String teamTeaRelate) {
        this.teamTeaRelate = teamTeaRelate;
    }
}
