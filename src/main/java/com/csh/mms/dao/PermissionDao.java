package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.csh.mms.domain.SysPermission;
import com.csh.mms.dto.PermissionDto;
import com.github.pagehelper.Page;

@Mapper
public interface PermissionDao {

	SysPermission insertPermission(SysPermission permission);

	SysPermission updatePermission(SysPermission permission);

	SysPermission deletePermission(@Param("id") String id);

	Page<PermissionDto> getPermList(PermissionDto dto);

}
