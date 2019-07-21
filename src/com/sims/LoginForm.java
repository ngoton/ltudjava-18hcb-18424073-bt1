package com.sims;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JPanel {
    private JPanel panel;
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public LoginForm(){
        initComponents();
    }

    private void initComponents() {
        panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        titleLabel = new JLabel("ĐĂNG NHẬP");
        titleLabel.setFont(new Font("Arial", 1, 24));
        titleLabel.setForeground(new Color(338500));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        usernameLabel = new JLabel("Tên đăng nhập");
        passwordLabel = new JLabel("Mật khẩu");

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(250,30));

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(250,30));

        loginButton = new JButton("Đăng nhập");
        cancelButton = new JButton("Hủy");

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(titleLabel)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(usernameLabel)
                                                        .addComponent(passwordLabel))
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(usernameField)
                                                        .addComponent(passwordField)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(loginButton)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                                                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                        )
                                                )
                                        )
                                )
                                .addContainerGap()
                        )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(titleLabel)
                                )
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameLabel)
                                        .addComponent(usernameField)
                                )
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordField)
                                )
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton)
                                        .addComponent(cancelButton)
                                )
                                .addGap(89, 89, 89)
                        )
        );

        add(panel);
    }
}
