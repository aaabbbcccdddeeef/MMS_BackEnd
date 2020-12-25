package com.csh.mms.service;

import org.apache.ibatis.annotations.Param;

import com.csh.mms.domain.ProductionInfo;
import com.csh.mms.dto.InventoryProdDto;
import com.github.pagehelper.Page;

public interface ProductionInfoService {

	ProductionInfo getProdInfo(@Param("id") String id);

	ProductionInfo deleteProd(@Param("id") String id);

	ProductionInfo insertProd(ProductionInfo pordInfo);

	ProductionInfo updateProd(ProductionInfo pordInfo);

	Page<InventoryProdDto> getProdList(InventoryProdDto prod);

}
