package cn.weimoo.crm.service;

import java.util.List;

import cn.weimoo.crm.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}
