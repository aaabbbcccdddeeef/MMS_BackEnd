package com.csh.mms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.domain.ProductionInfo;
import com.csh.mms.dto.InventoryProdDto;
import com.csh.mms.service.ProductionInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

/**
 * 
 * @ClassName  ProductionInfoController 
 * @Description 产品信息控制类
 * @author csh
 * @date  2020年11月3日 下午10:11:12 
 *
 */
@RestController
@RequestMapping("/production")
public class ProductionInfoController {

	@Autowired
	private ProductionInfoService prodService;

	/**
	 * 
	 * @Title  getProdInfo 
	 * @Description  查询产品详细信息
	 * @param id
	 * @return JSONObject
	 */
	@PostMapping("/getProdInfo")
	public Map<String, Object> getProdInfo(@RequestBody ProductionInfo prodInfo) { 
		Map<String, Object> prodMap = new HashMap<String, Object>(); 
		String id = prodInfo.getId();
		if(StringUtils.isEmpty(id)) {
			prodMap.put("statusCode", "0");
			prodMap.put("msg", "数据id是空，查询失败！");
			return prodMap;
		}else {
			prodInfo = prodService.getProdInfo(id);
			if(prodInfo != null) {
				prodMap.put("code", "200"); 
				prodMap.put("msg", "数据查询成功！");
				prodMap.put("prodInfo", prodInfo);
				return prodMap;
			}
		}
		return prodMap; 
	}

	/**
	 * 
	 * @Title  insertProd 
	 * @Description  添加产品信息
	 * @param pordInfo
	 * @return Map<String,Object>
	 */
	@PostMapping("/insertProd")
	public JSONObject insertProd(HttpServletRequest request, @RequestBody ProductionInfo pordInfo) {
		HttpSession session = request.getSession();
		JSONObject json = new JSONObject();
		ProductionInfo pordInfoResult = prodService.insertProd(pordInfo);
		if(pordInfo.getId() != null) {
			json.put("code", "200");
			json.put("msg", "产品添加成功！");
			json.put("pordInfo", pordInfoResult);
			return json;
		}else {
			json.put("code", "0");
			json.put("msg", "产品添加失败！");
			return json;
		}
	}
	
	/**
	 * 
	 * @Title  updateProd 
	 * @Description  修改产品信息
	 * @param pordInfo
	 * @return JSONObject
	 */
	@PostMapping("/updateProd")
	public JSONObject updateProd(ProductionInfo pordInfo) {
		JSONObject json = new JSONObject();
		pordInfo = (ProductionInfo) prodService.updateProd(pordInfo);
		if(pordInfo.getId() != null) {
			json.put("code", "200");
			json.put("msg", "产品信息修改成功！");
			json.put("pordInfo", pordInfo);
			return json;
		}else {
			json.put("code", "0");
			json.put("msg", "产品信息修改失败！");
			return json;
		}
	}

	/**
	 * 
	 * @Title  deleteProd 
	 * @Description  删除产品-逻辑删除
	 * @param id
	 * @return Map<String,Object>
	 */
	@PostMapping("/deleteProd")
	public Map<String, Object> deleteProd(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isEmpty(id)) {
			map.put("statusCode", "0");
			map.put("msg", "数据id是空，删除失败！");
			return map;
		} else {
			ProductionInfo resultDelet = prodService.deleteProd(id);
			if(resultDelet !=null) {
				map.put("statusCode", "200");
				map.put("msg", "产品数据删除成功！");
				return map;
			}else {
				map.put("statusCode", "1");
				map.put("msg", "数据异常，删除失败！");
				return map;
			}
			
		}
	}
	@PostMapping("/getProdList")
	public Map<String, Object> getProdList(@RequestBody InventoryProdDto prod){
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(prod.getPageNum(), prod.getPageSize());
		Page<InventoryProdDto> resultList = prodService.getProdList(prod);
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
