package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.csh.mms.domain.UserDomain;

@Mapper
public interface UserDao {

	UserDomain getUserByAccount(@Param("account") String account);

}
