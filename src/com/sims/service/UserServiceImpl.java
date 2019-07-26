package com.sims.service;

import com.sims.dao.UserDao;
import com.sims.dao.UserDaoImpl;
import com.sims.model.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(){
        this.userDao = new UserDaoImpl();
    }

    public User login(String username, String password){
        return userDao.login(username, password);
    }
}
