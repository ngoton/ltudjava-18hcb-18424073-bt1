package com.sims;

import com.sims.view.LoginForm;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater( () -> new LoginForm() );
    }
}
