package com.csh.mms.service;

import com.csh.mms.domain.SysPermission;

public interface PermissionService {

	SysPermission getPermission(String id);

	SysPermission insertPermission(SysPermission permission);

	SysPermission updatePermission(SysPermission permission);

	SysPermission deletePermission(String id);

}
