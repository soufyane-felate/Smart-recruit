package com.controller;

import com.model.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/Recruteur")
public class RecruteurServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || Role.RECRUTEUR.equals(session.getAttribute("Role"))) {
            response.sendRedirect(request.getContextPath() + "/home.jsp");
            return;
        }
            response.setContentType("text/html");
            response.getWriter().println("<h1>Bienvenue sur l'espace recruteur !</h1>");
        }
    }

