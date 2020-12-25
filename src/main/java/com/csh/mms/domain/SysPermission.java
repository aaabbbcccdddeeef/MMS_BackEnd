package com.csh.mms.domain;

/**
 * 
 * @ClassName  PermissionDomain 
 * @Description 用户权限实体类
 * @author csh
 * @date  2020年10月31日 下午10:33:32 
 *
 */
public class SysPermission {

	private String id;
	private String permissionName;
	private String permissionCode;
	private String userId;
	private String roleId;
	private String remark; 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	 
}
