package com.sims.service;

import com.sims.model.User;

public interface UserService {
    User login(String username, String password);
    boolean changePassword(User user);
}
