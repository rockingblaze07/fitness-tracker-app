package dao;

import com.fitnesstracker.models.Workout;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FitnessDAO {

    // Add a workout to the database
    public boolean addWorkout(Workout workout) {
        String sql = "INSERT INTO Workouts (user_id, date, activity, duration, calories_burned) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, workout.getUserId());
            statement.setString(2, workout.getDate());
            statement.setString(3, workout.getActivity());
            statement.setInt(4, workout.getDuration());
            statement.setInt(5, workout.getCaloriesBurned());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0; // Return true if the workout was added successfully
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if the operation failed
    }

    // Retrieve workouts for a specific user
    public List<Workout> getWorkoutsByUserId(int userId) {
        List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT * FROM Workouts WHERE user_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                workouts.add(new Workout(
                    resultSet.getInt("id"),
                    resultSet.getInt("user_id"),
                    resultSet.getString("date"),
                    resultSet.getString("activity"),
                    resultSet.getInt("duration"),
                    resultSet.getInt("calories_burned")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workouts;
    }
}
