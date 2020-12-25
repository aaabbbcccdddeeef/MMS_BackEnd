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

	ProductionInfo insertProd(ProductionInfo pordInfo);

	ProductionInfo daleteInfo(String id);

	ProductionInfo getProdInfo(String id);

	ProductionInfo updateProd(ProductionInfo pordInfo);

	Page<InventoryProdDto> getProdList(InventoryProdDto prod);


}
