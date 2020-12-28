package com.csh.mms.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.dto.UserRolePermissionDto;
import com.csh.mms.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @ClassName  UserController 
 * @Description 用户信息控制类
 * @author csh
 * @date  2020年11月4日 下午9:44:05 
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/insertUser")
    public Map<String, Object> inertUser(@RequestBody UserRolePermissionDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			dto.setId(UUID.randomUUID().toString());
			dto.setEnableDelete("1");
			userService.insertUser(dto);
			map.put("code", 200);
			UserRolePermissionDto dto1 = new UserRolePermissionDto();
			PageHelper.startPage(dto1.getPageNum(), dto1.getPageSize());
    		Page<UserRolePermissionDto> resultList = userService.getUserList(dto1);
    		if(resultList != null) {
    			map.put("code", 200);
    			map.put("resultList", resultList);
    			map.put("totalpage", resultList.getPages());
    			map.put("totalCount", resultList.getTotal());
    			return map;
    		}else {
    			map.put("code", 1);
    			map.put("msg", "查询失败！");
    			return map;
    		}
		}else {
			map.put("code", 0);
        	map.put("msgcode", "用户数据是空，添加失败！");
        	return map;
		}
    }
	
	@PostMapping("/updateUser")
    public Map<String, Object> updateUser(@RequestBody UserRolePermissionDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			userService.updateUser(dto);
			map.put("code", 200);
			UserRolePermissionDto dto1 = new UserRolePermissionDto();
			PageHelper.startPage(dto1.getPageNum(), dto1.getPageSize());
    		Page<UserRolePermissionDto> resultList = userService.getUserList(dto1);
    		if(resultList != null) {
    			map.put("code", 200);
    			map.put("resultList", resultList);
    			map.put("totalpage", resultList.getPages());
    			map.put("totalCount", resultList.getTotal());
    			return map;
    		}else {
    			map.put("code", 1);
    			map.put("msg", "查询失败！");
    			return map;
    		}
		}else {
			map.put("code", 0);
        	map.put("msgcode", "用户数据是空，添加失败！");
        	return map;
		}
    }
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public Map<String, Object> deleteUser(@RequestBody UserRolePermissionDto dto) {
		Map<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(dto.getId())) {
        	map.put("code", 0);
        	map.put("msgcode", "删除数据id是空，删除失败！");
        	return map;
        }else {
        	userService.deleteUser(dto.getId());
        	map.put("code", 200);
        	dto.setId("");
        	PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
    		Page<UserRolePermissionDto> resultList = userService.getUserList(dto);
    		if(resultList != null) {
    			map.put("code", 200);
    			map.put("resultList", resultList);
    			map.put("totalpage", resultList.getPages());
    			map.put("totalCount", resultList.getTotal());
    			return map;
    		}else {
    			map.put("code", 0);
    			map.put("msg", "查询失败！");
    			return map;
    		}
        }
    }
	
	@PostMapping("/getUserList")
	public Map<String, Object> getUserList(@RequestBody UserRolePermissionDto dto){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		Page<UserRolePermissionDto> resultList = userService.getUserList(dto);
		if(resultList != null) {
			map.put("code", 200);
			map.put("resultList", resultList);
			map.put("totalpage", resultList.getPages());
			map.put("totalCount", resultList.getTotal());
			return map;
		}else {
			map.put("code", 0);
			map.put("msg", "查询失败！");
			return map;
		}
	}
	
}
