package com.crm.dao.impl;

import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 客户管理DAO层的实现类
 * @author tong
 *
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerDao中的save方法调用了...");
        this.getHibernateTemplate().save(customer);
    }
}
