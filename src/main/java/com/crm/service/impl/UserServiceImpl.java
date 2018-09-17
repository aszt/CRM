package com.crm.service.impl;

import com.crm.dao.UserDao;
import com.crm.domain.User;
import com.crm.service.UserService;
import com.crm.utils.MD5Utils;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        // 对密码进行加密
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        user.setUser_state("1");
        userDao.save(user);
    }

    @Override
    public User login(User user) {
        // 密码加密
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        return userDao.login(user);
    }
}
