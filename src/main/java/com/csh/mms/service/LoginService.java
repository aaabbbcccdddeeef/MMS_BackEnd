package com.csh.mms.service;

import org.springframework.stereotype.Service;

import com.csh.mms.domain.UserDomain;

@Service
public interface LoginService {
	
	UserDomain getUserByAccount(String account);

}
