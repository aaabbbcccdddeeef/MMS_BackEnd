package com.csh.mms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csh.mms.dao.UserDao;
import com.csh.mms.domain.SysUser;
import com.csh.mms.service.UserService;
/**
 * 
 * @ClassName  UserServiceImpl 
 * @Description 用户管理实现类
 * @author csh
 * @date  2020年11月1日 上午12:47:27 
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
    public SysUser getUserById(String id) {
		SysUser user = userDao.getUserById(id);
        return user;
    }

	@Override
	public SysUser insertUser(SysUser userDomain) {
		SysUser user = userDao.insertUser(userDomain);
		return user;
	}

	@Override
	public SysUser updatetUser(SysUser userDomain) {
		SysUser user = userDao.updatetUser(userDomain);
		return user;
	}

	@Override
	public SysUser deleteUser(String id) {
		SysUser user = userDao.getUserById(id);
		if(user != null) {
			user = userDao.deleteUser(id);
			return user;
		}else {

			return null;
		}
		
	}

	@Override
	public List<SysUser> getUserList(SysUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysUser getUserByAccount(String account) {
		SysUser user = userDao.getUserByAccount(account);
		return user;
	}
	
}
