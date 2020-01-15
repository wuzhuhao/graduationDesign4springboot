package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.util.BeanUtil;
import com.graduationaldesign.graduation.pojo.Permission;
import java.io.Serializable;


public class TPermissionDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**权限名字*/
        private String perName;
        /**权限描述*/
        private String perDesc;
        /**权限url*/
        private String perUrl;
        
        public String getPerName() {
            return this.perName;
        }
        
        public void setPerName(String perName) {
            this.perName = perName;
        }
        
        public String getPerDesc() {
            return this.perDesc;
        }
        
        public void setPerDesc(String perDesc) {
            this.perDesc = perDesc;
        }
        
        public String getPerUrl() {
            return this.perUrl;
        }
        
        public void setPerUrl(String perUrl) {
            this.perUrl = perUrl;
        }
        
        public Permission toModel() {
            Permission model = new Permission();
			BeanUtil.convert(this, model);
			return model;
        }
    
}