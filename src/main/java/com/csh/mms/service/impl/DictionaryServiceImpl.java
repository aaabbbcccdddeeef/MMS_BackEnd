package com.csh.mms.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.csh.mms.dao.DictionaryDao;
import com.csh.mms.dto.DictionaryDetailDto;
import com.csh.mms.dto.DictionaryDto;
import com.csh.mms.dto.UserRoleDto;
import com.csh.mms.service.DictionaryService;
import com.github.pagehelper.Page;

@Service
public class DictionaryServiceImpl implements DictionaryService{
	
	@Autowired
	private DictionaryDao dictionaryDao;


	@Override
	public Page<DictionaryDto> getDictList(@RequestBody DictionaryDto dto) {
		return dictionaryDao.getDictList(dto);
	}


	@Override
	@Transactional
	public void insertDictionary(DictionaryDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		if(dto.getParentId() != null && dto.getParentId() != "") {
			dto.setType("2");
		}else {
			dto.setType("1");
		}
		dto.setId(UUID.randomUUID().toString());
		dto.setEnableDelete("1");
		dto.setCreator(user.getName());
		dto.setCreateTime(new Timestamp(new Date().getTime()));
		dictionaryDao.insertDictionary(dto);
		
	}


	@Override
	@Transactional
	public void updateDictionary(DictionaryDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setModifier(user.getName());
		dto.setUpdateTime(new Timestamp(new Date().getTime()));
		dictionaryDao.updateDictionary(dto);
		
	}


	@Override
	@Transactional
	public void deleteDictionary(DictionaryDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setEnableDelete("2");
		dto.setModifier(user.getName());
		dto.setUpdateTime(new Timestamp(new Date().getTime()));
		dictionaryDao.deleteDictionary(dto);
		
	}


	@Override
	public Page<DictionaryDto> getDictDetailList(DictionaryDto dto) {
		return dictionaryDao.getDictDetailList(dto);
	}


	@Override
	@Transactional
	public void insertDictionaryDetail(DictionaryDetailDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setId(UUID.randomUUID().toString());
		dto.setEnableDelete("1");
		dto.setCreator(user.getName());
		dto.setCreateTime(new Timestamp(new Date().getTime()));
		dictionaryDao.insertDictionaryDetail(dto);
	}


	@Override
	@Transactional
	public void updateDictionaryDetail(DictionaryDetailDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setModifier(user.getName());
		dto.setUpdateTime(new Timestamp(new Date().getTime()));
		dictionaryDao.updateDictionaryDetail(dto);
	}


	@Override
	@Transactional
	public void deleteDictionaryDetail(DictionaryDetailDto dto) {
		UserRoleDto user = (UserRoleDto) SecurityUtils.getSubject().getSession().getAttribute("user");
		dto.setEnableDelete("2");
		dto.setModifier(user.getName());
		dto.setUpdateTime(new Timestamp(new Date().getTime()));
		dictionaryDao.deleteDictionary(dto);
	}


	
}
