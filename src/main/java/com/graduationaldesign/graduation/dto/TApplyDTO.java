package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.Apply;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.util.Date;
import java.io.Serializable;


public class TApplyDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**申请导师id，外键*/
        private String applyTeaId;
        /**申请内容*/
        private String applyContent;
        /**申请理由*/
        private String applyReason;
        /**处理状态，1是待处理，2是已处理*/
        private Integer applyState;
        /**处理反馈*/
        private String applyReply;
        /**关联学生id*/
        private String applyStuId;
        /**关联课题*/
        private String applySubId;
        /**申请时间*/
        private Date applyTime;
        /**处理时间*/
        private Date applyReplyTime;
        
        public String getApplyTeaId() {
            return this.applyTeaId;
        }
        
        public void setApplyTeaId(String applyTeaId) {
            this.applyTeaId = applyTeaId;
        }
        
        public String getApplyContent() {
            return this.applyContent;
        }
        
        public void setApplyContent(String applyContent) {
            this.applyContent = applyContent;
        }
        
        public String getApplyReason() {
            return this.applyReason;
        }
        
        public void setApplyReason(String applyReason) {
            this.applyReason = applyReason;
        }
        
        public Integer getApplyState() {
            return this.applyState;
        }
        
        public void setApplyState(Integer applyState) {
            this.applyState = applyState;
        }
        
        public String getApplyReply() {
            return this.applyReply;
        }
        
        public void setApplyReply(String applyReply) {
            this.applyReply = applyReply;
        }
        
        public String getApplyStuId() {
            return this.applyStuId;
        }
        
        public void setApplyStuId(String applyStuId) {
            this.applyStuId = applyStuId;
        }
        
        public String getApplySubId() {
            return this.applySubId;
        }
        
        public void setApplySubId(String applySubId) {
            this.applySubId = applySubId;
        }
        
        public Date getApplyTime() {
            return this.applyTime;
        }
        
        public void setApplyTime(Date applyTime) {
            this.applyTime = applyTime;
        }
        
        public Date getApplyReplyTime() {
            return this.applyReplyTime;
        }
        
        public void setApplyReplyTime(Date applyReplyTime) {
            this.applyReplyTime = applyReplyTime;
        }
        
        public Apply toModel() {
            Apply model = new Apply();
			BeanUtil.convert(this, model);
			return model;
        }
    
}