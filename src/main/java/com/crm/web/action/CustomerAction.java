package com.crm.web.action;

import com.crm.domain.Customer;
import com.crm.domain.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.crm.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;

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

    // 使用属性驱动set方法接收数据：
    private Integer currPage = 1;

    private Integer pageSize = 3;

    public void setCurrPage(Integer currPage) {
        if (currPage == null) {
            currPage = 1;
        }
        this.currPage = currPage;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }

    /**
     * 保存客户
     *
     * @return
     */
    public String save() {
        System.out.println("Action中的save方法调用了...");
        customerService.save(customer);
        return "findAll";
    }

    /**
     * 跳转至添加页面
     *
     * @return
     */
    public String saveUI() {
        return "saveUI";
    }

    /**
     * 分页查询客户列表
     *
     * @return
     */
    public String findAll() {
        // 就收参数：分页参数
        // 最好使用DetachedCriteria对象（条件查询--带分页）
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        // 调用业务层查询
        PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }
}
