package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.Operation;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.util.Date;
import java.io.Serializable;


public class LogOperationDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**操作内容*/
        private String operaContent;
        /**操作人*/
        private String operaRole;
        /**操作时间*/
        private Date operaTime;
        
        public String getOperaContent() {
            return this.operaContent;
        }
        
        public void setOperaContent(String operaContent) {
            this.operaContent = operaContent;
        }
        
        public String getOperaRole() {
            return this.operaRole;
        }
        
        public void setOperaRole(String operaRole) {
            this.operaRole = operaRole;
        }
        
        public Date getOperaTime() {
            return this.operaTime;
        }
        
        public void setOperaTime(Date operaTime) {
            this.operaTime = operaTime;
        }
        
        public Operation toModel() {
            Operation model = new Operation();
			BeanUtil.convert(this, model);
			return model;
        }
    
}