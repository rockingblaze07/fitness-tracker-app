package com.fitnesstracker.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import dao.UserDAO;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/updateProfile")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles GET requests (for profile view)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("user");

        if (loggedInUser == null) {
            response.sendRedirect("login.jsp");
        } else {
            // Pass user data to JSP using EL
            request.setAttribute("user", loggedInUser);
            request.getRequestDispatcher("editProfile.jsp").forward(request, response);
        }
    }

    // Handles POST requests for updating the profile
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("user");

        if (loggedInUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Get new data from the form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Update user data
        loggedInUser.setUsername(username);
        loggedInUser.setEmail(email);

        if (password != null && !password.isEmpty()) {
            // Hash the password before saving (for security)
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            loggedInUser.setPassword(hashedPassword);
        }

        // Update user data in the database using UserDAO
        UserDAO userDAO = new UserDAO();
        boolean isUpdated = userDAO.updateUser(loggedInUser);

        if (isUpdated) {
            session.setAttribute("user", loggedInUser);  // Update session with new data
            response.sendRedirect("profile");  // Redirect to profile page
        } else {
            response.getWriter().write("Profile update failed. Please try again.");
        }
    }

    // Handle registration logic
    private void handleRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Hash the password before storing
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User newUser = new User(username, email, hashedPassword);
        UserDAO userDAO = new UserDAO();
        boolean isRegistered = userDAO.addUser(newUser);

        if (isRegistered) {
            response.getWriter().write("Registration successful! Welcome, " + username);
            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().write("Registration failed. Please try again.");
        }
    }

    // Handle login logic
    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User userFromDB = userDAO.getUserByEmail(email);

        if (userFromDB != null && BCrypt.checkpw(password, userFromDB.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userFromDB); // Set the user in the session
            response.sendRedirect("dashboard.jsp"); // Redirect to dashboard after successful login
        } else {
            response.getWriter().write("Invalid credentials! Please try again.");
        }
    }
}
