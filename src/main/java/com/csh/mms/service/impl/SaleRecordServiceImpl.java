package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csh.mms.dao.SaleRecordDao;
import com.csh.mms.dto.SaleInventoryProdDto;
import com.csh.mms.service.SaleService;
import com.github.pagehelper.Page;

@Service
public class SaleRecordServiceImpl implements SaleService {
	
	@Autowired
	private SaleRecordDao saleRecordDao;

	@Override
	public Page<SaleInventoryProdDto> getSaleList(SaleInventoryProdDto dto) {
		Page<SaleInventoryProdDto> data = saleRecordDao.getSaleList(dto);
		return data;
	}

	@Override
	@Transactional
	public void insertSaleRecord(SaleInventoryProdDto dto) {
		saleRecordDao.insertSaleRecord(dto);
	}

	@Override
	@Transactional
	public void updateSaleRecord(SaleInventoryProdDto dto) {
		saleRecordDao.updateSaleRecord(dto);
	}

	@Override
	@Transactional
	public void deleteSaleRecord(SaleInventoryProdDto dto) {
		saleRecordDao.deleteSaleRecord(dto);
	}


}
