package com.fitnesstracker.models;

public class Workout {
    private int id;
    private int userId;
    private String date;
    private String activity;
    private int duration;
    private int caloriesBurned;

    // Constructor
    public Workout(int id, int userId, String date, String activity, int duration, int caloriesBurned) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.activity = activity;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    // Constructor for adding a workout (without ID, as it's auto-generated by DB)
    public Workout(int userId, String date, String activity, int duration, int caloriesBurned) {
        this.userId = userId;
        this.date = date;
        this.activity = activity;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public String getActivity() {
        return activity;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    // Setters (if needed)
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }
}
