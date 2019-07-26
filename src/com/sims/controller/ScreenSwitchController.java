package com.sims.controller;

import com.sims.bean.MenuBean;
import com.sims.view.LoginForm;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScreenSwitchController {
    private JFrame frame;
    private JPanel panel;
    private JToolBar toolBar;
    private JButton previousButton;

    public ScreenSwitchController(){}
    public ScreenSwitchController(JFrame frame){
        this.frame = frame;
    }
    public ScreenSwitchController(JFrame frame, JPanel panel, JToolBar toolBar){
        this.frame = frame;
        this.panel = panel;
        this.toolBar = toolBar;
    }
    public void setFirstPanel(JPanel panel, JButton button){
        this.panel.add(panel, BorderLayout.CENTER);
        this.previousButton = button;
        button.setForeground(new Color(26316));
    }
    public void setEvent(List<MenuBean> listItem){
        for (MenuBean item : listItem){
            item.getButton().addActionListener(e -> {
                if (item.getName().equals("login")){
                    frame.setVisible(false);
                    LoginForm loginForm = new LoginForm();
                    loginForm.setVisible(true);
                }
                else {
                    panel.removeAll();
                    panel.add(toolBar, BorderLayout.PAGE_START);
                    panel.add(item.getPanel(), BorderLayout.CENTER);
                    previousButton.setForeground(Color.BLACK);
                    item.getButton().setForeground(new Color(26316));
                    previousButton = item.getButton();
                    frame.pack();
                    frame.validate();
                    frame.repaint();
                }

            });
        }
    }
}
