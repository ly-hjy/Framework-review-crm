package cn.weimoo.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.weimoo.crm.pojo.BaseDict;
import cn.weimoo.crm.pojo.QueryVo;
import cn.weimoo.crm.service.BaseDictService;


/**
 * 客户管理
 * @author h7855
 *
 */
@Controller
public class CustomController {
	
	@Autowired
	private BaseDictService baseDictService;
	
	
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
		return "customer";
	}
}
