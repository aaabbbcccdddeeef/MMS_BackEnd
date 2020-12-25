package com.csh.mms.domain;

import java.sql.Date;

/**
 * 
 * @ClassName  DictionaryDomain 
 * @Description 数据字典实体类
 * @author csh
 * @date  2020年10月31日 下午10:16:41 
 *
 */
public class SysDictionary {
	
	private String id;
	private String name;
	private String code;
	private String codeName;
	private String number;
	private String enableUse;
	private String enableDelete;
	private String creator;
	private Date createTime;
	private String modifier;
	private Date updateTime;
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEnableUse() {
		return enableUse;
	}
	public void setEnableUse(String enableUse) {
		this.enableUse = enableUse;
	}
	public String getEnableDelete() {
		return enableDelete;
	}
	public void setEnableDelete(String enableDelete) {
		this.enableDelete = enableDelete;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

}
