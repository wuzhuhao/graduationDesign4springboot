package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.GoodGraduation;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.util.Date;
import java.io.Serializable;


public class TGoodgraduationDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**外键课题id*/
        private String subId;
        /**评定理由*/
        private String goodReason;
        /**评定时间*/
        private Date goodTime;
        
        public String getSubId() {
            return this.subId;
        }
        
        public void setSubId(String subId) {
            this.subId = subId;
        }
        
        public String getGoodReason() {
            return this.goodReason;
        }
        
        public void setGoodReason(String goodReason) {
            this.goodReason = goodReason;
        }
        
        public Date getGoodTime() {
            return this.goodTime;
        }
        
        public void setGoodTime(Date goodTime) {
            this.goodTime = goodTime;
        }
        
        public GoodGraduation toModel() {
            GoodGraduation model = new GoodGraduation();
			BeanUtil.convert(this, model);
			return model;
        }
    
}