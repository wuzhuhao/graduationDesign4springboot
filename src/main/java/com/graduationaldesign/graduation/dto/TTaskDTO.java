package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.util.BeanUtil;
import java.util.Date;
import com.graduationaldesign.graduation.pojo.Task;
import java.io.Serializable;


public class TTaskDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**主要内容*/
        private String taskContent;
        /**基本要求*/
        private String taskRequire;
        
        private String taskSchedule;
        /**应收集的资料及主要参考文献*/
        private String taskLiterature;
        /**任务附件*/
        private String taskFile;
        /**任务状态,，1是待接受，2是已接受*/
        private String taskState;
        /**点击次数*/
        private Integer taskNumber;
        /**课题id，外键对应课题表id*/
        private String taskSubId;
        /**回应内容*/
        private String replyContent;
        /**回复附件*/
        private String replyFile;
        /**任务发布时间*/
        private Date taskTime;
        /**回复时间*/
        private Date replyTime;
        
        public String getTaskContent() {
            return this.taskContent;
        }
        
        public void setTaskContent(String taskContent) {
            this.taskContent = taskContent;
        }
        
        public String getTaskRequire() {
            return this.taskRequire;
        }
        
        public void setTaskRequire(String taskRequire) {
            this.taskRequire = taskRequire;
        }
        
        public String getTaskSchedule() {
            return this.taskSchedule;
        }
        
        public void setTaskSchedule(String taskSchedule) {
            this.taskSchedule = taskSchedule;
        }
        
        public String getTaskLiterature() {
            return this.taskLiterature;
        }
        
        public void setTaskLiterature(String taskLiterature) {
            this.taskLiterature = taskLiterature;
        }
        
        public String getTaskFile() {
            return this.taskFile;
        }
        
        public void setTaskFile(String taskFile) {
            this.taskFile = taskFile;
        }
        
        public String getTaskState() {
            return this.taskState;
        }
        
        public void setTaskState(String taskState) {
            this.taskState = taskState;
        }
        
        public Integer getTaskNumber() {
            return this.taskNumber;
        }
        
        public void setTaskNumber(Integer taskNumber) {
            this.taskNumber = taskNumber;
        }
        
        public String getTaskSubId() {
            return this.taskSubId;
        }
        
        public void setTaskSubId(String taskSubId) {
            this.taskSubId = taskSubId;
        }
        
        public String getReplyContent() {
            return this.replyContent;
        }
        
        public void setReplyContent(String replyContent) {
            this.replyContent = replyContent;
        }
        
        public String getReplyFile() {
            return this.replyFile;
        }
        
        public void setReplyFile(String replyFile) {
            this.replyFile = replyFile;
        }
        
        public Date getTaskTime() {
            return this.taskTime;
        }
        
        public void setTaskTime(Date taskTime) {
            this.taskTime = taskTime;
        }
        
        public Date getReplyTime() {
            return this.replyTime;
        }
        
        public void setReplyTime(Date replyTime) {
            this.replyTime = replyTime;
        }
        
        public Task toModel() {
            Task model = new Task();
			BeanUtil.convert(this, model);
			return model;
        }
    
}