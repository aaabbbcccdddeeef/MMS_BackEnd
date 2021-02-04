package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csh.mms.dao.UserDao;
import com.csh.mms.domain.SysUser;
import com.csh.mms.dto.UserRoleDto;
import com.csh.mms.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
    public UserRoleDto getUserByAccount(String account) {
		UserRoleDto dto = new UserRoleDto();
		dto = userDao.getUserDtoByAccount(account);
        return dto;
    }
	
//	@Override
//	public SysUser getUserByAccount(String account) {
//		SysUser user = new SysUser();
//		user = userDao.getUserByAccount(account);
//		return user;
//	}
}
