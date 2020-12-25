package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csh.mms.dao.PermissionDao;
import com.csh.mms.domain.SysPermission;
import com.csh.mms.dto.PermissionDto;
import com.csh.mms.service.PermissionService;
import com.github.pagehelper.Page;

@Service
public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private PermissionDao permissionDao;

	@Override
	@Transactional
	public SysPermission insertPermission(SysPermission permission) {
		SysPermission resultPermission = permissionDao.insertPermission(permission);
		return resultPermission;
	}

	@Override
	@Transactional
	public SysPermission updatePermission(SysPermission permission) {
		permission = permissionDao.updatePermission(permission);
		return permission;
	}

	@Override
	@Transactional
	public SysPermission deletePermission(String id) {
		SysPermission permission = permissionDao.deletePermission(id);
		return permission;
	}

	@Override
	public Page<PermissionDto> getPermList(PermissionDto dto) {
		return permissionDao.getPermList(dto);
	}
	
}
