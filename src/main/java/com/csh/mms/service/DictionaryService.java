package com.csh.mms.service;

import com.csh.mms.domain.SysDictionary;
import com.csh.mms.dto.DictionaryDto;
import com.github.pagehelper.Page;

public interface DictionaryService {

	SysDictionary insertDictionary(SysDictionary sysDictionary);

	SysDictionary updateDictionary(SysDictionary sysDictionary);

	SysDictionary deleteDictionary(String id);

	Page<DictionaryDto> getDictList(DictionaryDto dto);

}
