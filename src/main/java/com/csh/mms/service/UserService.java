package com.csh.mms.service;

import com.csh.mms.domain.SysUser;
import com.csh.mms.dto.UserRolePermissionDto;
import com.github.pagehelper.Page;

public interface UserService {
	
	SysUser getUserByAccount(String account);
	
	void insertUser (UserRolePermissionDto dto);

	void updatetUser (UserRolePermissionDto dto);
	
	void deleteUser (String id);


	Page<UserRolePermissionDto> getUserList(UserRolePermissionDto dto);
}
