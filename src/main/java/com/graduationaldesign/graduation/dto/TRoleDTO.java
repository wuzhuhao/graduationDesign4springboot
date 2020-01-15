package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.Role;
import com.graduationaldesign.graduation.util.BeanUtil;
//import com.graduationaldesign.graduation.pojo.TRole;
import java.io.Serializable;


public class TRoleDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**角色名称*/
        private String roleName;
        /**描述*/
        private String roleDesc;
        
        public String getRoleName() {
            return this.roleName;
        }
        
        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }
        
        public String getRoleDesc() {
            return this.roleDesc;
        }
        
        public void setRoleDesc(String roleDesc) {
            this.roleDesc = roleDesc;
        }
        
        public Role toModel() {
            Role model = new Role();
			BeanUtil.convert(this, model);
			return model;
        }
    
}