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

import com.csh.mms.domain.InventoryInfo;
import com.csh.mms.dto.InventoryProdDto;
import com.csh.mms.service.InventoryInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

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
	 * @Title  getInventoryInfo 
	 * @Description  查询库存信息
	 * @param id
	 * @return JSONObject
	 */
	@PostMapping("/getInventory")
	public JSONObject getInventoryInfo(@Param(value = "id") String id) {
		JSONObject inventoryJson = new JSONObject();
		InventoryInfo inventoryInfo = new InventoryInfo();
		if(StringUtils.isEmpty(id)) {
			inventoryJson.put("code", "0");
			inventoryJson.put("msg", "选择数据id是空，查看失败！");
			return inventoryJson;
		}else {
			inventoryInfo = inventoryService.getInventoryInfo(id);
			if(inventoryInfo != null) {
				inventoryJson.put("code", "200");
				inventoryJson.put("msg", "查询库存成功！");
				inventoryJson.put("inventoryInfo", inventoryInfo);
				return inventoryJson;
			}else {
				inventoryJson.put("code", "1");
				inventoryJson.put("msg", "查询库存失败！");
				return inventoryJson;
			}
		}
	}
	
	/**
	 * 
	 * @Title  insertInventory 
	 * @Description  添加库存信息
	 * @param id
	 * @return JSONObject
	 */
	@PostMapping("/insertInventory")
	public JSONObject insertInventory(@Param(value = "inventoryInfo") InventoryInfo inventoryInfo) {
		JSONObject inventoryJson = new JSONObject();
		InventoryInfo inventoryInfo1 = new InventoryInfo();
		if(StringUtils.isEmpty(inventoryInfo)) {
			inventoryJson.put("code", "0");
			inventoryJson.put("msg", "添加库存失败！");
			return inventoryJson;
		}else {
			inventoryInfo1 = inventoryService.insertInventory(inventoryInfo);
			if(inventoryInfo != null) {
				inventoryJson.put("code", "200");
				inventoryJson.put("msg", "添加库存成功！");
				inventoryJson.put("inventoryInfo", inventoryInfo1);
				return inventoryJson;
			}else {
				inventoryJson.put("code", "1");
				inventoryJson.put("msg", "添加库存失败！");
				return inventoryJson;
			}
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
	public JSONObject updateInventory(@Param(value = "inventoryInfo") InventoryInfo inventoryInfo) {
		JSONObject inventoryJson = new JSONObject();
		if(StringUtils.isEmpty(inventoryInfo)) {
			inventoryJson.put("code", "0");
			inventoryJson.put("msg", "更新数据失败！");
			return inventoryJson;
		}else {
			inventoryInfo = inventoryService.updateInventory(inventoryInfo);
			if(inventoryInfo != null) {
				inventoryJson.put("code", "200");
				inventoryJson.put("msg", "更新库存成功！");
				inventoryJson.put("inventoryInfo", inventoryInfo);
				return inventoryJson;
			}else {
				inventoryJson.put("code", "1");
				inventoryJson.put("msg", "更新库存失败！");
				return inventoryJson;
			}
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
	public JSONObject deleteInventory(@Param(value = "id") String id) {
		JSONObject inventoryJson = new JSONObject();
		if(StringUtils.isEmpty(id)) {
			inventoryJson.put("code", "0");
			inventoryJson.put("msg", "删除数据失败！");
			return inventoryJson;
		}else {
			InventoryInfo inventoryInfo = inventoryService.deleteInventory(id);
			if(inventoryInfo != null) {
				inventoryJson.put("code", "200");
				inventoryJson.put("msg", "删除数据成功！");
				inventoryJson.put("inventoryInfo", id);
				return inventoryJson;
			}else {
				inventoryJson.put("code", "1");
				inventoryJson.put("msg", "删除数据失败！");
				return inventoryJson;
			}
		}
	}
	
	@PostMapping("/getInventoryList")
	public Map<String, Object> getInventoryList(@RequestBody InventoryProdDto inventoryProdDto){
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(inventoryProdDto.getPageNum(), inventoryProdDto.getPageSize());
		Page<InventoryInfo> resultList = inventoryService.getInventoryPage(inventoryProdDto);
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
