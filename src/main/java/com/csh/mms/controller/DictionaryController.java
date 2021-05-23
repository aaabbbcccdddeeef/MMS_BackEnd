package com.csh.mms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.dto.DictionaryDetailDto;
import com.csh.mms.dto.DictionaryDto;
import com.csh.mms.service.DictionaryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {
	
	@Autowired
	private DictionaryService dicService;
	
	@PostMapping("/getDictList")
	public Map<String, Object> getDictList(@RequestBody DictionaryDto dto) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		Page<DictionaryDto> resultList = dicService.getDictList(dto);
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
	
	@PostMapping("/insertDictionary")
	public Map<String, Object> insertDictionary(@RequestBody DictionaryDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			dicService.insertDictionary(dto);
			map.put("code", 200);
			DictionaryDto dto1 = new DictionaryDto();
			return getDictList(dto1);
			
		}else {
			map.put("code", 0);
        	map.put("msgcode", "产品数据是空，添加失败！");
        	return map;
		}
	}
	
	@PostMapping("/updateDictionary")
	public Map<String, Object> updateDictionary(@RequestBody DictionaryDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			dicService.updateDictionary(dto);
			map.put("code", 200);
			DictionaryDto dto1 = new DictionaryDto();
			return getDictList(dto1);
		}else {
			map.put("code", 0);
        	map.put("msgcode", "产品数据是空，修改失败！");
        	return map;
		}
	}
	
	@PostMapping("/deleteDictionary")
	public Map<String, Object> deleteDictionary(@RequestBody DictionaryDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			dicService.deleteDictionary(dto);
			map.put("code", 200);
			DictionaryDto dto1 = new DictionaryDto();
			dto1.setType(dto.getType());
			dto1.setParentId(dto.getParentId());
			return getDictList(dto1);
		}else {
			map.put("code", 0);
        	map.put("msgcode", "产品数据是空，修改失败！");
        	return map;
		}
	}
	
	@PostMapping("/getDictDetailList")
	public Map<String, Object> getDictDetailList(@RequestBody DictionaryDto dto) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		Page<DictionaryDto> resultList = dicService.getDictDetailList(dto);
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
	
	@PostMapping("/insertDictionaryDetail")
	public Map<String, Object> insertDictionaryDetail(@RequestBody DictionaryDetailDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			dicService.insertDictionaryDetail(dto);
			map.put("code", 200);
			DictionaryDto dto1 = new DictionaryDto();
			return getDictList(dto1);
			
		}else {
			map.put("code", 0);
        	map.put("msgcode", "产品数据是空，添加失败！");
        	return map;
		}
	}
	
	@PostMapping("/updateDictionaryDetail")
	public Map<String, Object> updateDictionaryDetail(@RequestBody DictionaryDetailDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			dicService.updateDictionaryDetail(dto);
			map.put("code", 200);
			DictionaryDto dto1 = new DictionaryDto();
			return getDictList(dto1);
		}else {
			map.put("code", 0);
        	map.put("msgcode", "产品数据是空，修改失败！");
        	return map;
		}
	}
	
	@PostMapping("/deleteDictionaryDetail")
	public Map<String, Object> deleteDictionaryDetail(@RequestBody DictionaryDetailDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			dicService.deleteDictionaryDetail(dto);
			map.put("code", 200);
			DictionaryDto dto1 = new DictionaryDto();
			return getDictList(dto1);
		}else {
			map.put("code", 0);
        	map.put("msgcode", "产品数据是空，修改失败！");
        	return map;
		}
	}
}
