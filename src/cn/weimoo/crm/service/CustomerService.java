package cn.weimoo.crm.service;

import cn.weimoo.common.utils.Page;
import cn.weimoo.crm.pojo.Customer;
import cn.weimoo.crm.pojo.QueryVo;

public interface CustomerService {
	public Page<Customer> selectPageByQueryVo(QueryVo vo );
	public Customer selectCustomerById(Integer id);
	public void updateCustomerByCustomer(Customer customer);
	public void deleteById(Integer id);
}
