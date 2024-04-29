package userregistry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class UserRegistry extends JFrame implements ActionListener {
    private JTextField usernameField, emailField, passwordField, addressField;
    private JButton createBtn, readBtn, updateBtn, deleteBtn;
    private HashMap<String, User> userMap;

    public UserRegistry() {
        setTitle("User Registration System - Gappi, Rien Miro M. (Activity 2)");
        setSize(500, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        usernameField = new JTextField(5);
        emailField = new JTextField(5);
        passwordField = new JTextField(5);
        addressField = new JTextField(5);

        createBtn = new JButton("Create");
        readBtn = new JButton("Read");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");

        // Add action listeners
        createBtn.addActionListener(this);
        readBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        // Add components to the frame
        JPanel panel = new JPanel(new GridLayout(9, 20));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(createBtn);
        panel.add(readBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);

        add(panel);

        // Initialize user HashMap
        userMap = new HashMap<>();

        userMap.put("default", new User("default", "default@example.com", "password", "default"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createBtn) {
            createUser();
        } else if (e.getSource() == readBtn) {
            readUser();
        } else if (e.getSource() == updateBtn) {
            updateUser();
        } else if (e.getSource() == deleteBtn) {
            deleteUser();
        }
    }

    private void createUser() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String address = addressField.getText();

        // Check username
        if (userMap.containsKey(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new user and add it to the HashMap
        User newUser = new User(username, email, password, address);
        userMap.put(username, newUser);
        JOptionPane.showMessageDialog(this, "Account created successfully!");
    }

    private void readUser() {
        // Example: Reading user data
        String username = usernameField.getText();
        User user = userMap.get(username);
        if (user != null) {
            JOptionPane.showMessageDialog(this, user.toString(), "User Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateUser() {
        // Example: Updating user data
        String username = usernameField.getText();
        if (userMap.containsKey(username)) {
            String email = emailField.getText();
            String password = passwordField.getText();
            String address = addressField.getText();
            User updatedUser = new User(username, email, password, address);
            userMap.put(username, updatedUser);
            JOptionPane.showMessageDialog(this, "User updated successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteUser() {
        // Example: Deleting user data
        String username = usernameField.getText();
        if (userMap.containsKey(username)) {
            userMap.remove(username);
            JOptionPane.showMessageDialog(this, "User deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UserRegistry().setVisible(true);
        });
    }

    // User class representing user data
    private class User {
        private String username;
        private String email;
        private String password;
        private String address;

        public User(String username, String email, String password, String address) {
            this.username = username;
            this.email = email;
            this.password = password;
             this.password = address;
        }

        @Override
        public String toString() {
            return "Username: " + username + "\nEmail: " + email + "\nPassword: " + password + "\nAddress: " + address;
        }
    }
}
