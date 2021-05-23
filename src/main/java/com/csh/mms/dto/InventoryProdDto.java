package com.csh.mms.dto;

import java.sql.Timestamp;

/**
 * 
 * @ClassName  InventoryInfoDomain 
 * @Description 库存实体类
 * @author csh
 * @date  2020年10月31日 下午10:21:09 
 *
 */
public class InventoryProdDto {
	
	private String id;
	private String productionId;
	private String arrivalBatch;
	private Integer per;
	private Integer suite;
	private String totalNumber;
	private String totalSets;
	private String productionName;
	private String productionType;
	private String productionTypeId;
	private String frequency;
	private String size;
	private String pitch;
	private String color1;
	private String color2;
	private String pack;
	private String creatorId;
	private String creator;
	private Timestamp createTime;
	private String modifierId;
	private String modifier;
	private Timestamp updateTime;
	private String inventoryWarning;
	private String enableDelete;
	private String remark;
	private int pageNum = 1;
	private int pageSize = 10;
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
	public Integer getPer() {
		return per;
	}
	public void setPer(Integer per) {
		this.per = per;
	}
	public Integer getSuite() {
		return suite;
	}
	public void setSuite(Integer suite) {
		this.suite = suite;
	}
	public String getProductionName() {
		return productionName;
	}
	public void setProductionName(String productionName) {
		this.productionName = productionName;
	}
	public String getProductionType() {
		return productionType;
	}
	public void setProductionType(String productionType) {
		this.productionType = productionType;
	}
	public String getProductionTypeId() {
		return productionTypeId;
	}
	public void setProductionTypeId(String productionTypeId) {
		this.productionTypeId = productionTypeId;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPitch() {
		return pitch;
	}
	public void setPitch(String pitch) {
		this.pitch = pitch;
	}
	public String getColor1() {
		return color1;
	}
	public void setColor1(String color1) {
		this.color1 = color1;
	}
	public String getColor2() {
		return color2;
	}
	public void setColor2(String color2) {
		this.color2 = color2;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
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
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateTime
	 */
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getEnableDelete() {
		return enableDelete;
	}
	public void setEnableDelete(String enableDelete) {
		this.enableDelete = enableDelete;
	}
	public String getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(String totalNumber) {
		this.totalNumber = totalNumber;
	}
	public String getTotalSets() {
		return totalSets;
	}
	public void setTotalSets(String totalSets) {
		this.totalSets = totalSets;
	}
	
}
