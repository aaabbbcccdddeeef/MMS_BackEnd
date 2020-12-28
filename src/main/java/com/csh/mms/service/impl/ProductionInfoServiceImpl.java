package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csh.mms.dao.ProductionDao;
import com.csh.mms.domain.ProductionInfo;
import com.csh.mms.dto.InventoryProdDto;
import com.csh.mms.service.ProductionInfoService;
import com.github.pagehelper.Page;

@Service
public class ProductionInfoServiceImpl implements ProductionInfoService{

	@Autowired
	private ProductionDao prodDao;
	
	@Override
	@Transactional
	public ProductionInfo getProdInfo(String id) {
		ProductionInfo prod = prodDao.getProdInfo(id);
		return prod;
	}

	@Override
	public Page<InventoryProdDto> getProdList(InventoryProdDto prod) {
		Page<InventoryProdDto> list = prodDao.getProdList(prod);
		return list;
	}

	@Override
	public void deleteProd(String id) {
		prodDao.deleteProd(id);
	}

	@Override
	@Transactional
	public void updateProd(InventoryProdDto dto) {
		prodDao.updateProd(dto);
	}

	@Override
	@Transactional
	public void insertProd(InventoryProdDto dto) {
		prodDao.insertProd(dto);
		
	}

}
