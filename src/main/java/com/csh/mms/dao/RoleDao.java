package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;

import com.csh.mms.dto.RoleDto;
import com.github.pagehelper.Page;

@Mapper
public interface RoleDao {

	Page<RoleDto> getRoleList(RoleDto dto);
	
	void insertRole(RoleDto dto);

	void updateRole(RoleDto dto);

	void deleteRole(String id);

}
