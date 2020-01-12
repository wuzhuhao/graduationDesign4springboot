package com.graduationaldesign.graduation.pojo;

import java.util.Set;
import com.graduationaldesign.graduation.pojo.Permissions;

public class Role {

    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;

    public Role(String id, String roleName, Set<Permissions> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }
}