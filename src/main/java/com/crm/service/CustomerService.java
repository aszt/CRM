package com.crm.service;

import com.crm.domain.Customer;
import com.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 客户管理业务层接口
 *
 * @author tong
 */
public interface CustomerService {

    void save(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);

    Customer findById(Long cust_id);

    List<Customer> findAllByHQL();

    List<Customer> findAllByQBC();

    PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);
}
