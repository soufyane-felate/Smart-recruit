package com.controller;


import com.dao.LoginDao;
import com.model.Role;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        LoginDao loginDao = new LoginDao();
        User user = loginDao.authenticateUser(email, password, role);
        if (user != null && email.equals(user.getEmail()) && password.equals(user.getMotDePasse())) {
            HttpSession session = request.getSession();
            session.setAttribute("role", user);
            if (role.equals("CANDIDAT")) {
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("dashboardRec.jsp");
            }
        } else {
            request.setAttribute("errorMessage", "Identifiants incorrects !");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

