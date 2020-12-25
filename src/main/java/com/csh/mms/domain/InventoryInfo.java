package com.csh.mms.domain;

import java.sql.Date;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

/**
 * 
 * @ClassName  InventoryInfoDomain 
 * @Description 库存实体类
 * @author csh
 * @date  2020年10月31日 下午10:21:09 
 *
 */
public class InventoryInfo {
	
	private String id;
	private String productionId;
	private String arrivalBatch;
	private String per;
	private String suite;
	private String creatorId;
	private String creator;
	private DateTime createTime;
	private String modifierId;
	private String modifier;
	private DateTime updateTime;
	private String inventoryWarning;
	private String enableDelete;
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductionId() {
		return productionId;
	}
	public void setProductionId(String productionId) {
		this.productionId = productionId;
	}
	public String getArrivalBatch() {
		return arrivalBatch;
	}
	public void setArrivalBatch(String arrivalBatch) {
		this.arrivalBatch = arrivalBatch;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
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
	public String getInventoryWarning() {
		return inventoryWarning;
	}
	public void setInventoryWarning(String inventoryWarning) {
		this.inventoryWarning = inventoryWarning;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEnableDelete() {
		return enableDelete;
	}
	public void setEnableDelete(String enableDelete) {
		this.enableDelete = enableDelete;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getModifierId() {
		return modifierId;
	}
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}
	/**
	 * @return the createTime
	 */
	public DateTime getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateTime
	 */
	public DateTime getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(DateTime updateTime) {
		this.updateTime = updateTime;
	}
	
}
