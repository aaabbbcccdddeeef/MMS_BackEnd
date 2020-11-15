package com.csh.mms.domain;

import java.util.Set;

/**
 * 
 * @ClassName  RoleDomain 
 * @Description TODO
 * @author csh
 * @date  2020年10月31日 下午10:31:10 
 *
 */
public class SysRole {
	
	private String id;
	private String roleName;
	private String roleCode;
	private String roleDescription;
	private String userId;
	private String permissionId;
	private String remark;
	/**
     * 角色对应权限集合
     */
    private Set<SysPermission> permission;
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
	public Set<SysPermission> getPermission() {
		return permission;
	}
	public void setPermission(Set<SysPermission> permission) {
		this.permission = permission;
	}
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
