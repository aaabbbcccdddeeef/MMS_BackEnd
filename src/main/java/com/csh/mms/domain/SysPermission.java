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
	private String remark; 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	 
}
