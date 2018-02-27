package com.shi.service;

import com.shi.mapper.BaseDictDao;
import com.shi.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
public class BaseDictServiceImpl implements BaseDictService {


    @Autowired
    private BaseDictDao baseDictDao;

    public List<BaseDict> selectBaseDictListByCode(String code) {
        return baseDictDao.selectBaseDictListByCode(code);
    }

    @Override
    public List<BaseDict> selectBaseDictListByName(String name) {
        return baseDictDao.selectBaseDictListByName(name);
    }

}
