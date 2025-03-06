package com.controller;

import com.dao.CandidatDao;
import com.model.Candidat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AddCandidat")
public class AddCandidat extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");

        Candidat candidat = new Candidat();
        candidat.setNom(nom);
        candidat.setEmail(email);
        CandidatDao candidatDao = new CandidatDao();

        try {
            candidatDao.addCandidat(candidat);
        } catch (Exception e) {
            throw new ServletException("Database error", e);
        }

        response.sendRedirect("listCandidat.jsp");
    }
}









