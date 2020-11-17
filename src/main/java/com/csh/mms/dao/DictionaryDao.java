package com.csh.mms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.csh.mms.domain.SysDictionary;

@Mapper
public interface DictionaryDao {

	SysDictionary getDictionary(@Param("id") String id);

	SysDictionary insertDictionary(SysDictionary sysDictionary);

	SysDictionary updateDictionary(SysDictionary sysDictionary);

	SysDictionary deleteDictionary(String id);


}
