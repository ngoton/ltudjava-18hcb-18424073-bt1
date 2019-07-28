package com.sims.dao;

import com.sims.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {
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
        File file = new File(getClass().getResource(userFile).getFile());
        List<User> list = new ArrayList<>();
        try(Scanner sc = new Scanner(file)) {
            while(sc.hasNextLine()){
                String[] arr = sc.nextLine().split("\\|");
                User user = new User();
                user.setId(Integer.parseInt(arr[0]));
                user.setUsername(arr[1]);
                user.setPassword(arr[2]);
                user.setRole(arr[3]);

                list.add(user);
            }
        } catch (IOException e) {
            System.out.println("Got an exception!");
        }
        return list;
    }
}
