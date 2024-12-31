CREATE DATABASE FitnessPlanner;

USE FitnessPlanner;

CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT,
    weight DECIMAL(5, 2)
);

CREATE TABLE FoodLog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    date DATE,
    food_item VARCHAR(100),
    calories DECIMAL(5, 2),
    FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE WorkoutLog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    date DATE,
    workout_type VARCHAR(100),
    duration DECIMAL(5, 2),
    calories_burned DECIMAL(5, 2),
    FOREIGN KEY (user_id) REFERENCES User(id)
);
