package com.csh.mms.service;

import com.csh.mms.dto.DictionaryDetailDto;
import com.csh.mms.dto.DictionaryDto;
import com.github.pagehelper.Page;

public interface DictionaryService {

	void insertDictionary(DictionaryDto dto);

	void updateDictionary(DictionaryDto dto);

	void deleteDictionary(DictionaryDto dto);

	Page<DictionaryDto> getDictList(DictionaryDto dto);

	Page<DictionaryDto> getDictDetailList(DictionaryDto dto);

	void insertDictionaryDetail(DictionaryDetailDto dto);

	void updateDictionaryDetail(DictionaryDetailDto dto);

	void deleteDictionaryDetail(DictionaryDetailDto dto);

}
