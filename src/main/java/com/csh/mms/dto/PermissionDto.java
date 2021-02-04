package com.csh.mms.dto;

/**
 * 
 * @ClassName  InventoryInfoDomain 
 * @Description 库存实体类
 * @author csh
 * @date  2020年10月31日 下午10:21:09 
 *
 */
public class PermissionDto {
	private String id;
	private String roleId;
	private String permissionName;
	private String remark;
	private int pageNum = 1;
	private int pageSize = 10;
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
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
