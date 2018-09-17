package com.crm.dao.impl;

import com.crm.dao.UserDao;
import com.crm.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

    @Override
    public User login(User user) {
        // hibernate 4.1之后对于HQL中查询参数的占位符做了改进
        // JPA占位符的方式
        String hql = "from User where user_code= ?0 and user_password= ?1";
        List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUser_code(), user.getUser_password());
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
