package com.crm.dao;

import com.crm.domain.Customer; /**
 * 客户管理DAO层的接口
 * @author tong
 *
 */
public interface CustomerDao {

    void save(Customer customer);
}
