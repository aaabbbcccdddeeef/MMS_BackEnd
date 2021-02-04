package com.csh.mms.service;

import com.csh.mms.domain.SysUser;
import com.csh.mms.dto.UserRoleDto;

public interface LoginService {

//	SysUser getUserByAccount(String account);

	UserRoleDto getUserByAccount(String account);
}