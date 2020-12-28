package com.csh.mms.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.dto.PermissionDto;
import com.csh.mms.service.PermissionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@PostMapping("/getPermissionList")
	public Map<String, Object> getPermissionList(@RequestBody PermissionDto dto) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		Page<PermissionDto> resultList = permissionService.getPermissionList(dto);
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
	@PostMapping("/insertPermission")
	public Map<String, Object> insertPermission(@RequestBody PermissionDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			dto.setId(UUID.randomUUID().toString());
			permissionService.insertPermission(dto);
			PermissionDto dto1 = new PermissionDto();
			return getPermissionList(dto1);
		}else {
			map.put("code", 0);
			map.put("msg", "添加权限失败！");
			return map;
		}
	}

	@PostMapping("/updatePermission")
	public Map<String, Object> updatePermission(@RequestBody PermissionDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			permissionService.updatePermission(dto);
			PermissionDto dto1 = new PermissionDto();
			return getPermissionList(dto1);
		}else {
			map.put("code", 0);
			map.put("msg", "修改权限失败！");
			return map;
		}
	}

	@PostMapping("/deletePermission")
	public Map<String, Object> deletePermission(@RequestBody PermissionDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto.getId() != null && !"".equals(dto.getId())) {
			permissionService.deletePermission(dto);
			PermissionDto dto1 = new PermissionDto();
			return getPermissionList(dto1);
		}else {
			map.put("code", 0);
			map.put("msg", "删除权限失败！");
			return map;
		}
	}
}
