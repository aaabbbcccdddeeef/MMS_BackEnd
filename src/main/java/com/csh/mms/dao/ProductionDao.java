package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;

import com.csh.mms.domain.ProductionInfo;
import com.csh.mms.dto.InventoryProdDto;
import com.github.pagehelper.Page;
/**
 * 
 * @ClassName  UserDao 
 * @Description 用户管理-数据交互dao
 * @author csh
 * @date  2020年11月1日 上午12:49:32 
 *
 */
@Mapper
public interface ProductionDao {

	void insertProd(InventoryProdDto dto);

	ProductionInfo getProdInfo(String id);

	void updateProd(InventoryProdDto dto);

	Page<InventoryProdDto> getProdList(InventoryProdDto prod);

	void deleteProd(String id);


}
