package com.crm.dao;

import com.crm.domain.User;

public interface UserDao {
    void save(User user);

    User login(User user);
}
