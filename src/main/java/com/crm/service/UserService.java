package com.crm.service;

import com.crm.domain.User;

public interface UserService {
    void save(User user);

    User login(User user);
}
