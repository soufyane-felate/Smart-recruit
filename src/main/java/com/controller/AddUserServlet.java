package com.controller;

import com.dao.RegisterUserDao;
import com.model.Role;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String motDePasse = request.getParameter("password");
        String roleParam = request.getParameter("role");

        if (email == null || email.trim().isEmpty() ||
                motDePasse == null || motDePasse.trim().isEmpty() ||
                roleParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
            return;
        }

        try {

            Role role = Role.valueOf(roleParam.toUpperCase());

            User user = new User();
            user.setEmail(email);
            user.setMotDePasse(motDePasse);
            user.setRole(role);

            RegisterUserDao userDao = new RegisterUserDao();
            userDao.addUser(user);
            if (Role.RECRUTEUR.equals(role)) {
                response.sendRedirect("dashboardRec.jsp");
            }else
            {
                response.sendRedirect("home.jsp");

            }
        } catch (IllegalArgumentException e) {
            // Invalid role
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid role");
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Error registering user: " + e.getMessage());
        }
    }
}

