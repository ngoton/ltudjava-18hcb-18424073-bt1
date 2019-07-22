package com.sims;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    public MainForm(){
        super("QUẢN LÝ SINH VIÊN");
        /*Toolkit toolkit = Toolkit.getDefaultToolkit();
        int xSize = ((int) toolkit.getScreenSize().getWidth());
        int ySize = ((int) toolkit.getScreenSize().getHeight());
        int height = (int) (Math.round(ySize * 0.80));
        int width = (int) (Math.round(xSize * 0.80));
        setPreferredSize(new Dimension(width, height));
        */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentsToPane(getContentPane());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addComponentsToPane(Container contentPane) {
        CardLayout card = new CardLayout();
        JPanel mainPanel = new JPanel();
        LoginForm loginForm = new LoginForm();
        mainPanel.add(loginForm, "login");
        mainPanel.setLayout(card);
        card.show(mainPanel, "login");
        contentPane.add(mainPanel);
    }
}
