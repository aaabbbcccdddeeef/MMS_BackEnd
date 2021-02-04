package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;

import com.csh.mms.dto.SaleInventoryProdDto;
import com.github.pagehelper.Page;

@Mapper
public interface SaleRecordDao {
	
    void insertSaleRecord(SaleInventoryProdDto dto);
    
	void updateSaleRecord(SaleInventoryProdDto dto);
	
	void deleteSaleRecord(SaleInventoryProdDto dto);

	Page<SaleInventoryProdDto> getSaleList(SaleInventoryProdDto dto);
	 
}
