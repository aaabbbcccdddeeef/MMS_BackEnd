package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csh.mms.dao.InventoryInfoDao;
import com.csh.mms.domain.InventoryInfo;
import com.csh.mms.dto.InventoryProdDto;
import com.csh.mms.service.InventoryInfoService;
import com.github.pagehelper.Page;

@Service
public class InventoryInfoServiceImpl implements InventoryInfoService{
	
	@Autowired
	private InventoryInfoDao inventoryInfoDao;

	@Override
	@Transactional
	public InventoryInfo getInventoryInfo(String id) {
		InventoryInfo inventoryInfo = inventoryInfoDao.getInventoryInfo(id);
		return inventoryInfo;
	}

	@Override
	@Transactional
	public InventoryInfo insertInventory(InventoryInfo inventoryInfo) {
		inventoryInfo = inventoryInfoDao.insertInventory(inventoryInfo);
		return inventoryInfo;
	}

	@Override
	@Transactional
	public InventoryInfo updateInventory(InventoryInfo inventoryInfo) {
		inventoryInfo = inventoryInfoDao.updateInventory(inventoryInfo);
		return inventoryInfo;
	}

	@Override
	@Transactional
	public InventoryInfo deleteInventory(String id) {
		InventoryInfo inventoryInfo = inventoryInfoDao.deleteInventory(id);
		return inventoryInfo;
	}

	@Override
	public Page<InventoryInfo> getInventoryPage(InventoryProdDto inventoryProdDto) {
		Page<InventoryInfo> dataPage = inventoryInfoDao.getInventoryPage(inventoryProdDto);
		return dataPage;
	}
	
	
}
