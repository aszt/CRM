package com.crm.service.impl;

import com.crm.dao.BaseDictDao;
import com.crm.domain.BaseDict;
import com.crm.service.BaseDictService;

import java.util.List;

/**
 * 字典业务层实现类
 */
public class BaseDictServiceImpl implements BaseDictService {
    // 注入DAO
    private BaseDictDao baseDictDao;

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }

    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        return baseDictDao.findByTypeCode(dict_type_code);
    }
}
