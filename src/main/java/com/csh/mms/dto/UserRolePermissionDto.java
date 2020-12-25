package com.csh.mms.dto;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 * 
 * @ClassName  InventoryInfoDomain 
 * @Description 库存实体类
 * @author csh
 * @date  2020年10月31日 下午10:21:09 
 *
 */
public class UserRolePermissionDto {
	
	private String id;
	private String account;
	private String password;
	private String name;
	private String sex;
	private Blob icon;
	private String mobilePhone;
	private String alias;
	private String mail;
	private String slogan;
	private String enableDelete;
	private String creatorId;
	private String creator;
	private Timestamp createTime;
	private String modifierId;
	private String modifier;
	private Timestamp updateTime;
	private String remark;
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getModifierId() {
		return modifierId;
	}
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String roleId;
	private String roleName;
	private String roleCode;
	private String roleDescription;
	private Timestamp roleCreateTime;
	private String roleCreator;
	private String roleRemark;
	private String permId;
	private String permUserId;
	private String permRoleId;
	private String permName;
	private String permCode;
	private String permCreator;
	private String permModifier;
	private Timestamp permCreateTime;
	private Timestamp permUpdateTime;
	private int pageNum = 1;
	private int pageSize = 10;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Blob getIcon() {
		return icon;
	}
	public void setIcon(Blob icon) {
		this.icon = icon;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
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
	public String getRoleRemark() {
		return roleRemark;
	}
	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}
	public String getPermId() {
		return permId;
	}
	public void setPermId(String permId) {
		this.permId = permId;
	}
	public String getPermUserId() {
		return permUserId;
	}
	public void setPermUserId(String permUserId) {
		this.permUserId = permUserId;
	}
	public String getPermRoleId() {
		return permRoleId;
	}
	public void setPermRoleId(String permRoleId) {
		this.permRoleId = permRoleId;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public String getPermCode() {
		return permCode;
	}
	public void setPermCode(String permCode) {
		this.permCode = permCode;
	}
	public String getPermCreator() {
		return permCreator;
	}
	public void setPermCreator(String permCreator) {
		this.permCreator = permCreator;
	}
	public String getPermModifier() {
		return permModifier;
	}
	public void setPermModifier(String permModifier) {
		this.permModifier = permModifier;
	}
	public Timestamp getPermCreateTime() {
		return permCreateTime;
	}
	public void setPermCreateTime(Timestamp permCreateTime) {
		this.permCreateTime = permCreateTime;
	}
	public Timestamp getPermUpdateTime() {
		return permUpdateTime;
	}
	public void setPermUpdateTime(Timestamp permUpdateTime) {
		this.permUpdateTime = permUpdateTime;
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
	/**
	 * @return the roleCreator
	 */
	public String getRoleCreator() {
		return roleCreator;
	}
	/**
	 * @param roleCreator the roleCreator to set
	 */
	public void setRoleCreator(String roleCreator) {
		this.roleCreator = roleCreator;
	}
	/**
	 * @return the roleCreateTime
	 */
	public Timestamp getRoleCreateTime() {
		return roleCreateTime;
	}
	/**
	 * @param roleCreateTime the roleCreateTime to set
	 */
	public void setRoleCreateTime(Timestamp roleCreateTime) {
		this.roleCreateTime = roleCreateTime;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnableDelete() {
		return enableDelete;
	}
	public void setEnableDelete(String enableDelete) {
		this.enableDelete = enableDelete;
	}
}
