package com.sims.dao;

import com.sims.model.Student;
import com.sims.model.User;

import java.util.List;

public interface UserDao {
    User login(String username, String password);
    List<User> getList();
    User getUserById(Integer id);
    User getUserByName(Student student);
    boolean addOne(User user);
    boolean updateOne(User user);
    boolean deleteAll(List<User> users);
    boolean changeName(Integer id, String name);
}
