package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.csh.mms.domain.SysUser;
import com.csh.mms.dto.UserRoleDto;
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

	void insertUser(UserRoleDto dto);

	void updateUser(UserRoleDto dto);

	void deleteUser(@Param("id") String id);

//	SysUser getUserByAccount(@Param(value = "account") String account);

	UserRoleDto getUserDtoByAccount(@Param(value = "account") String account);
	
	Page<UserRoleDto> getUserList(UserRoleDto dto);

}
