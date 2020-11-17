package com.csh.mms.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.domain.SysDictionary;
import com.csh.mms.service.DictionaryService;

import net.sf.json.JSONObject;

@RestController
public class DictionaryController {
	
	@Autowired
	private DictionaryService dicService;
	
	@PostMapping("/getDictionary")
	public JSONObject getDictionary(@Param(value = "id") String id) {
		SysDictionary sysDictionary = new SysDictionary();
		JSONObject json = new JSONObject();
		if(StringUtils.isEmpty(id)) {
			json.put("code", "0");
			json.put("msg", "数据字典id是空，查询失败！");
			return json;
		}else {
			sysDictionary = dicService.getDictionary(id);
			if(sysDictionary != null) {
				json.put("code", "200");
				json.put("msg", "查询成功！");
				json.put("sysDictionary", sysDictionary);
				return json;
			}
			return json;
		}
	}
	
	public JSONObject insertDictionary(SysDictionary sysDictionary) {
		JSONObject json = new JSONObject();
		if(sysDictionary != null) {
			SysDictionary resultDic = dicService.insertDictionary(sysDictionary);
			if(resultDic != null) {
				json.put("code", "200");
				json.put("msg", "添加库存成功！");
				json.put("resultDic", resultDic);
				return json;
			}
			
		}
		json.put("code", "0");
		json.put("msg", "添加库存失败！");
		return json;
	}
	
	public JSONObject updateDictionary(SysDictionary sysDictionary) {
		JSONObject json = new JSONObject();
		if(sysDictionary != null) {
			SysDictionary resultDic = dicService.updateDictionary(sysDictionary);
			if(sysDictionary != null) {
				json.put("code", "200");
				json.put("msg", "修改库存成功！");
				json.put("resultDic", resultDic);
				return json;
			}
			
		}
		json.put("code", "0");
		json.put("msg", "修改库存失败！");
		return json;
	}
	
	public JSONObject deleteDictionary(@Param(value = "id") String id) {
		JSONObject json = new JSONObject();
		if (StringUtils.isEmpty(id)) {
			json.put("statusCode", "0");
			json.put("msg", "数据id是空，删除失败！");
			return json;
		} else {
			SysDictionary resultDelet = dicService.deleteDictionary(id);
			if(resultDelet !=null) {
				json.put("statusCode", "200");
				json.put("msg", "产品数据删除成功！");
				return json;
			}else {
				json.put("statusCode", "1");
				json.put("msg", "数据异常，删除失败！");
				return json;
			}
			
		}
 
	}
}
