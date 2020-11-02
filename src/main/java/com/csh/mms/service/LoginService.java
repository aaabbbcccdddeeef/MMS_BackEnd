package com.csh.mms.service;

import org.springframework.stereotype.Service;

import com.csh.mms.domain.SysUser;

@Service
public interface LoginService {
	
	SysUser getUserByAccount(String account);

}
