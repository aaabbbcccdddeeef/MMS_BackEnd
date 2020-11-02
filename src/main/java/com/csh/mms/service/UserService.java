package com.csh.mms.service;

import java.util.List;

import com.csh.mms.domain.SysUser;

public interface UserService {
	
	SysUser getUserByAccount(String account);

	SysUser getUserById(String id);
	
	SysUser insertUser (SysUser userDomain);

	SysUser updatetUser (SysUser userDomain);
	
	String deleteUser (String id);

	List<SysUser> getUserList(SysUser user);
}
