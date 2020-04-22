package cn.weimoo.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weimoo.common.utils.Page;
import cn.weimoo.crm.dao.CustomerMapper;
import cn.weimoo.crm.pojo.Customer;
import cn.weimoo.crm.pojo.QueryVo;

/**
 * 客户相关服务层
 * @author h7855
 *
 */

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//注入dao
	@Autowired
	private CustomerMapper customerMapper;
	
	//通过条件查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo ){
		Page<Customer> page = new Page<Customer>();
		//每页记录数
		vo.setSize(5);
		page.setSize(5);
		if (vo!=null) {
			//设置当前页
			if (vo.getPage()!=  null) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			if (null!=vo.getCustName()&&!"".equals(vo.getCustName().trim())) {
				vo.setCustName(vo.getCustName().trim());
			}
			if (null!=vo.getCustSource()&&!"".equals(vo.getCustSource().trim())) {
				vo.setCustSource(vo.getCustSource().trim());
			}			
			if (null!=vo.getCustIndustry()&&!"".equals(vo.getCustIndustry().trim())) {
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}			
			if (null!=vo.getCustLevel()&&!"".equals(vo.getCustLevel().trim())) {
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			//设置总条数
			page.setTotal(customerMapper.countCostomerByQueryVo(vo));
			//设置customer列表
			page.setRows(customerMapper.selectCustomersByQueryVo(vo));
			
			
		}
		
		return page;
	}
	public Customer selectCustomerById(Integer id){
		
		return customerMapper.selectCustomerById(id);
	}
	@Override
	public void updateCustomerByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.updateCustomerByCustomer(customer);
	}
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		customerMapper.deleteById(id);
	}
	
}
