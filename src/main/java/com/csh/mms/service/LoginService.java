package com.csh.mms.service;

import com.csh.mms.domain.SysUser;

public interface LoginService {

	SysUser getUserByAccount(String account);

}