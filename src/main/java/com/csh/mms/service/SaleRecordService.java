package com.csh.mms.service;

import com.csh.mms.domain.SaleRecord;

public interface SaleRecordService {

	SaleRecord getSaleRecord(String id);

	SaleRecord insertSaleRecord(SaleRecord saleRecord);

	SaleRecord updateSaleRecord(SaleRecord saleRecord);

	SaleRecord deleteSaleRecord(String id);

}
