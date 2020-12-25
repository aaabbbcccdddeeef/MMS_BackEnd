package com.csh.mms.service;

import com.csh.mms.domain.SysPermission;
import com.csh.mms.dto.PermissionDto;
import com.github.pagehelper.Page;

public interface PermissionService {

	SysPermission insertPermission(SysPermission permission);

	SysPermission updatePermission(SysPermission permission);

	SysPermission deletePermission(String id);

	Page<PermissionDto> getPermList(PermissionDto dto);

}
