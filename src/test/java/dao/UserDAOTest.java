package dao;

import models.User;
import org.junit.jupiter.api.*;

import dao.UserDAO;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private static UserDAO userDAO;

    @BeforeAll
    static void setup() throws Exception {
        // Initialize UserDAO and the test database connection
        userDAO = new UserDAO();
        
        // Set up test database schema
        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS User (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(255) NOT NULL UNIQUE, " +
                    "age INT NOT NULL, " +
                    "weight DOUBLE NOT NULL" +
                    ");");
        }
    }

    @BeforeEach
    void clearDatabase() throws Exception {
        // Clear the table before each test
        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.execute("DELETE FROM User;");
        }
    }

    @AfterAll
    static void teardown() throws Exception {
        // Clean up test database after all tests
        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS User;");
        }
    }

    @Test
    void testAddUser() {
        User user = new User(0, "Alice", "alice@example.com", 25, 55.0);

        // Add user and verify
        userDAO.addUser(user);
        User retrievedUser = userDAO.getUserById(1);

        assertNotNull(retrievedUser, "User should be added to the database.");
        assertEquals("Alice", retrievedUser.getName(), "Name should match.");
        assertEquals("alice@example.com", retrievedUser.getEmail(), "Email should match.");
        assertEquals(25, retrievedUser.getAge(), "Age should match.");
        assertEquals(55.0, retrievedUser.getWeight(), "Weight should match.");
    }

    @Test
    void testGetUserById() {
        User user = new User(0, "Bob", "bob@example.com", 30, 75.0);

        // Add user and fetch by ID
        userDAO.addUser(user);
        User retrievedUser = userDAO.getUserById(1);

        assertNotNull(retrievedUser, "User should be retrieved by ID.");
        assertEquals("Bob", retrievedUser.getName(), "Name should match.");
        assertEquals("bob@example.com", retrievedUser.getEmail(), "Email should match.");
    }

    @Test
    void testUpdateUser() {
        User user = new User(0, "Charlie", "charlie@example.com", 40, 80.0);

        // Add user and update details
        userDAO.addUser(user);
        User existingUser = userDAO.getUserById(1);
        assertNotNull(existingUser, "User should exist before update.");

        existingUser.setName("Charles");
        existingUser.setAge(41);
        existingUser.setWeight(81.5);

        boolean isUpdated = userDAO.updateUser(existingUser);
        assertTrue(isUpdated, "User should be updated successfully.");

        User updatedUser = userDAO.getUserById(1);
        assertEquals("Charles", updatedUser.getName(), "Updated name should match.");
        assertEquals(41, updatedUser.getAge(), "Updated age should match.");
        assertEquals(81.5, updatedUser.getWeight(), "Updated weight should match.");
    }
}
