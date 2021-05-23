package com.csh.mms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.dto.SaleInventoryProdDto;
import com.csh.mms.service.SaleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
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
	@PostMapping("/insertSaleRecord")
	public Map<String, Object> insertSaleRecord(@RequestBody SaleInventoryProdDto dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(dto != null) {
			saleService.insertSaleRecord(dto);
			SaleInventoryProdDto dto1 = new SaleInventoryProdDto();
			dto1.setPageNum(dto.getPageNum());
			dto1.setPageSize(dto.getPageSize());
			return getSaleList(dto1);
		}else {
			map.put("code", 0);
			map.put("msg", "销售记录参数是空,添加失败!");
			return map;
		}
	}
	@PostMapping("/updateSaleRecord")
	public Map<String, Object> updateSaleRecord(@RequestBody SaleInventoryProdDto dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(dto != null) {
			saleService.updateSaleRecord(dto);
			SaleInventoryProdDto dto1 = new SaleInventoryProdDto();
			dto1.setPageNum(dto.getPageNum());
			dto1.setPageSize(dto.getPageSize());
			return getSaleList(dto1);
		}else {
			map.put("code", 1);
			map.put("msg", "销售记录参数是空,修改失败!");
			return map;
		}
	}
	@PostMapping("/deleteSaleRecord")
	public Map<String, Object> deleteSaleRecord(@RequestBody SaleInventoryProdDto dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(dto != null) {
			saleService.deleteSaleRecord(dto);
			SaleInventoryProdDto dto1 = new SaleInventoryProdDto();
			dto1.setPageNum(dto.getPageNum());
			dto1.setPageSize(dto.getPageSize());
			return getSaleList(dto1);
		}else {
			map.put("code", 1);
			map.put("msg", "销售记录参数是空,修改失败!");
			return map;
		}
	} 
	
	 
}
