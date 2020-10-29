package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csh.mms.dao.UserDao;
import com.csh.mms.domain.UserDomain;
import com.csh.mms.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
    public UserDomain getUserByAccount(String account) {
		System.out.println("开始进入dao层");
		UserDomain user = userDao.getUserByAccount(account);
        return user;
    }
	
}
