package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.DesignShow;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.util.Date;
import java.io.Serializable;


public class TDesignshowDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        
        private String subId;
        /**展示内容*/
        private String showContent;
        /**附件*/
        private String showFile;
        /**上传时间*/
        private Date showTime;
        
        public String getSubId() {
            return this.subId;
        }
        
        public void setSubId(String subId) {
            this.subId = subId;
        }
        
        public String getShowContent() {
            return this.showContent;
        }
        
        public void setShowContent(String showContent) {
            this.showContent = showContent;
        }
        
        public String getShowFile() {
            return this.showFile;
        }
        
        public void setShowFile(String showFile) {
            this.showFile = showFile;
        }
        
        public Date getShowTime() {
            return this.showTime;
        }
        
        public void setShowTime(Date showTime) {
            this.showTime = showTime;
        }
        
        public DesignShow toModel() {
            DesignShow model = new DesignShow();
			BeanUtil.convert(this, model);
			return model;
        }
    
}