package com.sims;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainForm.setSize(600, 500);
        mainForm.setResizable(false);
        mainForm.setVisible(true);
    }
}
