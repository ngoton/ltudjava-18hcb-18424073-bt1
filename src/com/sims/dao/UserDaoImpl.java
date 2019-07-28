package com.sims.dao;

import com.sims.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends IOFileDao implements UserDao {
    private static String userFile = "../data/user.txt";
    private List<User> users;

    public UserDaoImpl() {
        this.users = getList();
    }

    @Override
    public User login(String username, String password){
        User user = null;
        for (User item : users){
            if (username.equals(item.getUsername()) && password.equals(item.getPassword())){
                user = item;
                break;
            }
        }

        return user;
    }

    @Override
    public List<User> getList(){
        List<User> list = new ArrayList<>();
        List<String[]> data = readFile(userFile);
        for (String[] arr : data){
            User user = new User();
            user.setId(Integer.parseInt(arr[0]));
            user.setUsername(arr[1]);
            user.setPassword(arr[2]);
            user.setRole(arr[3]);

            list.add(user);
        }

        return list;
    }
}
