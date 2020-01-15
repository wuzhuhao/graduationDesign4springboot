package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.util.BeanUtil;
import com.graduationaldesign.graduation.pojo.Progress;
import java.util.Date;
import java.io.Serializable;


public class TProgressDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**课题id，外键课题表id*/
        private String subId;
        /**问题内容*/
        private String progContent;
        /**问题发表时间*/
        private Date progContentTime;
        /**导师回复内容*/
        private String progReply;
        /**导师回复时间*/
        private Date progReplyTime;
        
        public String getSubId() {
            return this.subId;
        }
        
        public void setSubId(String subId) {
            this.subId = subId;
        }
        
        public String getProgContent() {
            return this.progContent;
        }
        
        public void setProgContent(String progContent) {
            this.progContent = progContent;
        }
        
        public Date getProgContentTime() {
            return this.progContentTime;
        }
        
        public void setProgContentTime(Date progContentTime) {
            this.progContentTime = progContentTime;
        }
        
        public String getProgReply() {
            return this.progReply;
        }
        
        public void setProgReply(String progReply) {
            this.progReply = progReply;
        }
        
        public Date getProgReplyTime() {
            return this.progReplyTime;
        }
        
        public void setProgReplyTime(Date progReplyTime) {
            this.progReplyTime = progReplyTime;
        }
        
        public Progress toModel() {
            Progress model = new Progress();
			BeanUtil.convert(this, model);
			return model;
        }
    
}