package com.csh.mms.service;

import com.csh.mms.dto.InventoryProdDto;
import com.github.pagehelper.Page;

public interface InventoryInfoService {

	void insertInventory(InventoryProdDto dto);

	void updateInventory(InventoryProdDto dto);

	void deleteInventory(InventoryProdDto dto);

	Page<InventoryProdDto> getInventoryList(InventoryProdDto dto);

}
