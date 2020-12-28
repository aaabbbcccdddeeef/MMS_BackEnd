package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csh.mms.dao.InventoryInfoDao;
import com.csh.mms.dto.InventoryProdDto;
import com.csh.mms.service.InventoryInfoService;
import com.github.pagehelper.Page;

@Service
public class InventoryInfoServiceImpl implements InventoryInfoService{
	
	@Autowired
	private InventoryInfoDao inventoryInfoDao;


	@Override
	@Transactional
	public void updateInventory(InventoryProdDto dto) {
		inventoryInfoDao.updateInventory(dto);
	}

	@Override
	@Transactional
	public void deleteInventory(InventoryProdDto dto) {
		inventoryInfoDao.deleteInventory(dto);
	}

	@Override
	public Page<InventoryProdDto> getInventoryList(InventoryProdDto inventoryProdDto) {
		Page<InventoryProdDto> dataPage = inventoryInfoDao.getInventoryList(inventoryProdDto);
		return dataPage;
	}

	@Override
	@Transactional
	public void insertInventory(InventoryProdDto dto) {
		inventoryInfoDao.insertInventory(dto);
		
	}

}
