package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;

import com.csh.mms.dto.PermissionDto;
import com.github.pagehelper.Page;

@Mapper
public interface PermissionDao {

	void insertPermission(PermissionDto dto);

	void updatePermission(PermissionDto dto);

	void deletePermission(PermissionDto dto);

	Page<PermissionDto> getPermissionList(PermissionDto dto);

}
