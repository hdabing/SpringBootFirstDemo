package com.example.demo.entity;

import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    /**
     * id
     */
    @Id
    private String id;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 描述
     */
    @Column(name = "role_desc")
    private String roleDesc;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取描述
     *
     * @return role_desc - 描述
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * 设置描述
     *
     * @param roleDesc 描述
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }
}