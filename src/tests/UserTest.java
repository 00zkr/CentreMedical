/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author User
 */
import dao.UserDao;
import entities.User;

public class UserTest {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        User newUser = new User("alice1@example.com", "Alice", "mypassword123");
        boolean signupSuccess = userDao.signup(newUser);

        if (signupSuccess) {
            System.out.println("Signup successful!");
        } else {
            System.out.println("Signup failed. Email may already exist.");
        }

        User loggedInUser = userDao.login("alice@example.com", "mypassword123");

        if (loggedInUser != null) {
            System.out.println("Login successful!");
            System.out.println("User ID: " + loggedInUser.getId());
            System.out.println("User Name: " + loggedInUser.getNom());
            System.out.println("User Email: " + loggedInUser.getEmail());
        } else {
            System.out.println("Login failed. Check email or password.");
        }
    }
}
