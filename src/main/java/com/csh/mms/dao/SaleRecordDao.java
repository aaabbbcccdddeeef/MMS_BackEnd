package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;

import com.csh.mms.domain.SaleRecord;
import com.csh.mms.dto.SaleInventoryProdDto;
import com.github.pagehelper.Page;

@Mapper
public interface SaleRecordDao {
	
    SaleRecord getSaleRecord(String id);
    
    SaleRecord insertSaleRecord(SaleRecord saleRecord);
    
	SaleRecord updateSaleRecord(SaleRecord saleRecord);
	
	SaleRecord deleteSaleRecord(String id);

	Page<SaleInventoryProdDto> getSaleList(SaleInventoryProdDto dto);
	 
}
