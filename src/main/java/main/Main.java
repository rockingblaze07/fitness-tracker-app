package main;
import dao.UserDAO;
import models.User;
public class Main {
     public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User newUser = new User(0, "John Doe", "john.doe@example.com", 30, 70.5);

        // Add a new user to the database
        userDAO.addUser(newUser);

        // Retrieve and print user details
        User retrievedUser = userDAO.getUserById(1);
        if (retrievedUser != null) {
            System.out.println("User retrieved: " + retrievedUser.getName());
        } else {
            System.out.println("User not found.");
        }
    }
}
