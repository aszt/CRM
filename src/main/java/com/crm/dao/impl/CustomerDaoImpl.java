package com.crm.dao.impl;

import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 客户管理DAO层的实现类
 *
 * @author tong
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerDao中的save方法调用了...");
        this.getHibernateTemplate().save(customer);
    }

    @Override
    public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    @Override
    public Customer findById(Long cust_id) {
        return this.getHibernateTemplate().get(Customer.class, cust_id);
    }

    @Override
    public List<Customer> findAllByHQL() {
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer ");
        return list;
    }

    @Override
    public List<Customer> findAllByQBC() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }

    @Override
    public List<Customer> findAllByNamedQuery() {
        return (List<Customer>) this.getHibernateTemplate().findByNamedQuery("queryAll");
    }

}
