package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.RolePermission;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.io.Serializable;


public class TRolePermissionDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**角色id，外键*/
        private Long roleId;
        /**权限id，外键*/
        private Long perId;
        
        public Long getRoleId() {
            return this.roleId;
        }
        
        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }
        
        public Long getPerId() {
            return this.perId;
        }
        
        public void setPerId(Long perId) {
            this.perId = perId;
        }
        
        public RolePermission toModel() {
            RolePermission model = new RolePermission();
			BeanUtil.convert(this, model);
			return model;
        }
    
}