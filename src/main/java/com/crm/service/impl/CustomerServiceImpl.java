package com.crm.service.impl;

import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import com.crm.domain.PageBean;
import com.crm.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
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

    /**
     * 业务层分页查询客户的方法
     *
     * @param detachedCriteria
     * @param currPage
     * @return
     */
    @Override
    public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<Customer> pageBean = new PageBean<Customer>();
        // 封装当前页数
        pageBean.setCurrPage(currPage);
        // 封装每页显示记录数
        pageBean.setPageSize(pageSize);
        // 封装总记录数：
        // 调用DAO：
        Integer totalCount = customerDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        // 封装总页数
        Double tc = totalCount.doubleValue();
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 封装每页显示数据的集合
        Integer begin = (currPage - 1) * pageSize;
        List<Customer> list = customerDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}
