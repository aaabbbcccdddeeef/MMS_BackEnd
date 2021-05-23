package com.csh.mms.service;

import com.csh.mms.dto.RoleDto;
import com.github.pagehelper.Page;

public interface RoleService {

	Page<RoleDto> getRoleList(RoleDto dto);

	void insertRole(RoleDto dto);

	void updateRole(RoleDto dto);

	void deleteRole(RoleDto dto);

}
