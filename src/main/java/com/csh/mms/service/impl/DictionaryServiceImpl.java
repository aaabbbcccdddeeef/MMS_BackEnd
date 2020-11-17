package com.csh.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csh.mms.dao.DictionaryDao;
import com.csh.mms.domain.SysDictionary;
import com.csh.mms.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService{
	
	@Autowired
	private DictionaryDao dictionaryDao;

	@Override
	@Transactional
	public SysDictionary getDictionary(String id) {
		SysDictionary dictionary = dictionaryDao.getDictionary(id);
		return dictionary;
	}

	@Override
	@Transactional
	public SysDictionary insertDictionary(SysDictionary sysDictionary) {
		sysDictionary = dictionaryDao.insertDictionary(sysDictionary);
		return sysDictionary;
	}

	@Override
	@Transactional
	public SysDictionary updateDictionary(SysDictionary sysDictionary) {
		sysDictionary = dictionaryDao.updateDictionary(sysDictionary);
		return sysDictionary;
	}

	@Override
	@Transactional
	public SysDictionary deleteDictionary(String id) {
		SysDictionary sysDictionary = dictionaryDao.deleteDictionary(id);
		return sysDictionary;
	}


	
}
