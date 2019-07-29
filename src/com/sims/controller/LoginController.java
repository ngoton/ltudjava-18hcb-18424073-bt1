package com.sims.controller;

import com.sims.model.User;
import com.sims.service.UserService;
import com.sims.service.UserServiceImpl;
import com.sims.view.LoginForm;
import com.sims.view.MainForm;

import javax.swing.*;

public class LoginController {
    private UserService userService = new UserServiceImpl();
    private LoginForm loginForm;
    private JLabel messageLabel;

    public LoginController(){}

    public LoginController(LoginForm loginForm, JLabel messageLabel){
        this.loginForm = loginForm;
        this.messageLabel = messageLabel;
    }

    public void login(String username, String password){
        try{
            User user = userService.login(username, password);
            if (user == null){
                messageLabel.setText("Tên đăng nhập & mật khẩu không đúng!");
            }
            else {
                if (user.getRole().equals("ADMIN")){
                    MainForm mainForm = new MainForm(true, user);
                    loginForm.setVisible(false);
                    mainForm.setVisible(true);
                }
                else {
                    MainForm mainForm = new MainForm(false, user);
                    loginForm.setVisible(false);
                    mainForm.setVisible(true);
                }
            }
        }catch (Exception ex){
            messageLabel.setText(ex.toString());
        }
    }

    public boolean changePassword(User user){
        return userService.changePassword(user);
    }
}
