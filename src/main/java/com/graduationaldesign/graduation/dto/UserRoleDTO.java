package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.util.BeanUtil;
import com.graduationaldesign.graduation.pojo.UserRole;
import java.io.Serializable;


public class UserRoleDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**管理员id，外键*/
        private String adminId;
        /**角色id，外键*/
        private Long roleId;
        
        public String getAdminId() {
            return this.adminId;
        }
        
        public void setAdminId(String adminId) {
            this.adminId = adminId;
        }
        
        public Long getRoleId() {
            return this.roleId;
        }
        
        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }
        
        public UserRole toModel() {
            UserRole model = new UserRole();
			BeanUtil.convert(this, model);
			return model;
        }
    
}