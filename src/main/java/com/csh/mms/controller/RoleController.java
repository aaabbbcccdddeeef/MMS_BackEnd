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

import com.csh.mms.dto.RoleDto;
import com.csh.mms.dto.UserRolePermissionDto;
import com.csh.mms.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/getRoleList")
	public Map<String, Object> getRoleList(@RequestBody RoleDto dto){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		Page<RoleDto> resultList = roleService.getRoleList(dto);
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
	
	@PostMapping("/insertRole")
    public Map<String, Object> insertRole(@RequestBody RoleDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			dto.setId(UUID.randomUUID().toString());
			dto.setEnableDelete("1");
			roleService.insertRole(dto);
			map.put("code", 200);
			RoleDto dto1 = new RoleDto();
			PageHelper.startPage(dto1.getPageNum(), dto1.getPageSize());
    		Page<RoleDto> resultList = roleService.getRoleList(dto1);
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
        	map.put("msgcode", "角色数据是空，添加失败！");
        	return map;
		}
    }
	
	@PostMapping("/updateRole")
    public Map<String, Object> updateRole(@RequestBody RoleDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			roleService.updateRole(dto);
			map.put("code", 200);
			RoleDto dto1 = new RoleDto();
			PageHelper.startPage(dto1.getPageNum(), dto1.getPageSize());
    		Page<RoleDto> resultList = roleService.getRoleList(dto1);
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
        	map.put("msgcode", "角色数据是空，修改失败！");
        	return map;
		}
    }
	
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    public Map<String, Object> deleteRole(@RequestBody RoleDto dto) {
		Map<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(dto.getId())) {
        	map.put("code", 0);
        	map.put("msgcode", "删除数据id是空，删除失败！");
        	return map;
        }else {
        	roleService.deleteRole(dto.getId());
        	map.put("code", 200);
        	dto.setId("");
        	PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
    		Page<RoleDto> resultList = roleService.getRoleList(dto);
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

}
