package com.csh.mms.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csh.mms.dao.UserDao;
import com.csh.mms.dto.UserRoleDto;
import com.csh.mms.service.UserService;
import com.csh.mms.utils.DateTime;
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
	public void insertUser(UserRoleDto dto) {
		Session session = SecurityUtils.getSubject().getSession();
		UserRoleDto user = (UserRoleDto) session.getAttribute("user");
		dto.setCreatorId(user.getId());
		dto.setCreator(user.getName());
//		dto.setCreateTime(Timestamp.valueOf(new DateTime().toDateTimeString()));
		dto.setCreateTime(new DateTime().toTimeStamp(new Date()));
		userDao.insertUser(dto);
	}

	@Override
	public void updateUser(UserRoleDto dto) {
		userDao.updateUser(dto);
	}

	/*
	 * @Override public SysUser getUserByAccount(String account) { SysUser user =
	 * userDao.getUserByAccount(account); return user; }
	 */

	@Override
	public Page<UserRoleDto> getUserList(UserRoleDto dto) {
		return userDao.getUserList(dto);
	}

	@Override
	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}
	
}
