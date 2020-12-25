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
public class PermissionDto {
	private String id;
	private String permUserId;
	private String permRoleId;
	private String permName;
	private String permCode;
	private String creator;
	private String modifier;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String userId;
	private String userAccount;
	private String userName;
	private String sex;
	private Blob icon;
	private String mobile_phone;
	private String alias;
	private String mail;
	private String slogan;
	private String user_enable_delete;
	private String userCreatorId;
	private String userCreator;
	private Timestamp userCreateTime;
	private String userModifierId;
	private String userModifier;
	private Timestamp userUpdateTime;
	private String userRemark;
	private String roleId;
	private String roleName;
	private String roleCode;
	private String roleDescription;
	private Timestamp roleCreateTime;
	private String roleCreator;
	private String roleRemark;
	private int pageNum = 1;
	private int pageSize = 10;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	public String getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
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
	public String getUser_enable_delete() {
		return user_enable_delete;
	}
	public void setUser_enable_delete(String user_enable_delete) {
		this.user_enable_delete = user_enable_delete;
	}
	public String getUserCreatorId() {
		return userCreatorId;
	}
	public void setUserCreatorId(String userCreatorId) {
		this.userCreatorId = userCreatorId;
	}
	public String getUserCreator() {
		return userCreator;
	}
	public void setUserCreator(String userCreator) {
		this.userCreator = userCreator;
	}
	public Timestamp getUserCreateTime() {
		return userCreateTime;
	}
	public void setUserCreateTime(Timestamp userCreateTime) {
		this.userCreateTime = userCreateTime;
	}
	public String getUserModifierId() {
		return userModifierId;
	}
	public void setUserModifierId(String userModifierId) {
		this.userModifierId = userModifierId;
	}
	public String getUserModifier() {
		return userModifier;
	}
	public void setUserModifier(String userModifier) {
		this.userModifier = userModifier;
	}
	public Timestamp getUserUpdateTime() {
		return userUpdateTime;
	}
	public void setUserUpdateTime(Timestamp userUpdateTime) {
		this.userUpdateTime = userUpdateTime;
	}
	public String getUserRemark() {
		return userRemark;
	}
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
}
