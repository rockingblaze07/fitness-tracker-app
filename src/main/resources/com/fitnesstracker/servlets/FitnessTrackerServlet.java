package com.fitnesstracker.servlets;

import com.fitnesstracker.dao.FitnessDAO;
import com.fitnesstracker.models.Workout;
import com.fitnesstracker.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/fitnessTracker")
public class FitnessTrackerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles GET requests for fetching workout data
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }

        // Get the list of workouts for the user
        FitnessDAO fitnessDAO = new FitnessDAO();
        List<Workout> workouts = fitnessDAO.getWorkouts(user.getId());

        // Set the workouts as a request attribute and forward to JSP
        request.setAttribute("workoutList", workouts);
        request.getRequestDispatcher("fitnessTracker.jsp").forward(request, response);
    }

    // Handles POST requests for adding new workout data
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }

        // Extract workout data from the form
        String date = request.getParameter("date");
        String activity = request.getParameter("activity");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int caloriesBurned = Integer.parseInt(request.getParameter("calories"));

        // Save workout to the database
        FitnessDAO fitnessDAO = new FitnessDAO();
        fitnessDAO.addWorkout(user.getId(), date, activity, duration, caloriesBurned);

        // Redirect back to the fitness tracker page
        response.sendRedirect("fitnessTracker");
    }
}
