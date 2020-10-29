package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csh.mms.dao.UserDao;
import com.csh.mms.domain.UserDomain;
import com.csh.mms.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
    public UserDomain getUserByAccount(String account) {
		UserDomain user = new UserDomain();
		user = userDao.getUserByAccount(account);
        return user;
    }
	
}
