package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csh.mms.dao.PermissionDao;
import com.csh.mms.dto.PermissionDto;
import com.csh.mms.service.PermissionService;
import com.github.pagehelper.Page;

@Service
public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private PermissionDao permissionDao;

	@Override
	@Transactional
	public void insertPermission(PermissionDto dto) {
		permissionDao.insertPermission(dto);
	}

	@Override
	@Transactional
	public void updatePermission(PermissionDto dto) {
		permissionDao.updatePermission(dto);
	}

	@Override
	@Transactional
	public void deletePermission(PermissionDto dto) {
		permissionDao.deletePermission(dto);
	}

	@Override
	public Page<PermissionDto> getPermissionList(PermissionDto dto) {
		return permissionDao.getPermissionList(dto);
	}
	
}
