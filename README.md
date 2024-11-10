# Fitness Tracking and Nutritional Planner

This is a **Fitness Tracking and Nutritional Planner** web application designed to help users track their fitness progress, plan workouts, and maintain a balanced diet. The application allows users to log exercises, monitor calories, set nutrition goals, and follow personalized meal plans for a healthier lifestyle.

## Features

- **User Authentication**: Sign up, log in, and manage user profiles.
- **Fitness Tracker**: Log workouts, track exercises, sets, reps, and workout durations.
- **Nutritional Planner**: Track meals, set daily calorie and macronutrient goals (protein, carbs, fats).
- **Food Database**: Search and select food items to log nutritional information.
- **Progress Dashboard**: Visualize fitness and nutrition data with graphs and summaries.
- **Goal Setting**: Set and track personal fitness and nutrition goals.
- **Meal Plan Generator**: Automatically generate meal plans based on dietary preferences (e.g., vegetarian, keto).

## Technologies Used

- **Frontend**: 
  - HTML5, CSS3, JavaScript
  - React (for a dynamic and responsive UI)
  - Bootstrap (for styling and responsive design)
  
- **Backend**:
  - Java (Spring Boot for server-side logic and RESTful API)
  - MySQL (for storing user data, fitness logs, and nutritional information)
  - JDBC (for database connectivity)

- **Authentication**:
  - JWT (JSON Web Tokens) for secure user authentication

- **Data Visualization**:
  - Chart.js (for fitness progress graphs)

## Project Components

### 1. **Frontend (React Application)**

The frontend is built using **React**, which provides a dynamic, interactive user interface. The components of the frontend include:

- **Dashboard**: Displays user progress with fitness and nutrition data, including charts and stats.
- **Login/Signup Pages**: Allows users to log in or create an account to access their personalized data.
- **Workout Tracker**: Allows users to log exercises, sets, reps, and weights lifted.
- **Meal Planner**: Provides options for users to log food, track calories, and set goals.
- **Meal Plan Generator**: A tool to automatically create meal plans based on user preferences.
- **Food Database Search**: Users can search for foods and view nutritional values to log into their daily intake.
- **Progress Visualization**: Graphs and charts that show progress over time, like calories consumed vs. goal, weight lifted, etc.

### 2. **Backend (Spring Boot Application)**

The backend is powered by **Spring Boot**, handling business logic and data processing. Key components include:

- **User Authentication**: Manages user registration, login, and authentication using **JWT** tokens.
- **Workout Logging**: API endpoints to log and retrieve exercises and workouts.
- **Meal Logging**: API for logging meals, tracking calories, and setting nutrition goals.
- **Food Database**: Provides endpoints to search and store food nutritional information.
- **Progress Tracking**: Provides data for user progress, including fitness achievements and diet goals.
- **RESTful API**: Exposes REST API endpoints for frontend interaction, allowing users to access their data securely.

### 3. **Database (MySQL)**

The MySQL database stores all data related to users, workouts, meals, and progress. Key components include:

- **User Table**: Stores user credentials, profile information, and preferences.
- **Workout Table**: Stores workout logs (exercise name, sets, reps, weight lifted, duration, etc.).
- **Meal Table**: Stores meal logs (food items, quantity, calories, macronutrients).
- **Food Database Table**: A reference table for food items and their nutritional values.
- **Progress Table**: Stores data for tracking user progress over time (e.g., weight lifted, calories consumed).

### 4. **Database Connectivity (JDBC)**

- **JDBC (Java Database Connectivity)** is used to interact with the MySQL database from the backend application.
- DAO (Data Access Object) classes are used to perform CRUD operations (Create, Read, Update, Delete) for data in the database.
- JDBC helps in managing the connection, executing queries, and processing results from the database.

### 5. **Security (JWT Authentication)**

- **JWT (JSON Web Tokens)** is used for secure, stateless user authentication.
- On login, the backend generates a token and sends it to the frontend.
- The frontend stores this token and includes it in subsequent requests to authenticate the user.

## Installation

Follow these steps to run the project locally:

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/fitness-tracking-nutritional-planner.git
cd fitness-tracking-nutritional-planner
