package dao;

import models.User;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Add a new user to the database
    public void addUser(User user) {
        String sql = "INSERT INTO User (name, email, age, weight) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getAge());
            statement.setDouble(4, user.getWeight());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a user by ID
    public User getUserById(int id) {
        String sql = "SELECT * FROM User WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getInt("age"),
                    resultSet.getDouble("weight")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update an existing user's profile details
    public boolean updateUser(User user) {
        String sql = "UPDATE User SET name = ?, email = ?, age = ?, weight = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getAge());
            statement.setDouble(4, user.getWeight());
            statement.setInt(5, user.getId());
            
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0; // If rowsUpdated > 0, update was successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if the update fails
    }
}
