package com.csh.mms.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csh.mms.dao.InventoryInfoDao;
import com.csh.mms.dto.InventoryProdDto;
import com.csh.mms.dto.UserRoleDto;
import com.csh.mms.service.InventoryInfoService;
import com.github.pagehelper.Page;

@Service
public class InventoryInfoServiceImpl implements InventoryInfoService{
	
	@Autowired
	private InventoryInfoDao inventoryInfoDao;


	@Override
	@Transactional
	public void updateInventory(InventoryProdDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setModifierId(user.getCreatorId());
		dto.setModifier(user.getName());
		dto.setUpdateTime(new Timestamp(new Date().getTime()));
		inventoryInfoDao.updateInventory(dto);
	}

	@Override
	@Transactional
	public void deleteInventory(InventoryProdDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setEnableDelete("2");
		dto.setModifierId(user.getCreatorId());
		dto.setModifier(user.getName());
		dto.setUpdateTime(new Timestamp(new Date().getTime()));
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
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setId(UUID.randomUUID().toString());
		dto.setEnableDelete("1");
		dto.setCreatorId(user.getAccount());
		dto.setCreator(user.getName());
		dto.setCreateTime(new Timestamp(new Date().getTime()));
		inventoryInfoDao.insertInventory(dto);
		
	}

}
