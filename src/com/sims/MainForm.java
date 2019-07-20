package com.sims;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    public MainForm(){
        super("QUẢN LÝ SINH VIÊN");
        FlowLayout mainLayout = new FlowLayout();
        setLayout(mainLayout);

        JPanel mainPanel = new JPanel(mainLayout);

        LoginForm loginForm = new LoginForm();
        mainPanel.add(loginForm);
        add(mainPanel);
    }
    private void showLoginFrom(){
        LoginForm loginForm = new LoginForm();
    }
}
