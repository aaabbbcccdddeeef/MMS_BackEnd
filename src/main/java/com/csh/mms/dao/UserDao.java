package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.csh.mms.domain.SysUser;
import com.csh.mms.dto.UserRolePermissionDto;
import com.github.pagehelper.Page;
/**
 * 
 * @ClassName  UserDao 
 * @Description 用户管理-数据交互dao
 * @author csh
 * @date  2020年11月1日 上午12:49:32 
 *
 */
@Mapper
public interface UserDao {

	void insertUser(UserRolePermissionDto dto);

	void updateUser(UserRolePermissionDto dto);

	void deleteUser(@Param("id") String id);

	SysUser getUserByAccount(@Param(value = "account") String account);

	Page<UserRolePermissionDto> getUserList(UserRolePermissionDto dto);

}
