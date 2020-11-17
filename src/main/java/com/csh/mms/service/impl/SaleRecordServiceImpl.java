package com.csh.mms.service.impl;

 
 import org.springframework.beans.factory.annotation.Autowired;
import com.csh.mms.domain.SaleRecord;
 import com.csh.mms.service.SaleRecordService;
 import com.csh.mms.dao.SaleRecordDao;

public class SaleRecordServiceImpl implements SaleRecordService {
	
	@Autowired
	private SaleRecordDao saleRecordDao;
	
	@Override
	public SaleRecord getSaleRecord(String id) {
		SaleRecord saleRecordo = saleRecordDao.getSaleRecord(id);
		return saleRecordo;
	}

	@Override
	public SaleRecord insertSaleRecord(SaleRecord saleRecord) {
		SaleRecord saleRecordo = saleRecordDao.insertSaleRecord(saleRecord);
		return saleRecordo;	 
	}

	@Override
	public SaleRecord updateSaleRecord(SaleRecord saleRecord) {
		SaleRecord saleRecordo = saleRecordDao.updateSaleRecord(saleRecord);
		return saleRecordo;	 
	}

	@Override
	public SaleRecord deleteSaleRecord(String id) {
		SaleRecord saleRecordo = saleRecordDao.deleteSaleRecord(id);
		return saleRecordo;
	}


}
