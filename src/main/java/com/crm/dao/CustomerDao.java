package com.crm.dao;

import com.crm.domain.Customer;

import java.util.List;

/**
 * 客户管理DAO层的接口
 *
 * @author tong
 */
public interface CustomerDao {

    void save(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);

    Customer findById(Long cust_id);

    List<Customer> findAllByHQL();

    List<Customer> findAllByQBC();

    List<Customer> findAllByNamedQuery();
}
