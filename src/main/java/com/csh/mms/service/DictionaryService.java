package com.csh.mms.service;

import com.csh.mms.domain.SysDictionary;

public interface DictionaryService {

	SysDictionary getDictionary(String id);

	SysDictionary insertDictionary(SysDictionary sysDictionary);

	SysDictionary updateDictionary(SysDictionary sysDictionary);

	SysDictionary deleteDictionary(String id);

}
