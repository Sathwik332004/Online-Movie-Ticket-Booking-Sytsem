package gui;

import database.UserDAO;

import models.User;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JButton registerButton, backButton;

    public RegisterFrame() {
        setTitle("User Registration");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Register", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(100, 20, 200, 30);
        add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 70, 180, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 110, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 110, 180, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 180, 25);
        add(passwordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(150, 200, 120, 30);
        add(registerButton);

        backButton = new JButton("Back");
        backButton.setBounds(150, 240, 120, 30);
        add(backButton);

        registerButton.addActionListener(e -> registerUser());
        backButton.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }

    private void registerUser() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User newUser = new User(0, name, email, password, "customer");
        boolean success = UserDAO.registerUser(newUser);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registration successful! Please log in.");
            dispose();
            new LoginFrame();
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed. Email might be already registered.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
