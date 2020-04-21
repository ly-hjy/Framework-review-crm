package cn.weimoo.crm.dao;

import java.util.List;

import cn.weimoo.crm.pojo.BaseDict;

public interface BaseDictMapper {
	/**
	 * 根据类别代码查询数据
	 * 
	 * @param dictTypeCode
	 * @return List
	 */

	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
