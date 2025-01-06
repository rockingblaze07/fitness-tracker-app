package models;

public class Workout {
    private int id;
    private int userId;
    private String date;
    private String activity;
    private int duration;
    private int caloriesBurned;

    public Workout(int userId, String date, String activity, int duration, int caloriesBurned) {
        this.userId = userId;
        this.date = date;
        this.activity = activity;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public Workout(int id, int userId, String date, String activity, int duration, int caloriesBurned) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.activity = activity;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    // Getters and Setters
}
