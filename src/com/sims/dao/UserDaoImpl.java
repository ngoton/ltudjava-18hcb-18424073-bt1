package com.sims.dao;

import com.sims.model.Student;
import com.sims.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends IOFileDao implements UserDao {
    private static String path = "../data/user.txt";
    private String userFile;

    public UserDaoImpl() {
        this.userFile = getClass().getResource(path).getFile();
    }

    @Override
    public User login(String username, String password){
        List<User> users = getList();
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
        List<String[]> data = readFile(userFile, "\\|");
        for (String[] arr : data){
            User user = new User();
            user.setId(Integer.parseInt(arr[0]));
            user.setUsername(arr[1]);
            user.setPassword(arr[2]);
            user.setRole(arr[3]);

            StudentDao studentDao = new StudentDaoImpl();
            Student student = studentDao.getStudentById(Integer.parseInt(arr[4]));
            if (student != null){
                user.setStudent(student);
            }

            list.add(user);
        }

        return list;
    }

    @Override
    public User getUserById(Integer id){
        List<User> users = getList();
        User user = null;
        for (User u : users){
            if (id.equals(u.getId())){
                user = u;
                break;
            }
        }
        return user;
    }

    @Override
    public User getUserByName(Student student){
        List<User> users = getList();
        User user = null;
        for (User u : users){
            if (student.getId().equals(u.getStudent().getId())){
                user = u;
                break;
            }
        }
        return user;
    }

    @Override
    public boolean addOne(User user){
        List<User> userList = new ArrayList<>();
        userList.add(user);
        return writeFile(userList, userFile, true);
    }

    @Override
    public boolean updateOne(User user){
        List<User> users = getList();
        List<User> userList = new ArrayList<>();
        for(User u : users){
            if (u.getId().equals(user.getId())){
                u.setUsername(user.getUsername());
            }
            userList.add(u);
        }

        return writeFile(userList, userFile, false);
    }

    @Override
    public boolean deleteAll(List<User> list){
        List<User> users = getList();
        List<User> userList = new ArrayList<>();
        for (User u : users){
            if (!list.remove(u)){
                userList.add(u);
            }
        }
        return writeFile(userList, userFile, false);
    }

    @Override
    public boolean changeName(Integer id, String name){
        List<User> users = getList();
        List<User> userList = new ArrayList<>();
        for (User u : users){
            if (u.getId().equals(getUserById(id))){
                u.setUsername(name);
            }
            userList.add(u);
        }
        return writeFile(userList, userFile, false);
    }
}
