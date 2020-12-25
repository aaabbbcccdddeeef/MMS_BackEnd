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

import com.csh.mms.domain.SaleRecord;
import com.csh.mms.dto.SaleInventoryProdDto;
import com.csh.mms.service.SaleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/sale")
public class SaleRecordController {
	
	@Autowired
	private SaleService saleService;
	
	@PostMapping("/getSaleRecord")
	public JSONObject getSaleRecord(@Param(value = "id") String id) {
		SaleRecord saleRecord = new SaleRecord();
		JSONObject json = new JSONObject();
		if(StringUtils.isEmpty(id)) {
			json.put("code", "0");
			json.put("msg", "销售数据id是空，查询失败！");
			return json;
		}else {
			saleRecord = saleService.getSaleRecord(id);
			if(saleRecord != null) {
				json.put("code", "200");
				json.put("msg", "查询成功！");
				json.put("saleRecord", saleRecord);
				return json;
			}
			return json;
		}
	}
	
	public JSONObject insertSaleRecord(SaleRecord saleRecord) {
		JSONObject json = new JSONObject();
		if(saleRecord != null) {
			SaleRecord resultSale = saleService.insertSaleRecord(saleRecord);
			if(resultSale != null) {
				json.put("code", "200");
				json.put("msg", "添加库存成功！");
				json.put("saleRecord", resultSale);
				return json;
			}
			
		}
		json.put("code", "0");
		json.put("msg", "添加库存失败！");
		return json;
	}
	
	public JSONObject updateSaleRecord(SaleRecord saleRecord) {
		JSONObject json = new JSONObject();
		if(saleRecord != null) {
			SaleRecord resultSale = saleService.updateSaleRecord(saleRecord);
			if(resultSale != null) {
				json.put("code", "200");
				json.put("msg", "修改库存成功！");
				json.put("saleRecord", resultSale);
				return json;
			}
			
		}
		json.put("code", "0");
		json.put("msg", "修改库存失败！");
		return json;
	}
	
	public JSONObject deleteSaleRecord(@Param(value = "id") String id) {
		JSONObject json = new JSONObject();
		if (StringUtils.isEmpty(id)) {
			json.put("statusCode", "0");
			json.put("msg", "数据id是空，删除失败！");
			return json;
		} else {
			SaleRecord resultDelet =saleService.deleteSaleRecord(id);
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
	
	@PostMapping("/getSaleList")
	public Map<String, Object> getSaleList(@RequestBody SaleInventoryProdDto dto) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		Page<SaleInventoryProdDto> resultList = saleService.getSaleList(dto);
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
