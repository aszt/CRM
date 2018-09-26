package com.crm.dao.impl;

import com.crm.dao.BaseDictDao;
import com.crm.domain.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 字典的实现类
 */
public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {
    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        String hql = "from BaseDict where dict_type_code= ?0";
        List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().find(hql, dict_type_code);
        return list;
    }
}
