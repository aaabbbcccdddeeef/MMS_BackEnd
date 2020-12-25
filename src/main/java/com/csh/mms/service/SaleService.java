package com.csh.mms.service;

import com.csh.mms.domain.SaleRecord;
import com.csh.mms.dto.SaleInventoryProdDto;
import com.github.pagehelper.Page;

public interface SaleService {

	SaleRecord getSaleRecord(String id);

	SaleRecord insertSaleRecord(SaleRecord saleRecord);

	SaleRecord updateSaleRecord(SaleRecord saleRecord);

	SaleRecord deleteSaleRecord(String id);

	Page<SaleInventoryProdDto> getSaleList(SaleInventoryProdDto dto);

}
