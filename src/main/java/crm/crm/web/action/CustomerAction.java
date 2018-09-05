package crm.crm.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.crm.domain.Customer;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = 1L;
	
	// 模型驱动使用的对象
	private Customer customer = new Customer();
	
	@Override
	public Customer getModel() {
		return customer;
	}

}
