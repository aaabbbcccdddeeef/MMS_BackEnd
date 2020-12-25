package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csh.mms.dao.SaleRecordDao;
import com.csh.mms.domain.SaleRecord;
import com.csh.mms.dto.SaleInventoryProdDto;
import com.csh.mms.service.SaleService;
import com.github.pagehelper.Page;

@Service
public class SaleRecordServiceImpl implements SaleService {
	
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

	@Override
	public Page<SaleInventoryProdDto> getSaleList(SaleInventoryProdDto dto) {
		Page<SaleInventoryProdDto> data = saleRecordDao.getSaleList(dto);
		return data;
	}


}
