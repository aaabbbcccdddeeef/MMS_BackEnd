package com.csh.mms.service;

import com.csh.mms.domain.UserDomain;

public interface UserService {

	UserDomain getUserByAccount(String account);

}
