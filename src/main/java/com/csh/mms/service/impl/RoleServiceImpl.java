package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csh.mms.dao.RoleDao;
import com.csh.mms.dto.RoleDto;
import com.csh.mms.service.RoleService;
import com.github.pagehelper.Page;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Page<RoleDto> getRoleList(RoleDto dto) {
		return roleDao.getRoleList(dto);
	}

	@Override
	public void insertRole(RoleDto dto) {
		roleDao.insertRole(dto);
	}

	@Override
	public void updateRole(RoleDto dto) {
		roleDao.updateRole(dto);
		
	}

}
