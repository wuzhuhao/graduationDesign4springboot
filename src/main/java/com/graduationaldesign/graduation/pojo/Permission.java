package com.graduationaldesign.graduation.pojo;

import com.graduationaldesign.graduation.pojo.helper.Column;
import com.graduationaldesign.graduation.pojo.helper.MyPrimaryKey;
import com.graduationaldesign.graduation.pojo.helper.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Table(value = "t_permission")
public class Permission implements Serializable {

    /**
     * 表字段 : t_permission.id
     */
    @MyPrimaryKey
    @Column(columnName = "id", viewName = "permissionId")
    private Long id;

    /**
     * 权限名字
     * 表字段 : t_permission.per_name
     */
    @Column(columnName = "per_name")
    private String perName;

    /**
     * 权限描述
     * 表字段 : t_permission.per_desc
     */
    @Column(columnName = "per_desc")
    private String perDesc;

    /**
     * 权限url
     * 表字段 : t_permission.per_url
     */
    @Column(columnName = "per_url")
    private String perUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_permission
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:t_permission.id
     *
     * @return t_permission.id,
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:t_permission.id
     *
     * @param id the value for t_permission.id,
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 权限名字 字段:t_permission.per_name
     *
     * @return t_permission.per_name, 权限名字
     */
    public String getPerName() {
        return perName;
    }

    /**
     * 设置 权限名字 字段:t_permission.per_name
     *
     * @param perName the value for t_permission.per_name, 权限名字
     */
    public void setPerName(String perName) {
        this.perName = perName == null ? null : perName.trim();
    }

    /**
     * 获取 权限描述 字段:t_permission.per_desc
     *
     * @return t_permission.per_desc, 权限描述
     */
    public String getPerDesc() {
        return perDesc;
    }

    /**
     * 设置 权限描述 字段:t_permission.per_desc
     *
     * @param perDesc the value for t_permission.per_desc, 权限描述
     */
    public void setPerDesc(String perDesc) {
        this.perDesc = perDesc == null ? null : perDesc.trim();
    }

    /**
     * 获取 权限url 字段:t_permission.per_url
     *
     * @return t_permission.per_url, 权限url
     */
    public String getPerUrl() {
        return perUrl;
    }

    /**
     * 设置 权限url 字段:t_permission.per_url
     *
     * @param perUrl the value for t_permission.per_url, 权限url
     */
    public void setPerUrl(String perUrl) {
        this.perUrl = perUrl == null ? null : perUrl.trim();
    }
}