package com.csh.mms.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.domain.SysPermission;
import com.csh.mms.dto.PermissionDto;
import com.csh.mms.service.PermissionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@PostMapping("/getPermList")
	public Map<String, Object> getPermission(@RequestBody PermissionDto dto) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		Page<PermissionDto> resultList = permissionService.getPermList(dto);
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

	public JSONObject insertPermission(SysPermission permission) {
		JSONObject json = new JSONObject();
		if (permission != null) {
			permission = permissionService.insertPermission(permission);
			if (permission != null) {
				json.put("code", "200");
				json.put("msg", "添加库存成功！");
				json.put("permission", permission);
				return json;
			}

		}
		json.put("code", "0");
		json.put("msg", "添加库存失败！");
		return json;
	}

	public JSONObject updatePermission(SysPermission permission) {
		JSONObject json = new JSONObject();
		if (permission != null) {
			permission = permissionService.updatePermission(permission);
			if (permission != null) {
				json.put("code", "200");
				json.put("msg", "修改库存成功！");
				json.put("permission", permission);
				return json;
			}

		}
		json.put("code", "0");
		json.put("msg", "修改库存失败！");
		return json;
	}

	public JSONObject deletePermission(@Param(value = "id") String id) {
		JSONObject json = new JSONObject();
		if (StringUtils.isEmpty(id)) {
			json.put("statusCode", "0");
			json.put("msg", "数据id是空，删除失败！");
			return json;
		} else {
			SysPermission resultDelet = permissionService.deletePermission(id);
			if (resultDelet != null) {
				json.put("statusCode", "200");
				json.put("msg", "产品数据删除成功！");
				return json;
			} else {
				json.put("statusCode", "1");
				json.put("msg", "数据异常，删除失败！");
				return json;
			}
		}
	}
}
