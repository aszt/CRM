package com.crm.service.impl;

import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import com.crm.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 客户管理业务层实现类
 *
 * @author tong
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {

    // 注入DAO
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerService中的save方法调用了...");
        customerDao.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public Customer findById(Long cust_id) {
        return customerDao.findById(cust_id);
    }

    @Override
    public List<Customer> findAllByHQL() {
        return customerDao.findAllByHQL();
    }

    @Override
    public List<Customer> findAllByQBC() {
        return customerDao.findAllByQBC();
    }
}
