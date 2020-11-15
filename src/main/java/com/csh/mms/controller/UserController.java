package com.csh.mms.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.domain.SysUser;
import com.csh.mms.service.UserService;

/**
 * 
 * @ClassName  UserController 
 * @Description 用户信息控制类
 * @author csh
 * @date  2020年11月4日 下午9:44:05 
 *
 */
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/getUserById")
    public SysUser getUser(SysUser user) {
		SysUser resultUser = new SysUser();
        if (StringUtils.isEmpty(user.getId())) {
        	return null;
        }else {
        	resultUser = userService.getUserById(user.getId());
        	return resultUser;
        }
    }
	
	@GetMapping("/getUserList")
    public List<SysUser> getUserList(SysUser user) {
		List<SysUser> userList = new ArrayList<SysUser>();
        if (StringUtils.isEmpty(user)) {
        	return null;
        }else {
        	userList = userService.getUserList(user);
        	return userList;
        }
    }
	
	@PostMapping("/insertUser")
    public SysUser inertUser(SysUser user) {
		SysUser resultUser = new SysUser();
        if (StringUtils.isEmpty(user)) {
        	return null;
        }else {
        	resultUser = userService.insertUser(user);
        	return resultUser;
        }
    }
	
	@PostMapping("/updatetUser")
    public SysUser updatetUser(SysUser user) {
		SysUser resultUser = new SysUser();
        if (StringUtils.isEmpty(user)) {
        	return null;
        }else {
        	resultUser = userService.updatetUser(user);
        	return resultUser;
        }
    }
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public Map<String, Object> deleteUser(String id) {
		Map<String, Object> resultMap = new HashMap<>();
		@SuppressWarnings("unused")
		SysUser user = new SysUser();
        if (StringUtils.isEmpty(id)) {
        	resultMap.put("code", 0);
        	resultMap.put("msgcode", "删除数据id是空，删除失败！");
        	return resultMap;
        }else {
        	user = userService.deleteUser(id);
        	resultMap.put("code", 200);
        	return resultMap;
        }
    }
	
}
