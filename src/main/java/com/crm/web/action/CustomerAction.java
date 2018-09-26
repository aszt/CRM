package com.crm.web.action;

import com.crm.domain.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.crm.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private static final long serialVersionUID = 1L;

    // 模型驱动使用的对象
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    // 注入CustomerService
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 保存客户
     *
     * @return
     */
    public String save() {
        System.out.println("Action中的save方法调用了...");
        customerService.save(customer);
        return NONE;
    }

    /**
     * 跳转至添加页面
     * @return
     */
    public String saveUI(){
        return "saveUI";
    }
}
