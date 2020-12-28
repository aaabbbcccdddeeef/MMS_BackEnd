package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;

import com.csh.mms.dto.InventoryProdDto;
import com.github.pagehelper.Page;

@Mapper
public interface InventoryInfoDao {

	void updateInventory(InventoryProdDto dto);

	void deleteInventory(InventoryProdDto dto);

	Page<InventoryProdDto> getInventoryList(InventoryProdDto dto);


	void insertInventory(InventoryProdDto dto);

}
