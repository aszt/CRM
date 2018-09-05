package com.crm.service.impl;

import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import com.crm.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客户管理业务层实现类
 * @author tong
 *
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
}
