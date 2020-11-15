package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.csh.mms.domain.SysPermission;

@Mapper
public interface PermissionDao {

	SysPermission getPermission(@Param("id") String id);

	SysPermission insertPermission(SysPermission permission);

	SysPermission updatePermission(SysPermission permission);

	SysPermission deletePermission(@Param("id") String id);

}
