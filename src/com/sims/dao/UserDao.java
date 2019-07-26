package com.sims.dao;

import com.sims.model.User;

import java.util.List;

public interface UserDao {
    User login(String username, String password);
    List<User> getList();
}
