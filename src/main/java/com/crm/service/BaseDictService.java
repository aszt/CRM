package com.crm.service;

import com.crm.domain.BaseDict;

import java.util.List;

/**
 * 字典业务层接口
 */
public interface BaseDictService {
    List<BaseDict> findByTypeCode(String dict_type_code);
}
