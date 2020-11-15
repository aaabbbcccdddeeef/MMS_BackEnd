package com.csh.mms.service;

import com.csh.mms.domain.InventoryInfo;

public interface InventoryInfoService {

	InventoryInfo getInventoryInfo(String id);

	InventoryInfo insertInventory(InventoryInfo inventoryInfo);

	InventoryInfo updateInventory(InventoryInfo inventoryInfo);

	InventoryInfo deleteInventory(String id);

}
