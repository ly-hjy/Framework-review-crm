package cn.weimoo.crm.service;

import org.springframework.stereotype.Service;

import cn.weimoo.common.utils.Page;
import cn.weimoo.crm.pojo.Customer;
import cn.weimoo.crm.pojo.QueryVo;

/**
 * 客户相关服务层
 * @author h7855
 *
 */

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//通过条件查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo ){
		Page<Customer> page = new Page<Customer>();
		
		if (vo!=null) {
			//设置当前页
			if (vo.getPage()!=  null) {
				page.setPage(vo.getPage());
			}
			if (null!=vo.getCustName()&&!"".equals(vo.getCustName().trim())) {
				vo.setCustName(vo.getCustName().trim());
			}
			if (null!=vo.getCustSource()&&!"".equals(vo.getCustSource().trim())) {
				vo.setCustSource(vo.getCustSource().trim());
			}			if (null!=vo.getCustIndustry()&&!"".equals(vo.getCustIndustry().trim())) {
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}			if (null!=vo.getCustLevel()&&!"".equals(vo.getCustLevel().trim())) {
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			
			
		}
		//每页记录数
		page.setSize(5);
		return page;
	}
	
}
