package com.shi.service;


import com.shi.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {

    //查询code查询
    List<BaseDict> selectBaseDictListByCode(String code);


    //根据名称查询
    List<BaseDict> selectBaseDictListByName(String name);

}
