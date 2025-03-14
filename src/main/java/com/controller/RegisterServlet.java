package com.controller;

import com.dao.RegisterUserDao;
import com.model.Role;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddUser")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("password");
        String roleParam = request.getParameter("role");

        if (nom == null || email == null || email.trim().isEmpty() ||
                motDePasse == null || motDePasse.trim().isEmpty() ||
                roleParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
            return;
        }

        try {

            Role role = Role.valueOf(roleParam.toUpperCase());

            User user = new User();
            user.setNom(nom);
            user.setEmail(email);
            user.setMotDePasse(motDePasse);
            user.setRole(role);

            RegisterUserDao userDao = new RegisterUserDao();


            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", role.name());


            userDao.addUser(user);
            if (Role.RECRUTEUR.equals(role)) {
                response.sendRedirect("dashboardRec.jsp");
            }else
            {
                response.sendRedirect("OfferServlet");

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

