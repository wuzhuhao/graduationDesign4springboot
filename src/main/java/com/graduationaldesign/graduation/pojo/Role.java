package com.graduationaldesign.graduation.pojo;

import com.graduationaldesign.graduation.pojo.helper.MyPrimaryKey;
import java.io.Serializable;
import lombok.Data;

@Data
public class Role implements Serializable {

    /**
     * 表字段 : t_role.id
     */
    @MyPrimaryKey
    private Long id;

    /**
     * 角色名称
     * 表字段 : t_role.role_name
     */
    private String roleName;

    /**
     * 描述
     * 表字段 : t_role.role_desc
     */
    private String roleDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_role
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:t_role.id
     *
     * @return t_role.id,
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:t_role.id
     *
     * @param id the value for t_role.id,
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 角色名称 字段:t_role.role_name
     *
     * @return t_role.role_name, 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置 角色名称 字段:t_role.role_name
     *
     * @param roleName the value for t_role.role_name, 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取 描述 字段:t_role.role_desc
     *
     * @return t_role.role_desc, 描述
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * 设置 描述 字段:t_role.role_desc
     *
     * @param roleDesc the value for t_role.role_desc, 描述
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }
}