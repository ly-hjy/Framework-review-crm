package cn.weimoo.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.weimoo.crm.dao.BaseDictMapper;
import cn.weimoo.crm.pojo.BaseDict;

@Service
//@Transactional
public class BaseDictServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictMapper baseDictMapper;

	@Override
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		// TODO Auto-generated method stub
		return baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
		
	}
	
	
}
