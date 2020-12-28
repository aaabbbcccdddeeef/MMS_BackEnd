package com.csh.mms.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.dto.InventoryProdDto;
import com.csh.mms.service.InventoryInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @ClassName  InventoryInfoController 
 * @Description 库存信息控制类
 * @author csh
 * @date  2020年11月4日 下午9:55:12 
 *
 */
@RestController
@RequestMapping("/inventory")
public class InventoryInfoController {
	
	@Autowired
	private InventoryInfoService inventoryService;
	
	/**
	 * 
	 * @Title  insertInventory 
	 * @Description  添加库存信息
	 * @param id
	 * @return JSONObject
	 */
	@PostMapping("/insertInventory")
	public Map<String, Object> insertInventory(@RequestBody InventoryProdDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			dto.setId(UUID.randomUUID().toString());
			dto.setEnableDelete("1");
			inventoryService.insertInventory(dto);
			map.put("code", 200);
			InventoryProdDto dto1 = new InventoryProdDto();
			PageHelper.startPage(dto1.getPageNum(), dto1.getPageSize());
			return getInventoryList(dto1);
		}else {
			map.put("code", 0);
	    	map.put("msgcode", "用户数据是空，添加失败！");
	    	return map;
		}
	}
	
	/**
	 * 
	 * @Title  updateInventory 
	 * @Description  更新库存信息
	 * @param inventoryInfo
	 * @return JSONObject
	 */
	@PostMapping("/updateInventory")
	public Map<String, Object> updateInventory(@RequestBody InventoryProdDto dto) {
		Map<String, Object> map = new HashMap<>();
		if(dto != null) {
			inventoryService.updateInventory(dto);
			map.put("code", 200);
			InventoryProdDto dto1 = new InventoryProdDto();
			dto1.setPageNum(dto.getPageNum());
			dto1.setPageSize(dto.getPageSize());
			return getInventoryList(dto1);
		}else {
			map.put("code", 0);
	    	map.put("msgcode", "用户数据是空，修改失败！");
	    	return map;
		}
	}
	
	/**
	 * 
	 * @Title  deleteInventory 
	 * @Description  删除库存信息-逻辑删除
	 * @param inventoryInfo
	 * @return JSONObject
	 */
	@PostMapping("/deleteInventory")
	public Map<String, Object> deleteInventory(@RequestBody InventoryProdDto dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isEmpty(dto)) {
			map.put("code", "0");
			map.put("msg", "删除数据失败！");
			return map;
		}else {
			inventoryService.deleteInventory(dto);
			InventoryProdDto dto1 = new InventoryProdDto();
			dto1.setPageNum(dto.getPageNum());
			dto1.setPageSize(dto.getPageSize());
			return getInventoryList(dto1);
		}
	}
	
	@PostMapping("/getInventoryList")
	public Map<String, Object> getInventoryList(@RequestBody InventoryProdDto inventoryProdDto){
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(inventoryProdDto.getPageNum(), inventoryProdDto.getPageSize());
		Page<InventoryProdDto> resultList = inventoryService.getInventoryList(inventoryProdDto);
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
