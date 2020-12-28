package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csh.mms.dao.UserDao;
import com.csh.mms.domain.SysUser;
import com.csh.mms.dto.UserRolePermissionDto;
import com.csh.mms.service.UserService;
import com.github.pagehelper.Page;
/**
 * 
 * @ClassName  UserServiceImpl 
 * @Description 用户管理实现类
 * @author csh
 * @date  2020年11月1日 上午12:47:27 
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void insertUser(UserRolePermissionDto dto) {
		userDao.insertUser(dto);
	}

	@Override
	public void updateUser(UserRolePermissionDto dto) {
		userDao.updateUser(dto);
	}

	@Override
	public SysUser getUserByAccount(String account) {
		SysUser user = userDao.getUserByAccount(account);
		return user;
	}

	@Override
	public Page<UserRolePermissionDto> getUserList(UserRolePermissionDto dto) {
		return userDao.getUserList(dto);
	}

	@Override
	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}
	
}
