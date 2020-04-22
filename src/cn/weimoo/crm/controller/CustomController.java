package cn.weimoo.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.weimoo.common.utils.Page;
import cn.weimoo.crm.dao.CustomerMapper;
import cn.weimoo.crm.pojo.BaseDict;
import cn.weimoo.crm.pojo.Customer;
import cn.weimoo.crm.pojo.QueryVo;
import cn.weimoo.crm.service.BaseDictService;
import cn.weimoo.crm.service.CustomerService;


/**
 * 客户管理
 * @author h7855
 *
 */
@Controller
public class CustomController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	//入口
	@RequestMapping(value="/customer/list")
	public String list(Model model ,QueryVo vo){
		//查询表单选项，并传入model
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode("002");
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode("001");
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode("006");
		model.addAttribute("fromType",fromType);
		model.addAttribute("industryType",industryType);
		model.addAttribute("levelType",levelType);
		
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page",page);
		
		//设置回显
		model.addAttribute("custName",vo.getCustName());
		model.addAttribute("custSource",vo.getCustSource());
		model.addAttribute("custIndustry",vo.getCustIndustry());
		model.addAttribute("custLevel",vo.getCustLevel());

		return "customer";
	}
	
	
	//通过ajax显示修改窗口
	@RequestMapping(value="/customer/edit.action")
	public@ResponseBody
	Customer edit(Integer id){
		return customerService.selectCustomerById(id);
	}
	
	//保存对用户的修改
	@RequestMapping(value="/customer/update.action")
	public@ResponseBody
	String edit(Customer customer){
		customerService.updateCustomerByCustomer(customer);
		return "OK";
	}
	@RequestMapping(value="/customer/delete.action")
	public@ResponseBody
	String delete(Integer id){
		customerService.deleteById(id);
		return "OK";
	}
}
