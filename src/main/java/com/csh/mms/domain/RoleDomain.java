package com.csh.mms.domain;

import java.util.Set;

public class RoleDomain {
	
	private String id;
	private String roleName;
	private String roleCode;
	private String roleDescription;
	private String remark;
	/**
     * 角色对应权限集合
     */
    private Set<PermissionDomain> permission;
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
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<PermissionDomain> getPermission() {
		return permission;
	}
	public void setPermission(Set<PermissionDomain> permission) {
		this.permission = permission;
	}
	

}
