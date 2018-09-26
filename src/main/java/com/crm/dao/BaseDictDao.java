package com.crm.dao;

import com.crm.domain.BaseDict;

import java.util.List;

/**
 * 字典DAO的接口
 */
public interface BaseDictDao {
    List<BaseDict> findByTypeCode(String dict_type_code);
}
