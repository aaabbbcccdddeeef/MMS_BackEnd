package com.csh.mms.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.domain.SysPermission;
import com.csh.mms.service.PermissionService;

import net.sf.json.JSONObject;

@RestController
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@PostMapping("/getPermission")
	public JSONObject getPermission(@Param(value = "id") String id) {
		SysPermission permission = new SysPermission();
		JSONObject json = new JSONObject();
		if (StringUtils.isEmpty(id)) {
			json.put("code", "0");
			json.put("msg", "数据字典id是空，查询失败！");
			return json;
		} else {
			permission = permissionService.getPermission(id);
			if (permission != null) {
				json.put("code", "200");
				json.put("permission", permission);
				return json;
			}
			return json;
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
