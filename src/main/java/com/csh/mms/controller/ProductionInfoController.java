package com.csh.mms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csh.mms.domain.ProductionInfo;
import com.csh.mms.service.ProductionInfoService;

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
	public JSONObject getProdInfo(String id) { 
//		Map<String, Object> prodMap = new HashMap<String, Object>(); 
		JSONObject json = new JSONObject();
		ProductionInfo prodInfo = new ProductionInfo();
		if(StringUtils.isEmpty(id)) {
			json.put("statusCode", "0");
			json.put("msg", "数据id是空，查询失败！");
			return json;
		}else {
			prodInfo = prodService.getProdInfo(id);
			if(prodInfo != null) {
				json.put("ststusCode", "200"); 
				json.put("msg", "数据查询成功！");
				json.put("prodInfo", prodInfo);
			}
			json.put("ststusCode", "1"); 
			json.put("msg", "数据异常！");
			return json;
		} 
	}

	/**
	 * 
	 * @Title  insertProd 
	 * @Description  添加产品信息
	 * @param pordInfo
	 * @return Map<String,Object>
	 */
	@PostMapping("/insertProd")
	public JSONObject insertProd(ProductionInfo pordInfo) {
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
	public JSONObject deleteProd(String id) {
		JSONObject json = new JSONObject();
		if (StringUtils.isEmpty(id)) {
			json.put("statusCode", "0");
			json.put("msg", "数据id是空，删除失败！");
			return json;
		} else {
			ProductionInfo resultDelet = prodService.deleteProd(id);
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
