package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;

import com.csh.mms.domain.SysDictionary;
import com.csh.mms.dto.DictionaryDto;
import com.github.pagehelper.Page;

@Mapper
public interface DictionaryDao {

	SysDictionary insertDictionary(SysDictionary sysDictionary);

	SysDictionary updateDictionary(SysDictionary sysDictionary);

	SysDictionary deleteDictionary(String id);

	Page<DictionaryDto> getDictList(DictionaryDto dto);


}
