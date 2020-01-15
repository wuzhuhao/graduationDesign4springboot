package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.util.BeanUtil;
import java.util.Date;
import com.graduationaldesign.graduation.pojo.ReplyTeam;
import java.io.Serializable;


public class ReplyTeamDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**答辩组名称*/
        private String teamName;
        /**答辩地址*/
        private String teamAddress;
        /**答辩时间*/
        private Date replyTime;
        /**答辩组长id*/
        private String teamLeaderId;
        
        public String getTeamName() {
            return this.teamName;
        }
        
        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }
        
        public String getTeamAddress() {
            return this.teamAddress;
        }
        
        public void setTeamAddress(String teamAddress) {
            this.teamAddress = teamAddress;
        }
        
        public Date getReplyTime() {
            return this.replyTime;
        }
        
        public void setReplyTime(Date replyTime) {
            this.replyTime = replyTime;
        }
        
        public String getTeamLeaderId() {
            return this.teamLeaderId;
        }
        
        public void setTeamLeaderId(String teamLeaderId) {
            this.teamLeaderId = teamLeaderId;
        }
        
        public ReplyTeam toModel() {
            ReplyTeam model = new ReplyTeam();
			BeanUtil.convert(this, model);
			return model;
        }
    
}