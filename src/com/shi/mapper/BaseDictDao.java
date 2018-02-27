package com.shi.mapper;


import com.shi.pojo.BaseDict;

import java.util.List;

public interface BaseDictDao {

	//根据id查询客户列报表
	List<BaseDict> selectBaseDictListByCode(String code);

	//根据名称查询客户列表
	List<BaseDict> selectBaseDictListByName(String name);

}
