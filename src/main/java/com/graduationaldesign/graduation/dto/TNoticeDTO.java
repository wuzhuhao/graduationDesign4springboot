package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.Notice;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.util.Date;
import java.io.Serializable;


public class TNoticeDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**公告内容*/
        private String noticeContent;
        /**公告发布时间*/
        private Date noticeTime;
        /**公告发布人*/
        private String noticePublisher;
        /**学院id，外键学院表*/
        private Integer acaId;
        
        public String getNoticeContent() {
            return this.noticeContent;
        }
        
        public void setNoticeContent(String noticeContent) {
            this.noticeContent = noticeContent;
        }
        
        public Date getNoticeTime() {
            return this.noticeTime;
        }
        
        public void setNoticeTime(Date noticeTime) {
            this.noticeTime = noticeTime;
        }
        
        public String getNoticePublisher() {
            return this.noticePublisher;
        }
        
        public void setNoticePublisher(String noticePublisher) {
            this.noticePublisher = noticePublisher;
        }
        
        public Integer getAcaId() {
            return this.acaId;
        }
        
        public void setAcaId(Integer acaId) {
            this.acaId = acaId;
        }
        
        public Notice toModel() {
            Notice model = new Notice();
			BeanUtil.convert(this, model);
			return model;
        }
    
}