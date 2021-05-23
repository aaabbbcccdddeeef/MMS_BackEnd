package com.csh.mms.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csh.mms.dao.ProductionDao;
import com.csh.mms.domain.ProductionInfo;
import com.csh.mms.dto.InventoryProdDto;
import com.csh.mms.dto.UserRoleDto;
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
	@Transactional
	public void deleteProd(InventoryProdDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setEnableDelete("2");
		dto.setModifierId(user.getCreatorId());
		dto.setModifier(user.getName());
		dto.setUpdateTime(new Timestamp(new Date().getTime()));
		prodDao.deleteProd(dto);
	}

	@Override
	@Transactional
	public void updateProd(InventoryProdDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setModifierId(user.getCreatorId());
		dto.setModifier(user.getName());
		dto.setUpdateTime(new Timestamp(new Date().getTime()));
		prodDao.updateProd(dto);
	}

	@Override
	@Transactional
	public void insertProd(InventoryProdDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setId(UUID.randomUUID().toString());
		dto.setEnableDelete("1");
		dto.setCreatorId(user.getId());
		dto.setCreator(user.getName());
		dto.setCreateTime(new Timestamp(new Date().getTime()));
		prodDao.insertProd(dto);
		
	}

}
