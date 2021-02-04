package com.csh.mms.service;

import com.csh.mms.dto.SaleInventoryProdDto;
import com.github.pagehelper.Page;

public interface SaleService {

	void insertSaleRecord(SaleInventoryProdDto dto);

	void updateSaleRecord(SaleInventoryProdDto dto);

	void deleteSaleRecord(SaleInventoryProdDto dto);

	Page<SaleInventoryProdDto> getSaleList(SaleInventoryProdDto dto);

}
