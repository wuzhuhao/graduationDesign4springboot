package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.io.Serializable;


public class TAdminDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**登陆密码*/
        private String adminPassword;
        /**管理员名称*/
        private String adminName;
        /**性别*/
        private String adminSex;
        /**年龄*/
        private Integer adminAge;
        /**生日*/
        private String adminBirthday;
        /**电话*/
        private String adminPhone;
        /**邮箱*/
        private String adminMail;
        /**地址*/
        private String adminAddress;
        /**备注*/
        private String adminRemarks;
        /**1是小助手，2是超级管理员*/
        private Integer adminType;
        
        public String getAdminPassword() {
            return this.adminPassword;
        }
        
        public void setAdminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
        }
        
        public String getAdminName() {
            return this.adminName;
        }
        
        public void setAdminName(String adminName) {
            this.adminName = adminName;
        }
        
        public String getAdminSex() {
            return this.adminSex;
        }
        
        public void setAdminSex(String adminSex) {
            this.adminSex = adminSex;
        }
        
        public Integer getAdminAge() {
            return this.adminAge;
        }
        
        public void setAdminAge(Integer adminAge) {
            this.adminAge = adminAge;
        }
        
        public String getAdminBirthday() {
            return this.adminBirthday;
        }
        
        public void setAdminBirthday(String adminBirthday) {
            this.adminBirthday = adminBirthday;
        }
        
        public String getAdminPhone() {
            return this.adminPhone;
        }
        
        public void setAdminPhone(String adminPhone) {
            this.adminPhone = adminPhone;
        }
        
        public String getAdminMail() {
            return this.adminMail;
        }
        
        public void setAdminMail(String adminMail) {
            this.adminMail = adminMail;
        }
        
        public String getAdminAddress() {
            return this.adminAddress;
        }
        
        public void setAdminAddress(String adminAddress) {
            this.adminAddress = adminAddress;
        }
        
        public String getAdminRemarks() {
            return this.adminRemarks;
        }
        
        public void setAdminRemarks(String adminRemarks) {
            this.adminRemarks = adminRemarks;
        }
        
        public Integer getAdminType() {
            return this.adminType;
        }
        
        public void setAdminType(Integer adminType) {
            this.adminType = adminType;
        }
        
        public Admin toModel() {
            Admin model = new Admin();
			BeanUtil.convert(this, model);
			return model;
        }
    
}