package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.csh.mms.domain.InventoryInfo;
import com.csh.mms.dto.InventoryProdDto;
import com.github.pagehelper.Page;

@Mapper
public interface InventoryInfoDao {

	InventoryInfo getInventoryInfo(@Param("id") String id);

	InventoryInfo insertInventory(InventoryInfo inventoryInfo);

	InventoryInfo updateInventory(InventoryInfo inventoryInfo);

	InventoryInfo deleteInventory(@Param("id") String id);

	Page<InventoryInfo> getInventoryPage(InventoryProdDto inventoryProdDto);

}
