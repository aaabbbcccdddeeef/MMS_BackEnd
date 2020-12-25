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
	public ProductionInfo deleteProd(String id) {
		ProductionInfo prod = prodDao.daleteInfo(id);
		return prod;
	}

	@Override
	public ProductionInfo insertProd(ProductionInfo pordInfo) {
		ProductionInfo prod = prodDao.insertProd(pordInfo);
		return prod;
	}

	@Override
	public ProductionInfo updateProd(ProductionInfo pordInfo) {
		ProductionInfo pordInfoResult = prodDao.updateProd(pordInfo);
		return pordInfoResult;
	}

	@Override
	public Page<InventoryProdDto> getProdList(InventoryProdDto prod) {
		Page<InventoryProdDto> list = prodDao.getProdList(prod);
		return list;
	}

	
}
