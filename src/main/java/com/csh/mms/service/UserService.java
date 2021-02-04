package com.csh.mms.service;

import com.csh.mms.domain.SysUser;
import com.csh.mms.dto.UserRoleDto;
import com.github.pagehelper.Page;

public interface UserService {
	
//	SysUser getUserByAccount(String account);
	
	void insertUser (UserRoleDto dto);

	void updateUser (UserRoleDto dto);
	
	void deleteUser (String id);

	Page<UserRoleDto> getUserList(UserRoleDto dto);
}
