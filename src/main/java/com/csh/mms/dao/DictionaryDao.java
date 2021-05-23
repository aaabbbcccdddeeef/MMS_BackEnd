package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;

import com.csh.mms.dto.DictionaryDetailDto;
import com.csh.mms.dto.DictionaryDto;
import com.github.pagehelper.Page;

@Mapper
public interface DictionaryDao {

	void insertDictionary(DictionaryDto dto);

	void updateDictionary(DictionaryDto dto);

	void deleteDictionary(DictionaryDto dto);

	Page<DictionaryDto> getDictList(DictionaryDto dto);

	Page<DictionaryDto> getDictDetailList(DictionaryDto dto);

	void insertDictionaryDetail(DictionaryDetailDto dto);

	void updateDictionaryDetail(DictionaryDetailDto dto);

	void deleteDictionary(DictionaryDetailDto dto);


}
