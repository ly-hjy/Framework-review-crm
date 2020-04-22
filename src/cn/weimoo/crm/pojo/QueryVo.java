package cn.weimoo.crm.pojo;

import lombok.Data;

@Data
public class QueryVo {
	//客户名称
	private String custName;
	//客户来源
	private String custSource;
	//所属行业
	private String custIndustry;
	//客户级别
	private String custLevel;
	//当前页
	private Integer page;
	//每页数
	private Integer size = 10;
	//开始行
	private Integer startRow = 0;
	
}
