package com.sims;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    private JPanel loginPanel;
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public LoginForm(){
        initComponents();
        this.setLocationRelativeTo(null);// center form in the screen
    }

    private void initComponents() {
        loginPanel = new JPanel();
        titleLabel = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        usernameField = new JTextField();
        loginButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel.setFont(new Font("Arial", 0, 20));
        titleLabel.setForeground(new Color(236, 240, 241));
        titleLabel.setText("ĐĂNG NHẬP");

        usernameLabel.setText("Tên đăng nhập");
        passwordLabel.setText("Mật khẩu");

        loginButton.setText("Đăng nhập");
        cancelButton.setText("Hủy");

        GroupLayout loginLayout = new GroupLayout(loginPanel);
        loginPanel.setLayout(loginLayout);

        pack();
    }
}
