package com.csh.mms.service.impl;

import java.util.Date;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csh.mms.dao.RoleDao;
import com.csh.mms.dto.RoleDto;
import com.csh.mms.dto.UserRoleDto;
import com.csh.mms.service.RoleService;
import com.csh.mms.utils.DateTime;
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
		Session session = SecurityUtils.getSubject().getSession();
		UserRoleDto user = (UserRoleDto) session.getAttribute("user");
		dto.setCreatorId(user.getId());
		dto.setCreator(user.getName());
		dto.setCreateTime(new DateTime().toTimeStamp(new Date()));
		dto.setId(UUID.randomUUID().toString());
		dto.setEnableDelete("1");
		roleDao.insertRole(dto);
	}

	@Override
	public void updateRole(RoleDto dto) {
		Session session = SecurityUtils.getSubject().getSession();
		UserRoleDto user = (UserRoleDto) session.getAttribute("user");
		dto.setModifier(user.getName());
		dto.setUpdateTime(new DateTime().toTimeStamp(new Date()));
		roleDao.updateRole(dto);
	}

	@Override
	public void deleteRole(RoleDto dto) {
		Session session = SecurityUtils.getSubject().getSession();
		UserRoleDto user = (UserRoleDto) session.getAttribute("user");
		dto.setModifier(user.getName());
		dto.setUpdateTime(new DateTime().toTimeStamp(new Date()));
		dto.setEnableDelete("2");
		roleDao.deleteRole(dto);
		
	}

}
