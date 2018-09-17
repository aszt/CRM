package com.crm.web.action;

import com.crm.domain.User;
import com.crm.service.UserService;
import com.crm.utils.MD5Utils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    // 注入userService
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册的方法：regist
     *
     * @return
     */
    public String regist() {
        userService.save(user);
        return LOGIN;
    }

    /**
     * 用户登录的方法：login
     *
     * @return
     */
    public String login() {
        User existUser = userService.login(user);
        if(null != existUser){
            ActionContext.getContext().getSession().put("existUser",existUser);
            return SUCCESS;
        }else{
            this.addActionError("用户名或密码错误！");
            return LOGIN;
        }
    }
}
