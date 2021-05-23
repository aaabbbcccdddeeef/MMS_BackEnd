package com.csh.mms.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csh.mms.dao.SaleRecordDao;
import com.csh.mms.dto.SaleInventoryProdDto;
import com.csh.mms.dto.UserRoleDto;
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
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setId(UUID.randomUUID().toString());
		dto.setEnableDelete("1");
		dto.setCreatorId(user.getCreatorId());
		dto.setCreator(user.getCreator());
		dto.setCreateTime(new Timestamp(new Date().getTime()));
		saleRecordDao.insertSaleRecord(dto);
	}

	@Override
	@Transactional
	public void updateSaleRecord(SaleInventoryProdDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setModifierId(user.getCreatorId());
		dto.setModifier(user.getCreator());
		dto.setUpdateTime(new Timestamp(new Date().getTime()));
		saleRecordDao.updateSaleRecord(dto);
	}

	@Override
	@Transactional
	public void deleteSaleRecord(SaleInventoryProdDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setEnableDelete("2");
		dto.setModifierId(user.getCreatorId());
		dto.setModifier(user.getCreator());
		dto.setUpdateTime(new Timestamp(new Date().getTime()));
		saleRecordDao.deleteSaleRecord(dto);
	}


}
