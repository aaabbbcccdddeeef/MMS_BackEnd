package com.csh.mms.service;

import com.csh.mms.domain.InventoryInfo;
import com.csh.mms.dto.InventoryProdDto;
import com.github.pagehelper.Page;

public interface InventoryInfoService {

	InventoryInfo getInventoryInfo(String id);

	InventoryInfo insertInventory(InventoryInfo inventoryInfo);

	InventoryInfo updateInventory(InventoryInfo inventoryInfo);

	InventoryInfo deleteInventory(String id);

	Page<InventoryInfo> getInventoryPage(InventoryProdDto inventoryProdDto);

}
