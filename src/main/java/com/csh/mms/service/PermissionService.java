package com.csh.mms.service;

import com.csh.mms.dto.PermissionDto;
import com.github.pagehelper.Page;

public interface PermissionService {

	void insertPermission(PermissionDto dto);

	void updatePermission(PermissionDto dto);

	void deletePermission(PermissionDto dto);

	Page<PermissionDto> getPermissionList(PermissionDto dto);

}
